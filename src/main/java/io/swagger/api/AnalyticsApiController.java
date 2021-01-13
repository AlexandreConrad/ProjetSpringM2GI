package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.exceptions.DatabaseException;
import io.swagger.exceptions.NotFoundException;
import io.swagger.model.Choice;
import io.swagger.service.AnalyticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-31T12:55:18.203Z")

@Controller
public class AnalyticsApiController implements AnalyticsApi {

    private static final Logger log = LoggerFactory.getLogger(AnalyticsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public AnalyticsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Choice> findDateByAvailable(@ApiParam(value = "ID du sondage pour lequel on souhaite avoir des statistiques", required = true) @PathVariable("surveyID") Long surveyID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                Choice maybe = AnalyticsService.findDateByAvailable(surveyID);
                return new ResponseEntity<Choice>(maybe, HttpStatus.OK);
            }catch (NotFoundException e){
                return new ResponseEntity<Choice>(HttpStatus.NOT_FOUND);
            }catch (DatabaseException d){
                return new ResponseEntity<Choice>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        //TODO Retourne un code d'erreur pour les différents cas possibles
        return new ResponseEntity<Choice>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Choice> findDateByMaybeAvailable(@ApiParam(value = "ID du sondage pour lequel on souhaite avoir des statistiques", required = true) @PathVariable("surveyID") Long surveyID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                Choice maybe = AnalyticsService.findDateByMaybeAvailable(surveyID);
                return new ResponseEntity<Choice>(maybe, HttpStatus.OK);
            }catch (NotFoundException e){
                return new ResponseEntity<Choice>(HttpStatus.NOT_FOUND);
            }catch (DatabaseException d){
                return new ResponseEntity<Choice>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        //TODO Retourne un code d'erreur pour les différents cas possibles
        return new ResponseEntity<Choice>(HttpStatus.NOT_IMPLEMENTED);
    }

}
