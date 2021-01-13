package controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.api.AnalyticsApiController;
import io.swagger.model.Choice;
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


/**
 * Test en rapport avec la classe "VotesApiController"
 */
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class AnalyticsControllerTest {

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
     * Fonction findDateByAvailable
     */
    @Test
    public void findDateByAvailable() {

        /** Variables **/
        Long surveyID = 1L;

        /** Test not implemented **/
        AnalyticsApiController analyticsApiController = new AnalyticsApiController(objectMapper,httpServletRequest);
        ResponseEntity<Choice> analyticsApiNotImplemented = new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        ResponseEntity<Choice> notImplemented =  analyticsApiController.findDateByAvailable(surveyID);
        Assert.assertEquals(notImplemented,analyticsApiNotImplemented);

        /** Test OK **/
        Mockito.when(httpServletRequestAccept.getHeader("Accept")).thenReturn("application/json");
        AnalyticsApiController analyticsApiControllerAccept = new AnalyticsApiController(objectMapper,httpServletRequestAccept);
        ResponseEntity<Choice> analyticsApiOK = new ResponseEntity<>(null, HttpStatus.OK);
        ResponseEntity<Choice> ok =  analyticsApiControllerAccept.findDateByAvailable(surveyID);
        Assert.assertEquals(ok.getStatusCodeValue(),analyticsApiOK.getStatusCodeValue());

        /** Test not found **/
        ResponseEntity<Choice> getVoteChoiceNotFound =  analyticsApiControllerAccept.findDateByAvailable(10000L);
        Assert.assertEquals(getVoteChoiceNotFound.getStatusCodeValue(),HttpStatus.NOT_FOUND.value());
    }

    /**
     * Fonction findDateByMaybeAvailable
     */
    @Test
    public void findDateByMaybeAvailable() {

        /** Variables **/
        Long surveyID = 1L;

        /** Test not implemented **/
        AnalyticsApiController analyticsApiController = new AnalyticsApiController(objectMapper,httpServletRequest);
        ResponseEntity<Choice> analyticsApiNotImplemented = new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        ResponseEntity<Choice> notImplemented =  analyticsApiController.findDateByMaybeAvailable(surveyID);
        Assert.assertEquals(notImplemented,analyticsApiNotImplemented);

        /** Test OK **/
        Mockito.when(httpServletRequestAccept.getHeader("Accept")).thenReturn("application/json");
        AnalyticsApiController analyticsApiControllerAccept = new AnalyticsApiController(objectMapper,httpServletRequestAccept);
        ResponseEntity<Choice> analyticsApiOK = new ResponseEntity<>(null, HttpStatus.OK);
        ResponseEntity<Choice> ok =  analyticsApiControllerAccept.findDateByMaybeAvailable(surveyID);
        Assert.assertEquals(ok.getStatusCodeValue(),analyticsApiOK.getStatusCodeValue());

        /** Test not found **/
        ResponseEntity<Choice> getVoteChoiceNotFound =  analyticsApiControllerAccept.findDateByMaybeAvailable(10000L);
        Assert.assertEquals(getVoteChoiceNotFound.getStatusCodeValue(),HttpStatus.NOT_FOUND.value());
    }
}
