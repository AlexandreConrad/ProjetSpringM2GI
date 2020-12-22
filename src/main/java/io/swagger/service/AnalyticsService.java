package io.swagger.service;

import io.swagger.api.AnalyticsApiController;
import io.swagger.model.Analytics;
import io.swagger.model.MostMaybe;
import io.swagger.model.MostPossible;
import io.swagger.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Service pour toutes les requêtes BDD en liaison "Analytics"
 */
public class AnalyticsService {

    private static final Logger log = LoggerFactory.getLogger(AnalyticsApiController.class);

    /**
     * Retourne la date qui dispose du plus de "Disponible" et "Peut-être"
     * @return MostMaybe
     */
    public static MostMaybe findDateByMaybeAvailable(Long surveyID) {
        Session session = HibernateUtil.getSession();//Ouverture d'une session
        Transaction transaction = session.beginTransaction();//Ouverture d'une transaction en cas de problème
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MostMaybe> cq = builder.createQuery(MostMaybe.class);
        Root<MostMaybe> stud = cq.from(MostMaybe.class);
        cq.select(stud).where(builder.equal(stud.get("id_survey"),surveyID));
        Query<MostMaybe> query = session.createQuery(cq);
        List<MostMaybe> maybe = query.getResultList();
        transaction.commit();//Annule les changements en cas de problème
        System.out.println(maybe.get(0));
        log.info("Fonction findDateByMaybeAvailable => OK");
        return maybe.get(0);
    }

    /**
     * Retourne toutes les satistiques (date et vote d'un sondage)
     * @param surveyID
     * @return
     */
    public static Analytics getAnalyticsById(Long surveyID) {
        log.info("Fonction getAnalyticsById => OK");
        return null;
    }

    /**
     * Retourne la date qui dispose du plus de "Disponible"
     * @param surveyID
     * @return
     */
    public static MostPossible findDateByAvailable(Long surveyID) {
        log.info("Fonction findDateByAvailable => OK");
        return null;
    }

}
