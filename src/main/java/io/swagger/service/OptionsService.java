package io.swagger.service;

import io.swagger.api.OptionsApiController;
import io.swagger.model.Option;
import io.swagger.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Service pour toutes les requêtes BDD en liaison "Option"
 */
public class OptionsService {

    private static final Logger log = LoggerFactory.getLogger(OptionsApiController.class);

    /**
     * Ajout d'une nouvelle option pour les sondages
     * @param optionName
     * @return Option
     */
    public static Option postOption(String optionName) {
        //Création de l'option
        Option op = new Option();
        op.setName(optionName);

        //Persistance dans la base de données
        Session session = HibernateUtil.getSession();//Ouverture d'une session
        Transaction transaction = session.beginTransaction();//Ouverture d'une transaction en cas de problème
        session.persist(op);
        transaction.commit();
        log.info("Fonction postOption => OK");
        return op;
    }

    /**
     * Retoune la liste de toutes les options possibles
     * @return options
     */
    public static List<Option> getOptions() {
        Session session = HibernateUtil.getSession();//Ouverture d'une session
        Transaction transaction = session.beginTransaction();//Ouverture d'une transaction en cas de problème
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Option> criteria = builder.createQuery(Option.class); //Récupération de tous les sondages
        criteria.from(Option.class);
        List<Option> options = session.createQuery(criteria).getResultList();
        transaction.commit();
        log.info("Fonction getOptions => OK");
        return options;
    }
}
