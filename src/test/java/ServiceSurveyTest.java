import io.swagger.model.Survey;
import io.swagger.service.SurveyService;
import org.junit.*;
import java.sql.Timestamp;


/**
 * Test en rapport avec la classe "SurveyService"
 */
public class ServiceSurveyTest {

    @Test
    /**
     * Fonction getSurveyByID
     * Doit retourner le survey en fonction d'une ID.
     */
    public void getSurveyByID(){
        Survey surveyTest = SurveyService.getSurveyByID(1L);
        Assert.assertEquals(surveyTest.getId_survey(),(Long)1L);
        Assert.assertEquals(surveyTest.getName(), "Mon premier sondage");
        Assert.assertEquals(surveyTest.getIsAvailable(),true);
        Assert.assertEquals(surveyTest.getDescription(),"Mon tout premier sondage !");
        Timestamp date = new Timestamp(1604662545000L);
        Assert.assertEquals(surveyTest.getEndDate(),date);
    }
}
