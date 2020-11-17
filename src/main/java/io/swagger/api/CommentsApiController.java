package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Choice1;
import io.swagger.model.InlineResponse2001;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
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

    public ResponseEntity<Choice1> addComments(@ApiParam(value = "ID du sondage pour lequel on souhaite les commentaires", required = true) @PathVariable("surveyID") Long surveyID, @ApiParam(value = "Ajout d'un choix.", required = true) @Valid @RequestBody Choice1 choice) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Choice1>(objectMapper.readValue("{  \"id\" : 0,  \"message\" : \"message\"}", Choice1.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Choice1>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Choice1>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<InlineResponse2001>> getComments(@ApiParam(value = "ID du sondage pour lequel on souhaite les commentaires", required = true) @PathVariable("surveyID") Long surveyID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<InlineResponse2001>>(objectMapper.readValue("[ {  \"id\" : 0,  \"message\" : \"message\"}, {  \"id\" : 0,  \"message\" : \"message\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<InlineResponse2001>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<InlineResponse2001>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
