package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Choice;
import io.swagger.model.InlineResponse200;
import io.swagger.model.Survey;
import io.swagger.service.SurveyService;
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
public class ChoicesApiController implements ChoicesApi {

    private static final Logger log = LoggerFactory.getLogger(ChoicesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ChoicesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Choice>> getChoiceById(@ApiParam(value = "ID du sondage pour lequel on souhaite avoir les choix", required = true) @PathVariable("surveyID") Long surveyID) {
        String accept = request.getHeader("Accept");
        Survey survey = SurveyService.getSurveyByID(surveyID);

        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Choice>>(objectMapper.readValue("[ {  \"answers\" : {    \"unavailable\" : [ \"unavailable\", \"unavailable\" ],    \"available\" : [ \"available\", \"available\" ],    \"unknown\" : [ \"unknown\", \"unknown\" ]  },  \"id\" : 0,  \"option\" : \"2000-01-23T04:56:07.000+00:00\"}, {  \"answers\" : {    \"unavailable\" : [ \"unavailable\", \"unavailable\" ],    \"available\" : [ \"available\", \"available\" ],    \"unknown\" : [ \"unknown\", \"unknown\" ]  },  \"id\" : 0,  \"option\" : \"2000-01-23T04:56:07.000+00:00\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Choice>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Choice>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Choice> getDeleteById(@ApiParam(value = "ID du sondage", required = true) @PathVariable("surveyID") Long surveyID, @ApiParam(value = "ID du choix", required = true) @PathVariable("choiceID") Long choiceID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Choice>(objectMapper.readValue("{  \"answers\" : {    \"unavailable\" : [ \"unavailable\", \"unavailable\" ],    \"available\" : [ \"available\", \"available\" ],    \"unknown\" : [ \"unknown\", \"unknown\" ]  },  \"id\" : 0,  \"option\" : \"2000-01-23T04:56:07.000+00:00\"}", Choice.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Choice>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Choice>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Choice> postChoiceById(@ApiParam(value = "ID du sondage pour lequel on souhaite ajouter un choix", required = true) @PathVariable("surveyID") Long surveyID, @ApiParam(value = "Ajout d'un choix.", required = true) @Valid @RequestBody Choice choice) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Choice>(objectMapper.readValue("{  \"answers\" : {    \"unavailable\" : [ \"unavailable\", \"unavailable\" ],    \"available\" : [ \"available\", \"available\" ],    \"unknown\" : [ \"unknown\", \"unknown\" ]  },  \"id\" : 0,  \"option\" : \"2000-01-23T04:56:07.000+00:00\"}", Choice.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Choice>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Choice>(HttpStatus.NOT_IMPLEMENTED);
    }

}
