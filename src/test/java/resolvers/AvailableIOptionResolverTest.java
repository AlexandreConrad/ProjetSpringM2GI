package resolvers;

import io.swagger.model.Option;
import io.swagger.resolvers.MaybeIOptionResolver;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test en rapport avec la classe "AvailableIOptionResolver"
 */
@SpringBootTest
public class AvailableIOptionResolver {

    /**
     * Resolver pour les Analytics
     */
    @Test
    public void AvailableIOptionResolver(){

        /** Variables **/
        AvailableIOptionResolver maybe = new AvailableIOptionResolver();
        Option optDispo = new Option("Disponible");
        Option optIndis = new Option("Indisponible");

        /** Tests **/
        Assert.assertTrue(maybe.shouldMatch(optDispo));
        Assert.assertFalse(maybe.shouldMatch(optIndis));
    }

}