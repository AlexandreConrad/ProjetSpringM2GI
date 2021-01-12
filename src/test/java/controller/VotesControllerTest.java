package controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.api.VotesApiController;
import io.swagger.model.Option;
import io.swagger.model.Vote;
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
 * Test en rapport avec la classe "VotesApiController"
 */
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class VotesControllerTest {

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

    @Mock
    VotesApiController votesApiController;

    /**
     * Fonction getVoteChoice
     * Retourne tous les votes d'un choice
     * Pour le status "NotImplemented" ou "OK"
     */
    @Test
    public void getVoteChoice() {

        /** Variables **/
        Long choiceID = 1L;

        /** Test not implemented **/
        VotesApiController votesNull = new VotesApiController(objectMapper,httpServletRequest);
        ResponseEntity<List<Vote>> listNotImplemented = new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        ResponseEntity<List<Vote>> votesNotImplemented =  votesNull.getVoteChoice(choiceID);
        Assert.assertEquals(votesNotImplemented,listNotImplemented);

        /** Test OK **/
        Mockito.when(httpServletRequestAccept.getHeader("Accept")).thenReturn("application/json");
        VotesApiController votesAccept = new VotesApiController(objectMapper,httpServletRequestAccept);
        ResponseEntity<List<Vote>> listOK = new ResponseEntity<>(null, HttpStatus.OK);
        ResponseEntity<List<Vote>> votesOk =  votesAccept.getVoteChoice(choiceID);
        Assert.assertEquals(votesOk.getStatusCodeValue(),listOK.getStatusCodeValue());
    }

    /**
     * Fonction getVoteOption
     * Retourne tous les votes d'une option
     * Pour le status "NotImplemented" ou "OK"
     */
    @Test
    public void getVoteOption() {
        /** Variables **/
        Long optionID = 1L;

        /** Test not implemented **/
        VotesApiController votesNull = new VotesApiController(objectMapper,httpServletRequest);
        ResponseEntity<List<Vote>> listNotImplemented = new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        ResponseEntity<List<Vote>> optionsNotImplemented =  votesNull.getVoteOption(optionID);
        Assert.assertEquals(optionsNotImplemented,listNotImplemented);

        /** Test OK **/
        Mockito.when(httpServletRequestAccept.getHeader("Accept")).thenReturn("application/json");
        VotesApiController votesAccept = new VotesApiController(objectMapper,httpServletRequestAccept);
        ResponseEntity<List<Vote>> listOK = new ResponseEntity<>(null, HttpStatus.OK);
        ResponseEntity<List<Vote>> optionOk =  votesAccept.getVoteOption(optionID);
        Assert.assertEquals(optionOk.getStatusCodeValue(),listOK.getStatusCodeValue());
    }

    /**
     * Fonction postOption
     * Permet l'ajout d'une option
     * Pour le status "NotImplemented" ou "OK"
     */
    @Test
    public void postOption() {
        /** Variables **/
        String author = "Alexandre";
        Long optionID = 1L;
        Long choiceID = 1L;

        /** Test not implemented **/
        VotesApiController postNull = new VotesApiController(objectMapper,httpServletRequest);
        ResponseEntity<Vote> voteNotImplemented = new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        ResponseEntity<Vote> votePostNotImplemented =  postNull.postVote(optionID,choiceID,author);
        Assert.assertEquals(voteNotImplemented,votePostNotImplemented);

        /** Test OK **/
        Mockito.when(httpServletRequestAccept.getHeader("Accept")).thenReturn("application/json");
        VotesApiController votesAccept = new VotesApiController(objectMapper,httpServletRequestAccept);
        ResponseEntity<Vote> voteOk = new ResponseEntity<>(null, HttpStatus.OK);
        ResponseEntity<Vote> optionOk =  votesAccept.postVote(optionID,choiceID,author);
        Assert.assertEquals(optionOk.getStatusCodeValue(),voteOk.getStatusCodeValue());
    }
}
