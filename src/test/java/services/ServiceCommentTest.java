import io.swagger.model.Comment;
import io.swagger.service.CommentService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Test en rapport avec la classe "CommentService"
 */
public class ServiceCommentTest {

    /**
     * Fonction addComments
     * Ajoute un commentaire à un sondage.
     */
    @Test
    public void addComments(){

        //Variables
        Long surveyID = 1L;
        String message = "Je prends les chips";
        String auteur = "Alexandre";

        //Ajout d'un commentaire
        Comment comment = CommentService.addComments(surveyID,message,auteur);

        //Vérifications des informations
        List<Comment> comments = CommentService.getComments(surveyID);

        //Vérifications des informations
        for( Comment c : comments )
            if(c.getComment().equals(message)) {
                Assert.assertEquals(c.getIdSurvey(), surveyID);
                Assert.assertEquals(c.getComment(), message);
                Assert.assertEquals(c.getAuthor(), auteur);
            }
    }

    /**
     * Fonction getComments
     * Retourne tous les commentaires d'un sondage.
     */
    @Test
    public void getComments(){
        Long idSurvey = 1L;
        List<Comment> comments = CommentService.getComments(idSurvey); //Récupération de tous les commentaires d'un sondage.
        for( Comment c : comments )
            Assert.assertEquals(c.getIdSurvey(),idSurvey); // Vérification si les commentaires sont du bon sondage.
    }
}
