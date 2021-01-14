package io.swagger.service;

import io.swagger.exceptions.BadRequestException;
import io.swagger.exceptions.DatabaseException;
import io.swagger.exceptions.NotFoundException;
import io.swagger.model.Survey;
import io.swagger.util.ServicesUtil;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Service pour toutes les requêtes BDD en liaison "Survey"
 */
public final class SurveyService {

    private static final Logger log = LoggerFactory.getLogger(SurveyService.class);
    private SurveyService(){}

    /**
     * Retourne un survey par ID
     *
     * @return survey
     */
    public static Survey getSurveyByID(Long surveyID) throws NotFoundException, DatabaseException {

        Session session = ServicesUtil.createSession();
        Transaction transaction = ServicesUtil.createTransaction(session);

        try{

            Survey survey = session.load(Survey.class, surveyID);//Récupération du sondage
            survey.getName();   //Lancement de l'erreur ObjectNotFoundException
            transaction.commit();//Annule les changements en cas de problème
            log.info("Fonction getSurveyByID => OK");
            return survey;

        }catch(ObjectNotFoundException e){ // Gestion exception par Hibernate

            transaction.rollback(); // Annule les changements
            throw new NotFoundException("SurveyByID non trouvé !");

        }
    }

    /**
     * Retourne tous les surveys
     *
     * @return List<Survey>
     */
    public static List<Survey> getSurveys() throws DatabaseException, NotFoundException {

        Session session = ServicesUtil.createSession();
        Transaction transaction = ServicesUtil.createTransaction(session);

        try{

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Survey> criteria = builder.createQuery(Survey.class); //Récupération de tous les sondages
            criteria.from(Survey.class);
            List<Survey> surveys = session.createQuery(criteria).getResultList();
            transaction.commit();
            surveys.size(); // => survey not found
            log.info("Fonction getSurveys => OK");
            return surveys;

        }catch(ObjectNotFoundException e){ // Gestion exception par Hibernate

            transaction.rollback(); // Annule les changements
            throw new NotFoundException("getSurveys non trouvé !");

        }
    }

    /**
     * Retourne tous les surveys actifs
     *
     * @return List<Survey>
     */
    public static List<Survey> getSurveysIsActives() throws DatabaseException, NotFoundException {

        try{
            List<Survey> surveys = getSurveysIsActivesOrExpireds(true);
            log.info("Fonction getSurveysIsActives => OK");
            surveys.size(); // => survey not found
            return surveys;
        }catch(ObjectNotFoundException e){ // Gestion exception par Hibernate
            throw new NotFoundException("getSurveysIsActives non trouvé !");
        }
    }

    /**
     * Retourne tous les Surveys inactifs
     *
     * @return List<Survey>
     */
    public static List<Survey> getSurveysIsExpireds() throws DatabaseException, NotFoundException {
        try{
            List<Survey> surveys = getSurveysIsActivesOrExpireds(false);
            log.info("Fonction getSurveysIsExpireds => OK");
            surveys.size(); // => survey not found
            return surveys;
        }catch(ObjectNotFoundException e){ // Gestion exception par Hibernate
            throw new NotFoundException("getSurveysIsExpireds non trouvé !");
        }
    }

    /**
     * Fonction qui retourne tous les Surveys actifs ou inactifs à l'aide du boolean en entrée
     *
     * @param bool
     * @return List<Survey>
     */
    private static List<Survey> getSurveysIsActivesOrExpireds(Boolean bool) throws DatabaseException {
        Session session = ServicesUtil.createSession();
        Transaction transaction = ServicesUtil.createTransaction(session);
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
     *
     * @param surveyID
     * @return survey
     */
    public static Survey deleteSurvey(Long surveyID) throws DatabaseException, NotFoundException {

        /** Exceptions **/
        getSurveyByID(surveyID); // => survey not found

        Session session = ServicesUtil.createSession();
        Transaction transaction = ServicesUtil.createTransaction(session);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaDelete<Survey> delete = builder.createCriteriaDelete(Survey.class);
        Root<Survey> e = delete.from(Survey.class);
        delete.where(builder.equal(e.get("idSurvey"), surveyID));
        session.createQuery(delete).executeUpdate();
        log.info("Fonction deleteSurvey => OK");
        transaction.commit();//Annule les changements en cas de problème
        return null;
    }

    /**
     * Mise a jour d'un survey depuis une ID.
     *
     * @param surveyID
     * @param updateSurvey
     * @return survey
     */
    public static Survey updateSurvey(Long surveyID, Survey updateSurvey) throws DatabaseException, BadRequestException, NotFoundException {

        /** Test de mise a jour
         {
         "id_survey": 2,
         "name": "Test update",
         "description": "update sondage !",
         "isAvailable": true,
         "endDate": 1606669212000
         }
         */

        /** Exceptions **/
        if(surveyID == null || updateSurvey == null)    // => BadRequestException
            throw new BadRequestException("Fonction updateSurvey => informations non valide !");
        getSurveyByID(surveyID); // => survey not found

        Session session = ServicesUtil.createSession();
        Transaction transaction = ServicesUtil.createTransaction(session);
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
     *
     * @param surveyID
     * @return
     */
    public static Survey endSurvey(Long surveyID) throws DatabaseException, NotFoundException, BadRequestException {

        /** Exceptions **/
        if(surveyID == null)    // => BadRequestException
            throw new BadRequestException("Fonction endSurvey => informations non valide !");
        getSurveyByID(surveyID); // => survey not found

        Session session = ServicesUtil.createSession();
        Transaction transaction = ServicesUtil.createTransaction(session);
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaUpdate<Survey> update = builder.createCriteriaUpdate(Survey.class);
        Root<Survey> root = update.from(Survey.class);

        update.set(root.get("isAvailable"), 0);
        update.where(builder.equal(root.get("idSurvey"), surveyID));
        session.createQuery(update).executeUpdate();

        transaction.commit();
        log.info("Fonction endSurvey => OK");
        return null;
    }

    /**
     * Fonction qui permet la création d'un Survey
     *
     * @param sondage
     * @return
     */
    public static Survey createSurvey(Survey sondage) throws DatabaseException, BadRequestException {

        /** Création d'un sondage
         {
         "name": "Test update",
         "description": "update sondage !",
         "endDate": 1606669212000
         }
         **/

        /** Exception 400 Bad Request **/
        if(sondage == null || sondage.getName() == null || sondage.getDescription() == null)
            throw new BadRequestException("Fonction createSurvey => informations non valide !");

        //Création du survey avec les informations
        Survey survey = new Survey();
        survey.setIsAvailable(true);
        survey.setName(sondage.getName());
        survey.setDescription(sondage.getDescription());
        survey.setEndDate(sondage.getEndDate());

        //Persistance dans la base de données
        Session session = ServicesUtil.createSession(); //Ouverture d'une session
        Transaction transaction = ServicesUtil.createTransaction(session); //Ouverture d'une transaction en cas de problème
        session.persist(survey);
        transaction.commit();
        log.info("Fonction createSurvey => OK");
        return survey;

    }
}
