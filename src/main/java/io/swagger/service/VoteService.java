package io.swagger.service;

import io.swagger.api.VotesApiController;
import io.swagger.model.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

/**
 * Service pour toutes les requêtes BDD en liaison "Votes"
 */
public class VoteService {

    private static final Logger log = LoggerFactory.getLogger(VotesApiController.class);

    /**
     * Fonction qui permet de faire un vote
     * @param
     * @return
     */
    public static List<Comment> postVote(Long surveyID) {

        log.info("Fonction postVote => OK");
        return null;
    }

}
