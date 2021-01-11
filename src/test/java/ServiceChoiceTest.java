import io.swagger.model.Choice;

import java.sql.Timestamp;
import java.util.List;

import io.swagger.model.Comment;
import io.swagger.model.Survey;
import io.swagger.service.ChoiceService;
import io.swagger.service.CommentService;
import io.swagger.service.SurveyService;
import org.junit.*;

public class ServiceChoiceTest {

    /**
     * Fonction getChoiceById
     * Retourne tous les choix d'un sondage.
     */
    @Test
    public void getChoiceById() {
        Long idSurvey = 1L;
        List<Choice> choices = ChoiceService.getChoiceById(idSurvey); //Récupération de tous les choix d'un sondage.
        for( Choice c : choices )
            Assert.assertEquals(c.getIdSurvey(),idSurvey); // Vérification si les choix correspondent au bon sondage.
    }

    /**
     * Fonction getDeleteById
     * Delete le choix
     */
    @Test
    public void getDeleteById(){
        Long idSurvey = 1L;
        Long id_choice = 2L;
        ChoiceService.getDeleteById(id_choice);
        List<Choice> choicesTest = ChoiceService.getChoiceById(idSurvey);
        for (Choice c: choicesTest)
            Assert.assertNotEquals(c.getIdSurvey(), id_choice);
    }

    /**
     * Fonction postChoiceById
     * Ajoute un choix
     */
    @Test
    public void  postChoiceById(){
        //Variables
        Long surveyID = 1L;
        Timestamp date = Timestamp.valueOf("2020-06-11 12:22:44");

        //Ajout d'un choix
        Choice choice = ChoiceService.postChoiceById(date,surveyID);

        //Vérification des informations
        List<Choice> choices = ChoiceService.getChoiceById(surveyID);

        //Vérification des informations
        for( Choice c : choices )
            if(c.getDate().equals(date)) {
                Assert.assertEquals(c.getIdSurvey(), surveyID);
                Assert.assertEquals(c.getDate(), date);
            }
    }
}
