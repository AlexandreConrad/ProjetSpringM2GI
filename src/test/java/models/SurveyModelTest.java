package models;
import io.swagger.model.Survey;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Timestamp;

/**
 * Test en rapport avec la classe "surveyModel"
 */
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
        Assert.assertEquals(survey.getIsAvailable(), true);
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
        Assert.assertEquals(survey.getIsAvailable(), true);
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