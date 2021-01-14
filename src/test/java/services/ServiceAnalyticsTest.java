package services;

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
    public void findDateByMaybeAvailable() throws Exception{
        //Variables
        Long surveyID = 2L;

        //Meilleur choix pour le sondage 2 est le choice 3
        Long choiceID = 3L;

        //Récupération du meilleur choix
        Choice c = AnalyticsService.findDateByMaybeAvailable(surveyID);

        //Vérifications des informations
        Assert.assertEquals(c.getIdSurvey(), surveyID);
        //Assert.assertEquals(c.getIdChoice(), choiceID);

    }

    /**
     * Fonction findDateByAvailable
     * Retourne la date qui dispose du plus de "Disponible"
     */
    @Test
    public void findDateByAvailable() throws Exception{

        //Variables
        Long surveyID = 4L;

        //Meilleur choix pour le sondage 4 est le choice 7
        Long choiceID = 7L;

        //Récupération du meilleur choix
        Choice c = AnalyticsService.findDateByAvailable(surveyID);

        //Vérifications des informations
        Assert.assertEquals(c.getIdSurvey(), surveyID);
        //Assert.assertEquals(c.getIdChoice(), choiceID);

    }
}
