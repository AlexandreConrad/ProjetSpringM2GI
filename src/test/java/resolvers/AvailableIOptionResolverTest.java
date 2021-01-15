package resolvers;

import fr.univlorraine.m2.gi.groupe2.model.Option;
import fr.univlorraine.m2.gi.groupe2.resolvers.AvailableIOptionResolver;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test en rapport avec la classe "AvailableIOptionResolver"
 */
@SpringBootTest
public class AvailableIOptionResolverTest {

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