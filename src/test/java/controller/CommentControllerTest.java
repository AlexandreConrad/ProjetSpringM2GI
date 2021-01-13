package controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.api.CommentsApiController;
import io.swagger.model.Comment;
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
 * Test en rapport avec la classe "CommentsApiController"
 */
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CommentControllerTest {

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
     * Fonction addComments
     * Permet l'ajout d'un commentaire
     * Pour le status "NotImplemented" ou "OK"
     */
    @Test
    public void addComments() {

        /** Variables **/
        Long surveyID = 1L;
        String author = "Alexandre";
        String message = "soirée null";

        /** Test not implemented **/
        CommentsApiController commentsIsNull = new CommentsApiController(objectMapper,httpServletRequest);
        ResponseEntity<Comment> commentNotImplemented = new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        ResponseEntity<Comment> commentAddNotImplemented =  commentsIsNull.addComments(surveyID,author,message);
        Assert.assertEquals(commentNotImplemented,commentAddNotImplemented);

        /** Test OK **/
        Mockito.when(httpServletRequestAccept.getHeader("Accept")).thenReturn("application/json");
        CommentsApiController commentAccept = new CommentsApiController(objectMapper,httpServletRequestAccept);
        ResponseEntity<Comment> commentOK = new ResponseEntity<>(null, HttpStatus.OK);
        ResponseEntity<Comment> commentAddOk =  commentAccept.addComments(surveyID,author,message);
        Assert.assertEquals(commentAddOk.getStatusCodeValue(),commentOK.getStatusCodeValue());

        /** Test not found **/
        ResponseEntity<Comment> commentAddNotFound =  commentAccept.addComments(1000L,author,message);
        Assert.assertEquals(commentAddNotFound.getStatusCodeValue(),HttpStatus.NOT_FOUND.value());

        /** Test BAD_REQUEST **/
        ResponseEntity<Comment> commentAddServerBad =  commentAccept.addComments(null,author,message);
        Assert.assertEquals(commentAddServerBad.getStatusCodeValue(),HttpStatus.BAD_REQUEST.value());
    }

    /**
     * Fonction getComments
     * Retourne tous les commentaires
     * Pour le status "NotImplemented" ou "OK"
     */
    @Test
    public void getComments() {

        /** Variables **/
        Long surveyID = 1L;

        /** Test not implemented **/
        CommentsApiController commentsIsNull = new CommentsApiController(objectMapper,httpServletRequest);
        ResponseEntity<List<Comment>> listCommentsNotImplemented = new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        ResponseEntity<List<Comment>> commentsNotImplemented =  commentsIsNull.getComments(surveyID);
        Assert.assertEquals(commentsNotImplemented,listCommentsNotImplemented);

        /** Test OK **/
        Mockito.when(httpServletRequestAccept.getHeader("Accept")).thenReturn("application/json");
        CommentsApiController commentsAccept = new CommentsApiController(objectMapper,httpServletRequestAccept);
        ResponseEntity<List<Comment>> listCommentsOK = new ResponseEntity<>(null, HttpStatus.OK);
        ResponseEntity<List<Comment>> commentsOk =  commentsAccept.getComments(surveyID);
        Assert.assertEquals(commentsOk.getStatusCodeValue(),listCommentsOK.getStatusCodeValue());

        /** Test not found **/
        ResponseEntity<List<Comment>> getCommentsIdNotFound =  commentsAccept.getComments(10000L);;
        Assert.assertEquals(getCommentsIdNotFound.getStatusCodeValue(),HttpStatus.NOT_FOUND.value());
    }
}
