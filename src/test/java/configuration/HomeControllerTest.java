package configuration;

import io.swagger.configuration.HomeController;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test en rapport avec la classe "HomeController"
 */

public class HomeControllerTest {

    /**
     * Setter / Getter Description
     */
    @Test
    public void homeController(){
        String information = "redirect:swagger-ui.html";
        HomeController home = new HomeController();
        String s = home.index();
        Assert.assertEquals(s, information);
    }
}