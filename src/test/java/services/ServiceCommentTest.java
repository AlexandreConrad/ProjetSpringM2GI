package services;

import fr.univlorraine.m2.gi.groupe2.exceptions.BadRequestException;
import fr.univlorraine.m2.gi.groupe2.exceptions.DatabaseException;
import fr.univlorraine.m2.gi.groupe2.exceptions.NotFoundException;
import fr.univlorraine.m2.gi.groupe2.model.Comment;
import fr.univlorraine.m2.gi.groupe2.service.CommentService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Test en rapport avec la classe "CommentService"
 */
@SpringBootTest
public class ServiceCommentTest {

    /**
     * Fonction addComments
     * Ajoute un commentaire à un sondage.
     */
    @Test
    public void addComments() throws Exception{

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
    public void getComments()throws Exception{
        Long idSurvey = 1L;
        List<Comment> comments = CommentService.getComments(idSurvey); //Récupération de tous les commentaires d'un sondage.
        for( Comment c : comments )
            Assert.assertEquals(c.getIdSurvey(),idSurvey); // Vérification si les commentaires sont du bon sondage.
    }

    /**
     * Gestions des exceptions
     */
    @Test(expected = NotFoundException.class)
    public void commentsExceptionsNotFoundException() throws BadRequestException, DatabaseException, NotFoundException {
        CommentService.addComments(10000L,"test","test");
        CommentService.getComments(10000L);
    }

    @Test(expected = BadRequestException.class)
    public void commentsExceptionsBadRequestException() throws BadRequestException, DatabaseException, NotFoundException {
        CommentService.addComments(null,null,null);
    }
}
