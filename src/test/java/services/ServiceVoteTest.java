package services;

import io.swagger.exceptions.BadRequestException;
import io.swagger.exceptions.NotFoundException;
import io.swagger.model.Vote;
import io.swagger.service.VoteService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Test en rapport avec la classe "VoteService"
 */
@SpringBootTest
public class ServiceVoteTest {

    /**
     * Fonction postVote
     * Ajoute un vote à une date (Choice).
     */
    @Test
    public void postVote() throws Exception{

        //Variables
        Long choiceID = 1L;
        Long optionID = 1L;
        String auteur = "Alexandre";

        //Ajout d'un vote
        Vote votePost = VoteService.postVote(auteur,choiceID,optionID);

        //Vérifications des informations
        List<Vote> votes = VoteService.getVoteChoice(choiceID);

        //Vérifications des informations
        for( Vote v : votes ){
            if(v.getAuthor().equals(auteur)) {
                Assert.assertEquals(v.getAuthor(), votePost.getAuthor());
                Assert.assertEquals(v.getIdOption(), votePost.getIdOption());
                Assert.assertEquals(v.getIdChoice(), votePost.getIdChoice());
            }
        }
    }

    /**
     * Fonction getVoteOption
     * Retourne tous les votes d'une option.
     */
    @Test
    public void getVoteOption() throws Exception{
        Long optionID = 1L;
        List<Vote> votes = VoteService.getVoteOption(optionID); //Récupération de les votes depuis une option.
        for( Vote v : votes )
            Assert.assertEquals(v.getIdOption(),optionID); // Vérification si les votes sont de la bonne option
    }

    /**
     * Fonction getVoteChoice
     * Retourne tous les votes d'une choix.
     */
    @Test
    public void getVoteChoice() throws Exception{
        Long choiceID = 1L;
        List<Vote> votes = VoteService.getVoteOption(choiceID); //Récupération de les votes depuis un bon choix.
        for( Vote v : votes )
            Assert.assertEquals(v.getIdOption(),choiceID); // Vérification si les votes sont du bon choix
    }

    /**
     * Gestions des exceptions
     */
    @Test
    public void voteException() {

        //Gestion des exceptions pour postVote
        Assertions.assertThrows(BadRequestException.class,() -> VoteService.postVote(null,null,null));
        Assertions.assertThrows(NotFoundException.class,() -> VoteService.postVote("Alex",1L,6L));

        //Gestion des exceptions pour getVoteOption
        Assertions.assertThrows(BadRequestException.class,() -> VoteService.getVoteOption(null));
        Assertions.assertThrows(NotFoundException.class,() -> VoteService.getVoteOption(6L));

        //Gestion des exceptions pour getVoteChoice
        Assertions.assertThrows(BadRequestException.class,() -> VoteService.getVoteChoice(null));
        Assertions.assertThrows(NotFoundException.class,() -> VoteService.getVoteChoice(60000L));
    }
}
