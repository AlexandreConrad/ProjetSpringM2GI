package io.swagger.service;

import io.swagger.api.VotesApiController;
import io.swagger.model.Vote;
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
 * Service pour toutes les requêtes BDD en liaison "Votes"
 */
public class VoteService {

    private static final Logger log = LoggerFactory.getLogger(VotesApiController.class);

    /**
     * Fonction qui permet de faire un vote
     *
     * @param
     * @return
     */
    public static Vote postVote(String auteur, Long choiceID, Long optionID) {
        //Création d'un vote
        Vote vote = new Vote();
        vote.setAuthor(auteur);
        vote.setIdChoice(choiceID);
        vote.setIdOption(optionID);

        //Persistance dans la base de données
        Session session = HibernateUtil.getSession();//Ouverture d'une session
        Transaction transaction = session.beginTransaction();//Ouverture d'une transaction en cas de problème
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
    public static List<Vote> getVoteOption(Long optionID) {
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
    public static List<Vote> getVoteChoice(Long choiceID) {
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
    private static List<Vote> getVote(String idName, Long id) {
        Session session = HibernateUtil.getSession();//Ouverture d'une session
        Transaction transaction = session.beginTransaction();//Ouverture d'une transaction en cas de problème
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Vote> cq = builder.createQuery(Vote.class);
        Root<Vote> stud = cq.from(Vote.class);
        cq.select(stud).where(builder.equal(stud.get(idName), id));
        Query<Vote> query = session.createQuery(cq);
        List<Vote> votes = query.getResultList();
        transaction.commit();//Annule les changements en cas de problème
        return votes;
    }
}
