package services;

import fr.univlorraine.m2.gi.groupe2.exceptions.BadRequestException;
import fr.univlorraine.m2.gi.groupe2.exceptions.NotFoundException;
import fr.univlorraine.m2.gi.groupe2.model.Survey;
import fr.univlorraine.m2.gi.groupe2.service.SurveyService;
import org.junit.*;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * Test en rapport avec la classe "SurveyService"
 */
@SpringBootTest
public class ServiceSurveyTest {

    /**
     * Fonction getSurveys
     * Doit retourner le surveys.
     */
    @Test
    public void getSurveys() throws Exception {
        List<Survey> surveysTest = SurveyService.getSurveys();
        for (Survey s: surveysTest)
            Assert.assertNotNull(s);
    }

    /**
     * Fonction getSurveysIsActives
     * Doit retourner les surveys Actifs.
     */
    @Test
    public void getSurveysIsActives()  throws Exception {
        List<Survey> surveysTest = SurveyService.getSurveysIsActives();
        for (Survey s: surveysTest)
            Assert.assertTrue(s.getIsAvailable());
    }

    /**
     * Fonction getSurveysIsExpireds
     * Doit retourner les surveys inactifs.
     */
    @Test
    public void getSurveysIsExpireds()  throws Exception {
        List<Survey> surveysTest = SurveyService.getSurveysIsExpireds();
        for (Survey s: surveysTest)
            Assert.assertFalse(s.getIsAvailable());
    }

    /**
     * Fonction updateSurvey
     * Mise à jour d'un survey
     */
    @Test
    public void updateSurvey() throws Exception{

        /** Gestion des exceptions **/
        Assertions.assertThrows(BadRequestException.class,() -> SurveyService.updateSurvey(null,null));
        Assertions.assertThrows(NotFoundException.class,() -> SurveyService.updateSurvey(10000L,new Survey()));

        //Ancienne valeurs
        Long id_survey = 2L;
        Survey oldSurvey = SurveyService.getSurveyByID(id_survey);
        String description = oldSurvey.getDescription();
        String name = oldSurvey.getName();
        Boolean bool = oldSurvey.getIsAvailable();

        //Modification du sondage
        Survey s = oldSurvey;
        s.setDescription("UPDATE");
        s.setName("UPDATE NOM");
        SurveyService.updateSurvey(id_survey,s);

        //On test les changements
        Survey newSurvey = SurveyService.getSurveyByID(id_survey);
        Assert.assertEquals(id_survey,newSurvey.getIdSurvey());
        Assert.assertEquals(bool,newSurvey.getIsAvailable());
        Assert.assertNotEquals(name,newSurvey.getName());
        Assert.assertNotEquals(description,newSurvey.getDescription());
    }

    /**
     * Fonction deleteSurvey
     * Supprime le survey en fonction du surveyID
     */
    @Test
    public void deleteSurvey() throws Exception{

        /** Gestion des exceptions **/
        Assertions.assertThrows(NotFoundException.class,() -> SurveyService.deleteSurvey(10000L));

        Long id_survey = 2L;
        SurveyService.deleteSurvey(id_survey);
        List<Survey> surveysTest = SurveyService.getSurveys();
        for (Survey s: surveysTest)
            Assert.assertNotEquals(s.getIdSurvey(), id_survey);
    }

    /**
     * Fonction createSurvey
     * Permet la construction d'un survey
    */
    @Test
    public void createSurvey() throws Exception{

        //Variables
        String name = "Test du sondage";
        String description = "Test description";
        Date dateTime = new Date();
        Long time = dateTime.getTime();

        //Création d'un sondage
        Survey survey = new Survey();
        survey.setEndDate(new Timestamp(time));
        survey.setName(name);
        survey.setDescription(description);

        //Fonction createSurvey
        SurveyService.createSurvey(survey);

        //Vérification
        List<Survey> surveysTest = SurveyService.getSurveysIsActives();
        for (Survey s: surveysTest)
            if(s.getName().equals(name)) {
                Assert.assertEquals(s.getName(), name);
                Assert.assertEquals(s.getDescription(), description);
                Assert.assertEquals(true,s.getIsAvailable());
                //Assert.assertEquals(s.getEndDate(), date);
            }

        /** Gestion des exceptions **/
        Assertions.assertThrows(BadRequestException.class,() -> SurveyService.createSurvey(new Survey()));
    }

    /**
     * Fonction endSurvey
     * Clôture un survey
     */
    @Test
    public void endSurvey() throws Exception{
        Long id_survey = 2L;
        SurveyService.endSurvey(id_survey);
        Survey survey = SurveyService.getSurveyByID(id_survey);
        Assert.assertEquals(false,survey.getIsAvailable());

        /** Gestion des exceptions **/
        Assertions.assertThrows(BadRequestException.class,() -> SurveyService.endSurvey(null));
        Assertions.assertThrows(NotFoundException.class,() -> SurveyService.endSurvey(100000L));
    }

    /**
     * Fonction getSurveyByID
     * Doit retourner le survey en fonction d'une ID.
     */
    @Test
    public void getSurveyByID() throws Exception{
        Survey surveyTest = SurveyService.getSurveyByID(1L);
        Assert.assertEquals(surveyTest.getIdSurvey(),(Long)1L);
        Assert.assertEquals("Anniversaire suprise pour Alexandre ?", surveyTest.getName());
        //Assert.assertEquals(true, surveyTest.getIsAvailable());
        Assert.assertEquals("On fait une surprise, ne lui dites pas !!", surveyTest.getDescription());
        // A FIX SERVEUR
        //Timestamp date = Timestamp.valueOf("2020-06-11 12:22:44");
        //Assert.assertEquals(surveyTest.getEndDate(),date);

        /** Gestion des exceptions **/
        Assertions.assertThrows(NotFoundException.class,() -> SurveyService.getSurveyByID(10000L));
    }
}
