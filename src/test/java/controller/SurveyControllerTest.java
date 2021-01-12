package controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.api.SurveysApiController;
import io.swagger.model.Survey;
import io.swagger.service.SurveyService;
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
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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

        /** Variables **/
        Long surveyID = 1L;

        /** Test not found
        Mockito.when(SurveyService.getSurveys()).thenReturn(null);
        SurveysApiController surveyControllerIsNull = new SurveysApiController(objectMapper,httpServletRequest);
        ResponseEntity<List<Survey>> surveysNotFound = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        ResponseEntity<List<Survey>> getSurveysNotFound =  surveyControllerIsNull.getSurveys();
        Assert.assertEquals(surveysNotFound,getSurveysNotFound);

        /** Test internal server error **/
        Mockito.when(httpServletRequestAccept.getHeader("Accept")).thenReturn("");
        SurveysApiController surveyControllerInternalError = new SurveysApiController(objectMapper,httpServletRequest);
        ResponseEntity<List<Survey>> surveysInternalError = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        ResponseEntity<List<Survey>> getSurveysInternalError =  surveyControllerInternalError.getSurveys();
        Assert.assertEquals(surveysInternalError,getSurveysInternalError);

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

    /**
     * Fonction getSurveysActifs
     * Retourne un sondage
     * Pour le status "Internal server error" ou "OK"
     */
    @Test
    public void getSurveysActifs() {

        /** Test internal server error **/
        SurveysApiController surveyControllerIsNull = new SurveysApiController(objectMapper,httpServletRequest);
        ResponseEntity<List<Survey>> surveysNotFound = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        ResponseEntity<List<Survey>> getSurveysByIDNotFound =  surveyControllerIsNull.getSurveysIsActifs();
        Assert.assertEquals(surveysNotFound,getSurveysByIDNotFound);

        /** Test OK **/
        Mockito.when(httpServletRequestAccept.getHeader("Accept")).thenReturn("application/json");
        SurveysApiController surveyControllerAccept = new SurveysApiController(objectMapper,httpServletRequestAccept);
        ResponseEntity<List<Survey>> getSurveyByIDOK = new ResponseEntity<>(null, HttpStatus.OK);
        ResponseEntity<List<Survey>> getSurveysByIDIsOk =  surveyControllerAccept.getSurveysIsActifs();
        Assert.assertEquals(getSurveysByIDIsOk.getStatusCodeValue(),getSurveyByIDOK.getStatusCodeValue());
    }

    /**
     * Fonction getSurveysActifs
     * Retourne un sondage
     * Pour le status "Internal server error" ou "OK"
     */
    @Test
    public void getSurveysInactifs() {

        /** Test internal server error **/
        SurveysApiController surveyControllerIsNull = new SurveysApiController(objectMapper,httpServletRequest);
        ResponseEntity<List<Survey>> surveysNotFound = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        ResponseEntity<List<Survey>> getSurveysByIDNotFound =  surveyControllerIsNull.getSurveysIsInactifs();
        Assert.assertEquals(surveysNotFound,getSurveysByIDNotFound);

        /** Test OK **/
        Mockito.when(httpServletRequestAccept.getHeader("Accept")).thenReturn("application/json");
        SurveysApiController surveyControllerAccept = new SurveysApiController(objectMapper,httpServletRequestAccept);
        ResponseEntity<List<Survey>> getSurveyByIDOK = new ResponseEntity<>(null, HttpStatus.OK);
        ResponseEntity<List<Survey>> getSurveysByIDIsOk =  surveyControllerAccept.getSurveysIsInactifs();
        Assert.assertEquals(getSurveysByIDIsOk.getStatusCodeValue(),getSurveyByIDOK.getStatusCodeValue());
    }

     /**
     * Fonction getSurveysActifs
     * Retourne un sondage
     * Pour le status "Internal server error" ou "OK"
     */
     @Test
     public void updateSurvey() {

        /** Variables **/
        long surveyID = 1L;
        String description = "description";
        String name = "vincent";
        Timestamp endDate = new Timestamp(2021,12,15, 16,15,16,15);
        Survey survey = new Survey(description, name, true, endDate);
        Survey surveyBadRequest = new Survey("", "", true, endDate);

        /** Test Conflict
        SurveysApiController surveyControllerConflict = new SurveysApiController(objectMapper,httpServletRequest);
        ResponseEntity<Survey> surveysConflict = new ResponseEntity<>(null, HttpStatus.CONFLICT);
        ResponseEntity<Survey> getSurveysByIDConflict =  surveyControllerConflict.updateSurvey(surveyID,survey);
        Assert.assertEquals(surveysConflict,getSurveysByIDConflict);

        /** Test Bad Request **/
        SurveysApiController surveyControllerBadRequest = new SurveysApiController(objectMapper,httpServletRequest);
        ResponseEntity<Survey> surveysBadRequest = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        ResponseEntity<Survey> getSurveysByIDBadRequest =  surveyControllerBadRequest.updateSurvey(surveyID,surveyBadRequest);
        Assert.assertEquals(surveysBadRequest,getSurveysByIDBadRequest);

        /** Test Not Found
        Mockito.when(SurveyService.updateSurvey(surveyID,survey)).thenReturn(null);
        SurveysApiController surveyControllerNotFound = new SurveysApiController(objectMapper,httpServletRequest);
        ResponseEntity<Survey> surveysNotFound = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        ResponseEntity<Survey> getSurveysByIDNotFound =  surveyControllerNotFound.updateSurvey(surveyID,survey);
        Assert.assertEquals(surveysNotFound,getSurveysByIDNotFound);

        /** Test internal server error **/
        Mockito.when(httpServletRequest.getHeader("Accept")).thenReturn("");
        SurveysApiController surveyControllerInternalError = new SurveysApiController(objectMapper,httpServletRequest);
        ResponseEntity<Survey> surveysInternalError = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        ResponseEntity<Survey> getSurveysByIDInternalError =  surveyControllerInternalError.updateSurvey(surveyID,survey);
        Assert.assertEquals(surveysInternalError,getSurveysByIDInternalError);

        /** Test OK **/
        Mockito.when(httpServletRequestAccept.getHeader("Accept")).thenReturn("application/json");
        SurveysApiController surveyControllerAccept = new SurveysApiController(objectMapper,httpServletRequestAccept);
        ResponseEntity<Survey> getSurveyByIDOK = new ResponseEntity<>(null, HttpStatus.OK);
        ResponseEntity<Survey> getSurveysByIDIsOk =  surveyControllerAccept.updateSurvey(surveyID,survey);
        Assert.assertEquals(getSurveysByIDIsOk.getStatusCodeValue(),getSurveyByIDOK.getStatusCodeValue());
    }

    /**
     * Fonction createSurvey
     * Créer un sondage
     * Pour le status "Internal server error" ou "OK"
     */
    @Test
    public void createSurvey() {

        /** Variables **/
        long surveyID = 1L;
        String description = "description";
        String name = "vincent";
        Timestamp endDate = new Timestamp(120,12,15, 16,15,16,15);
        Survey survey = new Survey(description, name, true, endDate);
        Survey surveyBadRequest = new Survey("", "", true, endDate);
        Survey surveyConflict = new Survey("name", "description", true,  new Timestamp(118,12,15, 16,15,16,15));

        /** Test Bad Request **/
        SurveysApiController surveyControllerBadRequest = new SurveysApiController(objectMapper,httpServletRequest);
        ResponseEntity<Survey> surveysBadRequest = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        ResponseEntity<Survey> getSurveysByIDBadRequest =  surveyControllerBadRequest.createSurvey(surveyBadRequest);
        Assert.assertEquals(surveysBadRequest,getSurveysByIDBadRequest);

        /** Test Internal server error **/
        Mockito.when(httpServletRequest.getHeader("Accept")).thenReturn("");
        SurveysApiController surveyControllerInternalError = new SurveysApiController(objectMapper,httpServletRequest);
        ResponseEntity<Survey> surveysInternalError = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        ResponseEntity<Survey> getSurveysByIDInternalError =  surveyControllerInternalError.createSurvey(survey);
        Assert.assertEquals(surveysInternalError,getSurveysByIDInternalError);

        /** Test Conflict **/
        SurveysApiController surveyControllerConflict = new SurveysApiController(objectMapper,httpServletRequest);
        ResponseEntity<Survey> surveysConflict = new ResponseEntity<>(null, HttpStatus.CONFLICT);
        ResponseEntity<Survey> getSurveysByIDConflict =  surveyControllerConflict.createSurvey(surveyConflict);
        Assert.assertEquals(surveysConflict,getSurveysByIDConflict);

        /** Test Created **/
        Mockito.when(httpServletRequestAccept.getHeader("Accept")).thenReturn("application/json");
        SurveysApiController surveyControllerCreated = new SurveysApiController(objectMapper,httpServletRequestAccept);
        ResponseEntity<Survey> surveysCreated = new ResponseEntity<>(null, HttpStatus.CREATED);
        ResponseEntity<Survey> getSurveysByIDCreated =  surveyControllerCreated.createSurvey(survey);
        Assert.assertEquals(surveysCreated.getStatusCode(),getSurveysByIDCreated.getStatusCode());
     }



}
