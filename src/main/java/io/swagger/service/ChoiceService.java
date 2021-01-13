package io.swagger.service;

import io.swagger.api.ChoicesApiController;
import io.swagger.exceptions.BadRequestException;
import io.swagger.exceptions.DatabaseException;
import io.swagger.exceptions.NotFoundException;
import io.swagger.model.Choice;

import io.swagger.model.Survey;
import io.swagger.util.ServicesUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.criteria.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Service pour toutes les requêtes BDD en liaison "Choices"
 */
public class ChoiceService {

    private static final Logger log = LoggerFactory.getLogger(ChoicesApiController.class);

    /**
     * Retourne tous les choix d'un sondage
     *
     * @param surveyID
     * @return
     */
    public static List<Choice> getChoiceById(Long surveyID) throws DatabaseException, NotFoundException {

        SurveyService.getSurveyByID(surveyID); // ExceptionNotFound

        Session session = ServicesUtil.createSession();
        Transaction transaction = ServicesUtil.createTransaction(session);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Choice> cq = builder.createQuery(Choice.class);
        Root<Choice> stud = cq.from(Choice.class);
        cq.select(stud).where(builder.equal(stud.get("idSurvey"), surveyID));
        Query<Choice> query = session.createQuery(cq);
        List<Choice> choices = query.getResultList();
        transaction.commit();//Annule les changements en cas de problème
        log.info("Fonction getChoice => OK");
        return choices;
    }

    /**
     * Delete le choix passé en parametre
     *
     * @param choiceID
     * @return
     */
    public static Choice getDeleteById(Long choiceID) throws DatabaseException, NotFoundException {

        ChoiceService.getChoiceById(choiceID); // ExceptionNotFound

        Session session = ServicesUtil.createSession();
        Transaction transaction = ServicesUtil.createTransaction(session);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaDelete<Choice> delete = builder.createCriteriaDelete(Choice.class);
        Root e = delete.from(Choice.class);
        delete.where(builder.equal(e.get("idChoice"), choiceID));
        session.createQuery(delete).executeUpdate();
        log.info("Fonction deleteChoice => OK");
        transaction.commit();//Annule les changements en cas de problème
        return null;
    }

    /**
     * Ajoute un choix
     *
     * @param choice
     * @param surveyID
     * @return
     */
    public static Choice postChoiceById(Timestamp choice,Long surveyID) throws DatabaseException, BadRequestException, NotFoundException {

        // Exceptions => 400
        if(choice == null || surveyID == null)
            throw new BadRequestException("Fonction postChoiceById => informations non valide !");

        // Exceptions NotFound   => 404
        Survey survey = SurveyService.getSurveyByID(surveyID);
        survey.getName();

        // Exceptions 409
        if(choice.after(survey.getEndDate()))
            throw new BadRequestException("Fonction postChoiceById => Date surpérieur à la date de fin !");

        // TODO a FIX
        if(survey.getIsAvailable())
            throw new BadRequestException("Fonction postChoiceById => Le sondage est fini !");

        //Création du choix
        Choice cho = new Choice();
        cho.setDate(choice);
        cho.setIdSurvey(surveyID);

        //Persistance dans la base de données
        Session session = ServicesUtil.createSession();
        Transaction transaction = ServicesUtil.createTransaction(session);
        session.persist(cho);
        transaction.commit();
        log.info("Fonction postChoice => OK");
        return cho;
    }


}
