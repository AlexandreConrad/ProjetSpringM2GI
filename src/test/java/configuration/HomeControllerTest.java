package configuration;
import io.swagger.configuration.HomeController;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test en rapport avec la classe "HomeController"
 */
@SpringBootTest
public class HomeControllerTest {

    /**
     * Fonction du homeController
     */
    @Test
    public void homeController(){
        String information = "redirect:swagger-ui.html";
        HomeController home = new HomeController();
        String s = home.index();
        Assert.assertEquals(s, information);
    }
}