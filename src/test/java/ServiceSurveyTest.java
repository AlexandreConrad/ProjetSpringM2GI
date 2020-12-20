import io.swagger.model.Sondage;
import io.swagger.model.Survey;
import io.swagger.service.SurveyService;
import org.junit.*;
import org.threeten.bp.OffsetDateTime;

import java.sql.Timestamp;
import java.util.List;


/**
 * Test en rapport avec la classe "SurveyService"
 */
public class ServiceSurveyTest {


    /**
     * Fonction getSurveyByID
     * Doit retourner le survey en fonction d'une ID.
     */
    @Test
    public void getSurveyByID(){
        Survey surveyTest = SurveyService.getSurveyByID(1L);
        Assert.assertEquals(surveyTest.getId_survey(),(Long)1L);
        Assert.assertEquals("Anniversaire suprise pour Alexandre ?", surveyTest.getName());
        Assert.assertEquals(true, surveyTest.getIsAvailable());
        Assert.assertEquals("On fait une surprise, ne lui dites pas !!", surveyTest.getDescription());
        Timestamp date = Timestamp.valueOf("2020-06-11 12:22:44");
        // A FIX SERVEUR
        //Assert.assertEquals(surveyTest.getEndDate(),date);
    }

    /**
     * Fonction getSurveys
     * Doit retourner le surveys.
     */
    @Test
    public void getSurveys(){
        List<Survey> surveysTest = SurveyService.getSurveys();
        for (Survey s: surveysTest)
            Assert.assertNotNull(s);
    }

    /**
     * Fonction getSurveysIsActives
     * Doit retourner les surveys Actifs.
     */
    @Test
    public void getSurveysIsActives(){
        List<Survey> surveysTest = SurveyService.getSurveysIsActives();
        for (Survey s: surveysTest)
            Assert.assertTrue(s.getIsAvailable());
    }

    /**
     * Fonction getSurveysIsExpireds
     * Doit retourner les surveys inactifs.
     */
    @Test
    public void getSurveysIsExpireds(){
        List<Survey> surveysTest = SurveyService.getSurveysIsExpireds();
        for (Survey s: surveysTest)
            Assert.assertFalse(s.getIsAvailable());
    }

    /**
     * Fonction updateSurvey
     * Mise à jour d'un survey
     */
    @Test
    public void updateSurvey(){

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
        Assert.assertEquals(id_survey,newSurvey.getId_survey());
        Assert.assertEquals(bool,newSurvey.getIsAvailable());
        Assert.assertNotEquals(name,newSurvey.getName());
        Assert.assertNotEquals(description,newSurvey.getDescription());
    }

    /**
     * Fonction deleteSurvey
     * Supprime le survey en fonction du surveyID
     */
    @Test
    public void deleteSurvey(){
        Long id_survey = 2L;
        SurveyService.deleteSurvey(id_survey);
        List<Survey> surveysTest = SurveyService.getSurveys();
        for (Survey s: surveysTest)
            Assert.assertNotEquals(s.getId_survey(), id_survey);
    }

    /**
     * Fonction createSurvey
     * Permet la construction d'un survey
    */
    @Test
    public void createSurvey(){

        //Variables
        String name = "Test du sondage";
        String description = "Test description";
        OffsetDateTime dateTime = OffsetDateTime.now();
        //Timestamp date = Timestamp.valueOf(dateTime.toString());

        //Création d'un sondage
        Sondage survey = new Sondage();
        survey.setEndDate(dateTime);
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
                Assert.assertEquals(s.getIsAvailable(), true);
                //Assert.assertEquals(s.getEndDate(), date);
            }
    }

    /**
     * Fonction endSurvey
     * Clôture un survey
     */
    @Test
    public void endSurvey(){
        Long id_survey = 2L;
        SurveyService.endSurvey(id_survey);
        Survey survey = SurveyService.getSurveyByID(id_survey);
        Assert.assertEquals(survey.getIsAvailable(), false);
    }
}
