package io.swagger.api;

import io.swagger.model.Choice;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-31T12:55:18.203Z")

@Controller
public class VotesApiController implements VotesApi {

    private static final Logger log = LoggerFactory.getLogger(VotesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public VotesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Choice> postVote(@ApiParam(value = "ID du sondage pour lequel on souhaite avoir des statistiques",required=true) @PathVariable("surveyID") Long surveyID,@ApiParam(value = "ID du choix de la date",required=true) @PathVariable("choiceID") Long choiceID,@ApiParam(value = "Choix de l'utilisateur" ,required=true )  @Valid @RequestBody Choice choice) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Choice>(objectMapper.readValue("{  \"answers\" : {    \"unavailable\" : [ \"unavailable\", \"unavailable\" ],    \"available\" : [ \"available\", \"available\" ],    \"unknown\" : [ \"unknown\", \"unknown\" ]  },  \"id\" : 6,  \"option\" : \"2000-01-23T04:56:07.000+00:00\"}", Choice.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Choice>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Choice>(HttpStatus.NOT_IMPLEMENTED);
    }

}
