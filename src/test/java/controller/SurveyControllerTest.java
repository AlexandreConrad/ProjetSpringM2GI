package controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.api.SurveysApiController;
import io.swagger.model.Survey;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Test en rapport avec la classe "SurveyApiController"
 */
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class SurveyControllerTest {
    @Before
    public void init (){
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    ObjectMapper objectMapper;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    HttpServletRequest httpServletRequestAccept;

    /**
     * Fonction getSurvey
     * Retourne tous les surveys
     * Pour le status "NotImplemented" ou "OK"
     */
    @Test
    public void getSurveys() {
        /** Test not implemented **/
        SurveysApiController surveyControllerIsNull = new SurveysApiController(objectMapper,httpServletRequest);
        ResponseEntity<List<Survey>> surveysNotFound = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        ResponseEntity<List<Survey>> getSurveysNotFound =  surveyControllerIsNull.getSurveys();
        Assert.assertEquals(surveysNotFound,getSurveysNotFound);

        /** Test OK **/
        Mockito.when(httpServletRequestAccept.getHeader("Accept")).thenReturn("application/json");
        SurveysApiController surveyControllerAccept = new SurveysApiController(objectMapper,httpServletRequestAccept);
        ResponseEntity<List<Survey>> getSurveyOK = new ResponseEntity<>(null, HttpStatus.OK);
        ResponseEntity<List<Survey>> getSurveysIsOk =  surveyControllerAccept.getSurveys();
        Assert.assertEquals(getSurveysIsOk.getStatusCodeValue(),getSurveyOK.getStatusCodeValue());
    }

    /**
     * Fonction getSurveybyID
     * Retourne un sondage
     * Pour le status "NotImplemented" ou "OK"
     */
    @Test
    public void getSurveyByID() {

        /** Variables **/
        long surveyID = 1L;

        /** Test not implemented **/
        SurveysApiController surveyControllerIsNull = new SurveysApiController(objectMapper,httpServletRequest);
        ResponseEntity<Survey> surveysNotFound = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        ResponseEntity<Survey> getSurveysByIDNotFound =  surveyControllerIsNull.getSurvey(surveyID);
        Assert.assertEquals(surveysNotFound,getSurveysByIDNotFound);

        /** Test OK **/
        Mockito.when(httpServletRequestAccept.getHeader("Accept")).thenReturn("application/json");
        SurveysApiController surveyControllerAccept = new SurveysApiController(objectMapper,httpServletRequestAccept);
        ResponseEntity<Survey> getSurveyByIDOK = new ResponseEntity<>(null, HttpStatus.OK);
        ResponseEntity<Survey> getSurveysByIDIsOk =  surveyControllerAccept.getSurvey(surveyID);
        Assert.assertEquals(getSurveysByIDIsOk.getStatusCodeValue(),getSurveyByIDOK.getStatusCodeValue());
    }

}
