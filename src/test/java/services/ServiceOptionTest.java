import io.swagger.model.Option;
import io.swagger.service.OptionsService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Test en rapport avec la classe "OptionsService"
 */
public class ServiceOptionTest {

    /**
     * Fonction postOption
     * Ajoute une option pour les sondages.
     */
    @Test
    public void postOption(){

        //Variables
        String message = "Test";

        //Ajout d'une option
        Option option = OptionsService.postOption(message);

        //Vérifications des informations
        List<Option> opts = OptionsService.getOptions();

        //Vérifications des informations
        for( Option o : opts )
            if(o.getName().equals(message))
                Assert.assertEquals(o.getName(), option.getName());
    }

    /**
     * Fonction getOptions
     * Retourne toutes les options possible.
     */
    @Test
    public void getOptions(){
        List<Option> op = OptionsService.getOptions(); //Récupération de toutes les options
        String name = "Disponible";
        for( Option o : op )
            if(o.getName().equals(name))
                Assert.assertEquals(name,o.getName());
    }
}
