package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Comment;
import io.swagger.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-31T12:55:18.203Z")

@Controller
public class CommentsApiController implements CommentsApi {

    private static final Logger log = LoggerFactory.getLogger(CommentsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CommentsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Comment> addComments(@ApiParam(value = "ID du sondage pour lequel on souhaite les commentaires", required = true) @PathVariable("surveyID") Long surveyID, @ApiParam(value = "Nom de l'auteur", required = true) @PathVariable("auteur") String auteur, @ApiParam(value = "Ajout d'un commentaire.", required = true) @Valid @RequestBody String message) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Comment comment = CommentService.addComments(surveyID, message, auteur);
            return new ResponseEntity<Comment>(comment, HttpStatus.OK);
        }
        //TODO Retourne un code d'erreur pour les différents cas possibles
        return new ResponseEntity<Comment>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Comment>> getComments(@ApiParam(value = "ID du sondage pour lequel on souhaite les commentaires", required = true) @PathVariable("surveyID") Long surveyID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            List<Comment> comments = CommentService.getComments(surveyID);
            return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
        }
        //TODO Retourne un code d'erreur pour les différents cas possibles
        return new ResponseEntity<List<Comment>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
