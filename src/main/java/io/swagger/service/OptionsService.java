package io.swagger.service;

import io.swagger.exceptions.BadRequestException;
import io.swagger.exceptions.DatabaseException;
import io.swagger.exceptions.NotFoundException;
import io.swagger.model.Option;
import io.swagger.util.ServicesUtil;
import org.hibernate.ObjectNotFoundException;
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
public final class OptionsService {

    private static final Logger log = LoggerFactory.getLogger(OptionsService.class);
    private OptionsService(){}

    /**
     * Ajout d'une nouvelle option pour les sondages
     *
     * @param optionName
     * @return Option
     */
    public static Option postOption(String optionName) throws DatabaseException, BadRequestException {

        if(optionName == null || optionName.isEmpty())
            throw new BadRequestException("Fonction postOption => informations non valide !");

        //Création de l'option
        Option op = new Option();
        op.setName(optionName);

        //Persistance dans la base de données
        Session session = ServicesUtil.createSession(); //Ouverture d'une session
        Transaction transaction = ServicesUtil.createTransaction(session); //Ouverture d'une transaction en cas de problème

        session.persist(op);
        transaction.commit();
        log.info("Fonction postOption => OK");
        return op;
    }

    /**
     * Retoune la liste de toutes les options possibles
     *
     * @return options
     */
    public static List<Option> getOptions() throws DatabaseException, NotFoundException {

        //Persistance dans la base de données
        Session session = ServicesUtil.createSession(); //Ouverture d'une session
        Transaction transaction = ServicesUtil.createTransaction(session); //Ouverture d'une transaction en cas de problème

        try{
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Option> criteria = builder.createQuery(Option.class); //Récupération de tous les sondages
            criteria.from(Option.class);
            List<Option> options = session.createQuery(criteria).getResultList();
            transaction.commit();
            options.size();
            log.info("Fonction getOptions => OK");
            return options;
        }catch(ObjectNotFoundException e){ // Gestion exception par Hibernate
            transaction.rollback(); // Annule les changements
            throw new NotFoundException("getOptions non trouvé !");
        }
    }
}
