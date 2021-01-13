package controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.api.VotesApiController;
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

        /** Test not found **/
        ResponseEntity<List<Vote>> getVoteChoiceNotFound =  votesAccept.getVoteChoice(10000L);
        Assert.assertEquals(getVoteChoiceNotFound.getStatusCodeValue(),HttpStatus.NOT_FOUND.value());

        /** Test BAD_REQUEST **/
        ResponseEntity<List<Vote>> getVoteChoiceBad =  votesAccept.getVoteChoice(null);
        Assert.assertEquals(getVoteChoiceBad.getStatusCodeValue(),HttpStatus.BAD_REQUEST.value());
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

        /** Test not found **/
        ResponseEntity<List<Vote>> getVoteOptionNotFound =  votesAccept.getVoteOption(10000L);
        Assert.assertEquals(getVoteOptionNotFound.getStatusCodeValue(),HttpStatus.NOT_FOUND.value());

        /** Test BAD_REQUEST **/
        ResponseEntity<List<Vote>> getVoteOptionBad =  votesAccept.getVoteOption(null);
        Assert.assertEquals(getVoteOptionBad.getStatusCodeValue(),HttpStatus.BAD_REQUEST.value());
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

        /** Test not found **/
        ResponseEntity<Vote> postOptionFound =  votesAccept.postVote(1000L,choiceID,author);
        Assert.assertEquals(postOptionFound.getStatusCodeValue(),HttpStatus.NOT_FOUND.value());

        /** Test BAD_REQUEST **/
        ResponseEntity<Vote> postOptionBad =  votesAccept.postVote(null,choiceID,author);
        Assert.assertEquals(postOptionBad.getStatusCodeValue(),HttpStatus.BAD_REQUEST.value());
    }
}
