package controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.api.SurveysApiController;
import io.swagger.exceptions.BadRequestException;
import io.swagger.exceptions.NotFoundException;
import io.swagger.model.Survey;
import io.swagger.service.SurveyService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
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
    Survey survey;

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
        ResponseEntity<List<Survey>> surveysNotImplemented = new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        ResponseEntity<List<Survey>> getSurveysNotImplemented =  surveyControllerIsNull.getSurveys();
        Assert.assertEquals(surveysNotImplemented,getSurveysNotImplemented);

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
        ResponseEntity<Survey> surveysNotImplemented = new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        ResponseEntity<Survey> getSurveysByIDNotImplemented =  surveyControllerIsNull.getSurvey(surveyID);
        Assert.assertEquals(surveysNotImplemented,getSurveysByIDNotImplemented);

        /** Test OK **/
        Mockito.when(httpServletRequestAccept.getHeader("Accept")).thenReturn("application/json");
        SurveysApiController surveyControllerAccept = new SurveysApiController(objectMapper,httpServletRequestAccept);
        ResponseEntity<Survey> getSurveyByIDOK = new ResponseEntity<>(null, HttpStatus.OK);
        ResponseEntity<Survey> getSurveysByIDIsOk =  surveyControllerAccept.getSurvey(surveyID);
        Assert.assertEquals(getSurveysByIDIsOk.getStatusCodeValue(),getSurveyByIDOK.getStatusCodeValue());
    }

    /**
     * Fonction getSurveysIsActifs
     * Retourne les sondages actifs
     * Pour le status "NotImplemented" ou "OK"
     */
    @Test
    public void getSurveysIsActifs() {

        /** Test not implemented **/
        SurveysApiController surveyControllerIsNull = new SurveysApiController(objectMapper,httpServletRequest);
        ResponseEntity<List<Survey>> surveysIsActifsNotImplemented = new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        ResponseEntity<List<Survey>> surveyIsActifsNotImplemented =  surveyControllerIsNull.getSurveysIsActifs();
        Assert.assertEquals(surveysIsActifsNotImplemented,surveyIsActifsNotImplemented);

        /** Test OK **/
        Mockito.when(httpServletRequestAccept.getHeader("Accept")).thenReturn("application/json");
        SurveysApiController surveyControllerAccept = new SurveysApiController(objectMapper,httpServletRequestAccept);
        ResponseEntity<List<Survey>> surveysIsActifsIsDOK = new ResponseEntity<>(null, HttpStatus.OK);
        ResponseEntity<List<Survey>> surveysIsActifsIsOk =  surveyControllerAccept.getSurveysIsActifs();
        Assert.assertEquals(surveysIsActifsIsOk.getStatusCodeValue(),surveysIsActifsIsDOK.getStatusCodeValue());
    }

    /**
     * Fonction deleteSurvey
     * Supprime un survey
     * Pour le status "NotImplemented" ou "OK"
     */
    @Test
    public void deleteSurvey() {

        /** Variables **/
        Long surveyID = 1L;

        /** Test not implemented **/
        SurveysApiController surveyControllerIsNull = new SurveysApiController(objectMapper,httpServletRequest);
        ResponseEntity<Survey> surveysDeleteNotImplemented = new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        ResponseEntity<Survey> surveysDelete =  surveyControllerIsNull.deleteSurvey(surveyID);
        Assert.assertEquals(surveysDeleteNotImplemented,surveysDelete);

    }

    /**
     * Fonction getSurveysIsInactifs
     * Récupérations des sondages inactifs
     * Pour le status "NotImplemented" ou "OK"
     */
    @Test
    public void getSurveysIsInactifs() {

        /** Test not implemented **/
        SurveysApiController surveyControllerIsNull = new SurveysApiController(objectMapper,httpServletRequest);
        ResponseEntity<List<Survey>> surveysIsInactifsNotImplemented = new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        ResponseEntity<List<Survey>> surveysIsInactifs =  surveyControllerIsNull.getSurveysIsInactifs();
        Assert.assertEquals(surveysIsInactifsNotImplemented,surveysIsInactifs);

        /** Test OK **/
        Mockito.when(httpServletRequestAccept.getHeader("Accept")).thenReturn("application/json");
        SurveysApiController surveyControllerAccept = new SurveysApiController(objectMapper,httpServletRequestAccept);
        ResponseEntity<List<Survey>> surveysIsInactifsIsDOK = new ResponseEntity<>(null, HttpStatus.OK);
        ResponseEntity<List<Survey>> surveysIsInactifsIsOk =  surveyControllerAccept.getSurveysIsInactifs();
        Assert.assertEquals(surveysIsInactifsIsDOK.getStatusCodeValue(),surveysIsInactifsIsOk.getStatusCodeValue());

    }

    /**
     * Fonction endSurveys
     * Cloturation d'un sondage
     * Pour le status "NotImplemented" ou "OK"
     */
    @Test
    public void endSurveys(){

        /** Variables **/
        Long surveyID = 1L;

        /** Test not implemented **/
        SurveysApiController surveyControllerIsNull = new SurveysApiController(objectMapper,httpServletRequest);
        ResponseEntity<Survey> endSurveyNotImplemented = new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        ResponseEntity<Survey> endSurvey =  surveyControllerIsNull.endSurveys(surveyID);
        Assert.assertEquals(endSurveyNotImplemented,endSurvey);

        /** Test OK **/
        Mockito.when(httpServletRequestAccept.getHeader("Accept")).thenReturn("application/json");
        SurveysApiController surveyControllerAccept = new SurveysApiController(objectMapper,httpServletRequestAccept);
        ResponseEntity<Survey> endSurveyIsOK = new ResponseEntity<>(null, HttpStatus.OK);
        ResponseEntity<Survey> endSurveyOk =  surveyControllerAccept.endSurveys(surveyID);
        Assert.assertEquals(endSurveyIsOK.getStatusCodeValue(),endSurveyOk.getStatusCodeValue());

        /** Test not found **/
        ResponseEntity<Survey> endSurveyNotFound =  surveyControllerAccept.endSurveys(10000L);
        Assert.assertEquals(endSurveyNotFound.getStatusCodeValue(),HttpStatus.NOT_FOUND.value());

    }

}
