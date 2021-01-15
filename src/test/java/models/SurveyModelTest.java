package models;
import fr.univlorraine.m2.gi.groupe2.model.Survey;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

/**
 * Test en rapport avec la classe "surveyModel"
 */
@SpringBootTest
public class SurveyModelTest {

    /**
     * Constructeur de Survey
     */
    @Test
    public void survey(){
        String name = "Test nom";
        String description = "Test description";
        Timestamp t = new Timestamp(1610371364);
        Survey survey = new Survey(name,description,true,t);
        Assert.assertEquals(survey.getName(), name);
        Assert.assertEquals(survey.getDescription(), description);
        Assert.assertEquals(true, survey.getIsAvailable());
        Assert.assertEquals(survey.getEndDate(), t);
    }

    /**
     * Setter / Getter Description
     */
    @Test
    public void setName(){
        String name = "Anniversaire alexandre !";
        Survey survey = new Survey();
        survey.setName(name);
        Assert.assertEquals(survey.getName(), name);
    }

    /**
     * Setter / Getter Description
     */
    @Test
    public void setDescription(){
        String description = "Gros Anniversaire !";
        Survey survey = new Survey();
        survey.setDescription(description);
        Assert.assertEquals(survey.getDescription(), description);
    }

    /**
     * Setter / Getter IsAvailable
     */
    @Test
    public void setIsAvailable(){
        Survey survey = new Survey();
        survey.setIsAvailable(true);
        Assert.assertEquals(true, survey.getIsAvailable());
    }

    /**
     * Setter / Getter EndDate
     */
    @Test
    public void setEndDate(){
        Survey survey = new Survey();
        Timestamp t = new Timestamp(1610371364);
        survey.setEndDate(t);
        Assert.assertEquals(survey.getEndDate(), t);
    }


}
