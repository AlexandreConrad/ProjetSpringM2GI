import io.swagger.model.Choice;
import io.swagger.service.AnalyticsService;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test en rapport avec la classe "AnalyticsService"
 */
public class ServiceAnalyticsTest {

    /**
     * Fonction findDateByMaybeAvailable
     * Retourne la date qui dispose du plus de "Disponible" et "Peut-être"
     */
    @Test
    public void findDateByMaybeAvailable(){
        //Variables
        Long surveyID = 1L;

        //Meilleur choix pour le sondage 1 est le choice 1
        Long choiceID = 1L;

        /**

        //Récupération du meilleur choix
        Choice c = AnalyticsService.findDateByMaybeAvailable(surveyID);

        //Vérifications des informations
        //Assert.assertEquals(c.getIdSurvey(), surveyID);
        //Assert.assertEquals(c.getIdChoice(), choiceID);
         **/
    }

    /**
     * Fonction findDateByAvailable
     * Retourne la date qui dispose du plus de "Disponible"
     */
    @Test
    public void findDateByAvailable(){

        //Variables
        Long surveyID = 1L;

        //Meilleur choix pour le sondage 1 est le choice 1
        Long choiceID = 1L;

        /**
        //Récupération du meilleur choix
        Choice c = AnalyticsService.findDateByAvailable(surveyID);

        //Vérifications des informations
        Assert.assertEquals(c.getIdSurvey(), surveyID);
        Assert.assertEquals(c.getIdChoice(), choiceID);
        **/
    }
}
