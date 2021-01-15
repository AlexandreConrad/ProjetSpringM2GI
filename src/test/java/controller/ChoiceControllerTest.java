package controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.univlorraine.m2.gi.groupe2.api.ChoicesApiController;
import fr.univlorraine.m2.gi.groupe2.model.Choice;
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
import java.sql.Timestamp;
import java.util.List;

/**
 * Test en rapport avec la classe "ChoiceApiController"
 */
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ChoiceControllerTest {

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
     * Fonction getChoiceById
     */
    @Test
    public void getChoiceById() {
        /** Variables **/
        Long surveyID = 1L;

        /** Test not implemented **/
        ChoicesApiController choiceController = new ChoicesApiController(objectMapper,httpServletRequest);
        ResponseEntity<List<Choice>> getChoiceByIdNotImplemented = new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        ResponseEntity<List<Choice>> getChoiceById =  choiceController.getChoiceById(surveyID);
        Assert.assertEquals(getChoiceByIdNotImplemented,getChoiceById);

        /** Test OK **/
        Mockito.when(httpServletRequestAccept.getHeader("Accept")).thenReturn("application/json");
        ChoicesApiController choiceControllerAccept = new ChoicesApiController(objectMapper,httpServletRequestAccept);
        ResponseEntity<List<Choice>> getChoiceByIdIsOK = new ResponseEntity<>(null, HttpStatus.OK);
        ResponseEntity<List<Choice>> getChoiceByIdOk =  choiceControllerAccept.getChoiceById(surveyID);
        Assert.assertEquals(getChoiceByIdIsOK.getStatusCodeValue(),getChoiceByIdOk.getStatusCodeValue());

        /** Test not found **/
        Mockito.when(httpServletRequestAccept.getHeader("Accept")).thenReturn("application/json");
        ChoicesApiController getChoiceByIdAccept = new ChoicesApiController(objectMapper,httpServletRequestAccept);
        ResponseEntity<List<Choice>> getChoiceByIdNotFound =  getChoiceByIdAccept.getChoiceById(10000L);;
        Assert.assertEquals(getChoiceByIdNotFound.getStatusCodeValue(),HttpStatus.NOT_FOUND.value());
    }

    /**
     * Fonction getDeleteById
     */
    @Test
    public void getDeleteById() {
        /** Variables **/
        Long surveyID = 1L;

        /** Test not implemented **/
        ChoicesApiController choiceController = new ChoicesApiController(objectMapper,httpServletRequest);
        ResponseEntity<Choice> deleteByIDNotImplemented = new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        ResponseEntity<Choice> deleteByID =  choiceController.getDeleteById(surveyID);
        Assert.assertEquals(deleteByIDNotImplemented,deleteByID);

        /** Test not found **/
        Mockito.when(httpServletRequestAccept.getHeader("Accept")).thenReturn("application/json");
        ChoicesApiController getChoiceByIdAccept = new ChoicesApiController(objectMapper,httpServletRequestAccept);
        ResponseEntity<Choice> deleteByIDNotFound =  getChoiceByIdAccept.getDeleteById(10000L);;
        Assert.assertEquals(deleteByIDNotFound.getStatusCodeValue(),HttpStatus.NOT_FOUND.value());
    }

    /**
     * Fonction postChoiceById
     */
    @Test
    public void postChoiceById() {
        /** Variables **/
        Long surveyID = 1L;
        Timestamp t = new Timestamp(1578927763);

        /** Test not implemented **/
        ChoicesApiController choiceController = new ChoicesApiController(objectMapper,httpServletRequest);
        ResponseEntity<Choice> postChoiceByIdNotImplemented = new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        ResponseEntity<Choice> postChoiceById =  choiceController.postChoiceById(surveyID,t);
        Assert.assertEquals(postChoiceByIdNotImplemented,postChoiceById);

        /** Test not found **/
        Mockito.when(httpServletRequestAccept.getHeader("Accept")).thenReturn("application/json");
        ChoicesApiController getChoiceByIdAccept = new ChoicesApiController(objectMapper,httpServletRequestAccept);
        ResponseEntity<Choice> postChoiceByIdNotFound =  getChoiceByIdAccept.postChoiceById(10000L,t);
        Assert.assertEquals(postChoiceByIdNotFound.getStatusCodeValue(),HttpStatus.NOT_FOUND.value());
    }
}
