package io.swagger.service;

import io.swagger.api.SurveysApiController;
import io.swagger.model.Survey;
import io.swagger.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}
