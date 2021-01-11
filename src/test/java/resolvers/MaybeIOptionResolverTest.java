package resolvers;

import io.swagger.model.Option;
import io.swagger.resolvers.MaybeIOptionResolver;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test en rapport avec la classe "MaybeIOptionResolver"
 */
@SpringBootTest
public class MaybeIOptionResolverTest {

    /**
     * Resolver pour les Analytics
     */
    @Test
    public void MaybeIOptionResolver(){

        /** Variables **/
        MaybeIOptionResolver maybe = new MaybeIOptionResolver();
        Option optDispo = new Option("Disponible");
        Option optMayBe = new Option("Peut-être");
        Option optIndis = new Option("Indisponible");
        Option optErreur = new Option("Erreur");

        /** Tests **/
        Assert.assertTrue(maybe.shouldMatch(optDispo));
        Assert.assertTrue(maybe.shouldMatch(optMayBe));
        Assert.assertFalse(maybe.shouldMatch(optIndis));
        Assert.assertFalse(maybe.shouldMatch(optErreur));
    }

}