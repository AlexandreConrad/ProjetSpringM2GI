package services;

import fr.univlorraine.m2.gi.groupe2.exceptions.BadRequestException;
import fr.univlorraine.m2.gi.groupe2.exceptions.DatabaseException;
import fr.univlorraine.m2.gi.groupe2.exceptions.NotFoundException;
import fr.univlorraine.m2.gi.groupe2.model.Choice;
import fr.univlorraine.m2.gi.groupe2.service.ChoiceService;
import org.junit.*;
import org.springframework.boot.test.context.SpringBootTest;
import java.sql.Timestamp;
import java.util.List;

/**
 * Test en rapport avec la classe "ServiceChoice"
 */
@SpringBootTest
public class ServiceChoiceTest {

    /**
     * Fonction getChoiceById
     * Retourne tous les choix d'un sondage.
     */
    @Test
    public void getChoiceById() throws Exception{
        Long idSurvey = 1L;
        List<Choice> choices = ChoiceService.getChoiceById(idSurvey); //Récupération de tous les choix d'un sondage.
        for( Choice c : choices )
            Assert.assertEquals(c.getIdSurvey(),idSurvey); // Vérification si les choix correspondent au bon sondage.
    }

    /**
     * Fonction postChoiceById
     * Ajoute un choix
     */
    @Test
    public void  postChoiceById() throws Exception{
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

    /**
     * Gestions exceptions
     * @throws NotFoundException
     * @throws DatabaseException
     */
    @Test(expected = NotFoundException.class)
    public void getChoiceByIDNotFound() throws NotFoundException, DatabaseException, BadRequestException {
        /** Gestion des exceptions **/
        ChoiceService.getChoiceById(10000L);
        ChoiceService.getDeleteById(10000L);
        Timestamp t = new Timestamp(1598957264);
        ChoiceService.postChoiceById(t,10000L);
    }

    /**
     * Fonction getDeleteById
     * Delete le choix
     */
    @Test
    public void getDeleteById() throws Exception{
        Long idSurvey = 1L;
        Long id_choice = 2L;
        ChoiceService.getDeleteById(id_choice);
        List<Choice> choicesTest = ChoiceService.getChoiceById(idSurvey);
        for (Choice c: choicesTest)
            Assert.assertNotEquals(c.getIdSurvey(), id_choice);
    }

}
