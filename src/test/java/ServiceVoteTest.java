import io.swagger.model.Vote;
import io.swagger.service.VoteService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Test en rapport avec la classe "VoteService"
 */
public class ServiceVoteTest {

    /**
     * Fonction postVote
     * Ajoute un vote à une date (Choice).
     */
    @Test
    public void postVote(){

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
                Assert.assertEquals(v.getId_option(), votePost.getId_option());
                Assert.assertEquals(v.getId_choices(), votePost.getId_choices());
            }
        }
    }

    /**
     * Fonction getVoteOption
     * Retourne tous les votes d'une option.
     */
    @Test
    public void getVoteOption(){
        Long optionID = 1L;
        List<Vote> votes = VoteService.getVoteOption(optionID); //Récupération de les votes depuis une option.
        for( Vote v : votes )
            Assert.assertEquals(v.getId_option(),optionID); // Vérification si les votes sont de la bonne option
    }

    /**
     * Fonction getVoteChoice
     * Retourne tous les votes d'une choix.
     */
    @Test
    public void getVoteChoice(){
        Long choiceID = 1L;
        List<Vote> votes = VoteService.getVoteOption(choiceID); //Récupération de les votes depuis un bon choix.
        for( Vote v : votes )
            Assert.assertEquals(v.getId_option(),choiceID); // Vérification si les votes sont du bon choix
    }
}
