import io.swagger.model.Survey;
import io.swagger.service.SurveyService;
import org.junit.*;
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
        Assert.assertEquals("Mon premier sondage", surveyTest.getName());
        Assert.assertEquals(true, surveyTest.getIsAvailable());
        Assert.assertEquals("Mon tout premier sondage !", surveyTest.getDescription());
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
     * Dois retourner les surveys Actifs.
     */
    @Test
    public void getSurveysIsActives(){
        List<Survey> surveysTest = SurveyService.getSurveysIsActives();
        for (Survey s: surveysTest)
            Assert.assertTrue(s.getIsAvailable());
    }

    /**
     * Fonction getSurveysIsExpireds
     * Dois retourner les surveys inactifs.
     */
    @Test
    public void getSurveysIsExpireds(){
        List<Survey> surveysTest = SurveyService.getSurveysIsExpireds();
        for (Survey s: surveysTest)
            Assert.assertFalse(s.getIsAvailable());
    }
}
