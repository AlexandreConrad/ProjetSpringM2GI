package io.swagger.service;

import io.swagger.exceptions.BadRequestException;
import io.swagger.exceptions.DatabaseException;
import io.swagger.exceptions.NotFoundException;
import io.swagger.model.Option;
import io.swagger.model.Vote;
import io.swagger.util.ServicesUtil;
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
 * Service pour toutes les requêtes BDD en liaison "Votes"
 */
public final class VoteService {

    private static final Logger log = LoggerFactory.getLogger(VoteService.class);
    private VoteService(){}
    /**
     * Fonction qui permet de faire un vote
     *
     * @param
     * @return
     */
    public static Vote postVote(String auteur, Long choiceID, Long optionID) throws DatabaseException, BadRequestException, NotFoundException {

        // Gestions des exceptions
        if(auteur == null || choiceID == null || optionID == null || auteur.isEmpty())
            throw new BadRequestException("Fonction postVote => informations non valide !");

        if(Boolean.FALSE.equals(VoteService.optionIsExist(optionID)))
            throw new NotFoundException("Fonction postVote => optionID non valide !");

        //Création d'un vote
        Vote vote = new Vote();
        vote.setAuthor(auteur);
        vote.setIdChoice(choiceID);
        vote.setIdOption(optionID);

        //Persistance dans la base de données
        Session session = ServicesUtil.createSession();
        Transaction transaction = ServicesUtil.createTransaction(session);
        session.persist(vote);
        transaction.commit();
        log.info("Fonction postVote => OK");
        return vote;
    }

    /**
     * Retourne tous les votes d'une option
     *
     * @param optionID
     * @return
     */
    public static List<Vote> getVoteOption(Long optionID) throws DatabaseException, NotFoundException, BadRequestException {

        //Gestions des exceptions
        if(optionID == null)
            throw new BadRequestException("Fonction getVoteOption => optionID non valide !");

        // Exception NotFound => 404
        if(Boolean.FALSE.equals(VoteService.optionIsExist(optionID)))
            throw new NotFoundException("Fonction postVote => optionID non valide !");

        List<Vote> votes = getVote("idOption", optionID);
        log.info("Fonction getVoteOption => OK");
        return votes;
    }

    /**
     * Retourne tous les votes d'un choix
     *
     * @param choiceID
     * @return
     */
    public static List<Vote> getVoteChoice(Long choiceID) throws DatabaseException, NotFoundException, BadRequestException {

        //Gestions des exceptions
        if(choiceID == null)
            throw new BadRequestException("Fonction getVoteChoice => choiceID non valide !");

        // Exception NotFound => 404
        ChoiceService.getChoiceById(choiceID);

        List<Vote> votes = getVote("idChoice", choiceID);
        log.info("Fonction getVoteChoice => OK");
        return votes;
    }

    /**
     * Factorisation des fonctions getVoteChoice et getVoteOption
     *
     * @param idName
     * @param id
     * @return
     */
    private static List<Vote> getVote(String idName, Long id) throws DatabaseException {

        Session session = ServicesUtil.createSession();
        Transaction transaction = ServicesUtil.createTransaction(session);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Vote> cq = builder.createQuery(Vote.class);
        Root<Vote> stud = cq.from(Vote.class);
        cq.select(stud).where(builder.equal(stud.get(idName), id));
        Query<Vote> query = session.createQuery(cq);
        List<Vote> votes = query.getResultList();
        transaction.commit();//Annule les changements en cas de problème
        return votes;
    }

    /**
     * Permet de savoir si l'option reçu existe dans la base de données.
     * @param optionID
     * @return
     * @throws BadRequestException
     * @throws DatabaseException
     * @throws NotFoundException
     */
    private static Boolean optionIsExist(Long optionID) throws DatabaseException, NotFoundException {
        List<Option> options = OptionsService.getOptions();
        Boolean optionIsExist = false;
        for(Option opt : options)
            if(opt.getIdOption().equals(optionID))
                optionIsExist = true;

        return optionIsExist;
    }
}
