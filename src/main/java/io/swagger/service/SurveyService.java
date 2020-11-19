package io.swagger.service;

import io.swagger.api.SurveysApiController;
import io.swagger.model.Survey;
import io.swagger.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
        log.debug("Fonction getSurveyByID => OK");
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
        log.debug("Fonction getSurveys => OK");
        return surveys;
    }
}
