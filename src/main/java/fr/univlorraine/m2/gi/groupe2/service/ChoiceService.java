package fr.univlorraine.m2.gi.groupe2.service;

import fr.univlorraine.m2.gi.groupe2.exceptions.BadRequestException;
import fr.univlorraine.m2.gi.groupe2.exceptions.DatabaseException;
import fr.univlorraine.m2.gi.groupe2.exceptions.NotFoundException;
import fr.univlorraine.m2.gi.groupe2.model.Choice;

import fr.univlorraine.m2.gi.groupe2.model.Survey;
import fr.univlorraine.m2.gi.groupe2.util.ServicesUtil;
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
public final class ChoiceService {

    private static final Logger log = LoggerFactory.getLogger(ChoiceService.class);
    private ChoiceService(){}

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
        Root<? extends Choice> e = delete.from(Choice.class);
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
