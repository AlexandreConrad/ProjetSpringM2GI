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
     * @param updateSurvey
     * @return survey
     */
    public static Survey updateSurvey(Long surveyID, Survey updateSurvey) {

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
        survey.setName(updateSurvey.getName());
        survey.setDescription(updateSurvey.getDescription());
        survey.setIsAvailable(updateSurvey.getIsAvailable());
        survey.setEndDate(updateSurvey.getEndDate());

        //Mise à jour du survey
        session.update(survey);

        transaction.commit();
        log.info("Fonction updateSurvey => OK");
        return survey;
    }

    /**
     * Fonction qui permet la clôture d'un survey
     * @param surveyID
     * @return
     */
    public static Survey endSurvey(Long surveyID) {

        Session session = HibernateUtil.getSession();//Ouverture d'une session
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaUpdate<Survey> update = builder.createCriteriaUpdate(Survey.class);
        Root<Survey> root = update.from(Survey.class);

        update.set(root.get("isAvailable"),0);
        update.where(builder.equal(root.get("id_survey"),surveyID));
        Transaction transaction = session.beginTransaction();//Ouverture d'une transaction en cas de problème
        session.createQuery(update).executeUpdate();

        transaction.commit();
        log.info("Fonction endSurvey => OK");
        return null;

        /**  Code à retenir pour un select
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Survey> cq = builder.createQuery(Survey.class);
        Root<Survey> stud = cq.from(Survey.class);
        cq.select(stud).where(builder.equal(stud.get("id_survey"),surveyID));
        Query<Survey> query = session.createQuery(cq);
        List<Survey> results = query.getResultList();

        for(Survey s : results)
            System.out.println(s.getName());
        **/
    }

    /**
     * Fonction qui permet la création d'un Survey
     * @param sondage
     * @return
     */
    public static Survey createSurvey(Survey sondage) {

        /** Création d'un sondage
        {
            "name": "Test update",
                "description": "update sondage !",
                "endDate": 1606669212000
        }
        **/

        //Création du survey avec les informations
        Survey survey = new Survey();
        survey.setIsAvailable(true);
        survey.setName(sondage.getName());
        survey.setDescription(sondage.getDescription());
        survey.setEndDate(sondage.getEndDate());

        //Persistance dans la base de données
        Session session = HibernateUtil.getSession();//Ouverture d'une session
        Transaction transaction = session.beginTransaction();//Ouverture d'une transaction en cas de problème
        session.persist(survey);
        transaction.commit();
        log.info("Fonction createSurvey => OK");

        return survey;
    }
}