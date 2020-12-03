package io.swagger.service;

import io.swagger.api.SurveysApiController;
import io.swagger.model.Survey;
import io.swagger.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Service pour toutes les requêtes BDD en liaison "Survey"
 */
public class SurveyService {

    private static final Logger log = LoggerFactory.getLogger(SurveysApiController.class);

    /**
     * Retourne un survey par ID
     * @return survey
     */
    public static Survey getSurveyByID(Long surveyID){
        Session session = HibernateUtil.getSession();//Ouverture d'une session
        Transaction transaction = session.beginTransaction();//Ouverture d'une transaction en cas de problème
        Survey survey = session.load(Survey.class, surveyID);//Récupération du sondage
        transaction.commit();//Annule les changements en cas de problème
        log.info("Fonction getSurveyByID => OK");
        return survey;
    }

    /**
     * Retourne tous les surveys
     * @return List<Survey>
     */
    public static List<Survey> getSurveys(){
        Session session = HibernateUtil.getSession();//Ouverture d'une session
        Transaction transaction = session.beginTransaction();//Ouverture d'une transaction en cas de problème
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Survey> criteria = builder.createQuery(Survey.class); //Récupération de tous les sondages
        criteria.from(Survey.class);
        List<Survey> surveys = session.createQuery(criteria).getResultList();
        transaction.commit();
        log.info("Fonction getSurveys => OK");
        return surveys;
    }

    /**
     * Retourne tous les surveys actifs
     * @return List<Survey>
     */
    public static List<Survey> getSurveysIsActives() {
        List<Survey> surveys = getSurveysIsActivesOrExpireds(true);
        log.info("Fonction getSurveysIsActives => OK");
        return surveys;
    }

    /**
     * Retourne tous les Surveys inactifs
     * @return List<Survey>
     */
    public static List<Survey> getSurveysIsExpireds() {
        List<Survey> surveys = getSurveysIsActivesOrExpireds(false);
        log.info("Fonction getSurveysIsExpireds => OK");
        return surveys;
    }

    /**
     * Fonction qui retourne tous les Surveys actifs ou inactifs à l'aide du boolean en entrée
     * @param bool
     * @return List<Survey>
     */
    private static List<Survey> getSurveysIsActivesOrExpireds(Boolean bool){
        Session session = HibernateUtil.getSession();   //Ouverture d'une session
        Transaction transaction = session.beginTransaction();       //Ouverture d'une transaction en cas de problème
        CriteriaBuilder builder = session.getCriteriaBuilder();     //Création d'une requête
        CriteriaQuery<Survey> criteria = builder.createQuery(Survey.class); //Récupération de tous les surveys
        Root<Survey> myObjectRoot = criteria.from(Survey.class);            //Représentation d'un objet
        criteria.select(myObjectRoot).where(myObjectRoot.get("isAvailable").in(bool)); //Requête SQL
        TypedQuery<Survey> surveys = session.createQuery(criteria);
        transaction.commit();
        log.info("Fonction getSurveysIsActivesOrExpireds => OK");
        return surveys.getResultList();
    }

    /**
     * Supprime le survey depuis surveyID
     * @param surveyID
     * @return survey
     */
    public static Survey deleteSurvey(Long surveyID){
        Session session = HibernateUtil.getSession();//Ouverture d'une session
        Transaction transaction = session.beginTransaction();//Ouverture d'une transaction en cas de problème
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaDelete<Survey> delete = builder.createCriteriaDelete(Survey.class);
        Root e = delete.from(Survey.class);
        delete.where(builder.equal(e.get("id_survey"), surveyID));
        session.createQuery(delete).executeUpdate();
        log.info("Fonction deleteSurvey => OK");
        transaction.commit();//Annule les changements en cas de problème
        return null;
    }

    /**
     * Mise a jour d'un survey depuis une ID.
     * @param surveyID
     * @param update
     * @return survey
     */
    public static Survey updateSurvey(Long surveyID, Survey update) {

        /** Test de mise a jour
         {
         "id_survey": 2,
         "name": "Test update",
         "description": "update sondage !",
         "isAvailable": true,
         "endDate": 1606669212000
         }
         */

        Session session = HibernateUtil.getSession();//Ouverture d'une session
        Transaction transaction = session.beginTransaction();//Ouverture d'une transaction en cas de problème
        Survey survey = session.load(Survey.class, surveyID);//Récupération du sondage
        //Modification par les nouvelles valeurs
        survey.setName(update.getName());
        survey.setDescription(update.getDescription());
        survey.setIsAvailable(update.getIsAvailable());
        survey.setEndDate(update.getEndDate());
        transaction.commit();
        log.info("Fonction updateSurvey => OK");
        return survey;
    }
}
