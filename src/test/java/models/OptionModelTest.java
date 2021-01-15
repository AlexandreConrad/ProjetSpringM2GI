package models;

import fr.univlorraine.m2.gi.groupe2.model.Option;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test en rapport avec la classe "Option"
 */
@SpringBootTest
public class OptionModelTest {

    /**
     * Long idOption
     */
    @Test
    public void idOption() {
        Long idOption = 100L;
        Option option = new Option("Test");
        option.setIdOption(idOption);
        Assert.assertEquals(idOption, option.getIdOption());
    }

    /**
     * Long nameOption
     */
    @Test
    public void nameOption() {
        String name = "Test";
        String newName = "Bonjour";
        Option option = new Option(name);
        option.setName(newName);
        Assert.assertEquals(newName, option.getName());
    }

    /**
     * Equals et HashCode
     */
    @Test
    public void EqualsAndHashcodeOption() {

        /** Option 1 **/
        String name = "Test";
        Long idOption = 100L;
        Option optionX = new Option(name);
        optionX.setIdOption(idOption);

        /** Option 2 **/
        Option optionY = new Option(name);
        optionY.setIdOption(idOption);

        /** Tests **/
        Assert.assertTrue(optionX.equals(optionY) && optionY.equals(optionX));
        Assert.assertEquals(optionX.hashCode() , optionY.hashCode());
    }

    /**
     * Controller
     */
    @Test
    public void controllerOption() {

        /** Option **/
        String name = "Test";
        Long idOption = 100L;
        Option option = new Option();
        option.setIdOption(idOption);
        option.setName(name);

        /** Tests **/
        Assert.assertEquals(idOption, option.getIdOption());
        Assert.assertEquals(name, option.getName());
    }

    /**
     * toString
     */
    @Test
    public void toStringOption() {

        /** Option **/
        Option option = new Option();
        String name = "Option(idOption=null, name=null)";

        /** Test **/
        Assert.assertEquals(name, option.toString());
    }
}
