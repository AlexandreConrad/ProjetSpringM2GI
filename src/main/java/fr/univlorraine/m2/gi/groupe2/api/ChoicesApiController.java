package fr.univlorraine.m2.gi.groupe2.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import fr.univlorraine.m2.gi.groupe2.exceptions.BadRequestException;
import fr.univlorraine.m2.gi.groupe2.exceptions.DatabaseException;
import fr.univlorraine.m2.gi.groupe2.exceptions.NotFoundException;
import fr.univlorraine.m2.gi.groupe2.model.Choice;
import fr.univlorraine.m2.gi.groupe2.service.ChoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Timestamp;
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

    /**
     * Recuperation de tous les choix d'un sondage
     *
     * @param surveyID
     * @return
     */
    public ResponseEntity<List<Choice>> getChoiceById(@ApiParam(value = "ID du sondage pour lequel on souhaite avoir les choix", required = true) @PathVariable("surveyID") Long surveyID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try{
                List<Choice> choices = ChoiceService.getChoiceById(surveyID);
                return new ResponseEntity<List<Choice>>(choices, HttpStatus.OK);
            }catch (NotFoundException e){
                return new ResponseEntity<List<Choice>>(HttpStatus.NOT_FOUND);
            }catch (DatabaseException d){
                return new ResponseEntity<List<Choice>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<List<Choice>>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Supprime definitivement un choix
     *
     * @param choiceID
     * @return
     */
    public ResponseEntity<Choice> getDeleteById(@ApiParam(value = "ID du choix", required = true) @PathVariable("choiceID") Long choiceID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try{
                Choice choice = ChoiceService.getDeleteById(choiceID);
                return new ResponseEntity<Choice>(choice, HttpStatus.OK);
            }catch (NotFoundException e){
                return new ResponseEntity<Choice>(HttpStatus.NOT_FOUND);
            }catch (DatabaseException d){
                return new ResponseEntity<Choice>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Choice>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Ajoute un choix à un sondage
     *
     * @param surveyID
     * @param choice
     * @return
     */
    public ResponseEntity<Choice> postChoiceById(@ApiParam(value = "ID du sondage pour lequel on souhaite ajouter un choix", required = true) @PathVariable("surveyID") Long surveyID, @ApiParam(value = "Ajout d'un choix.", required = true) @Valid @RequestBody Timestamp choice) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try{
                Choice cho = ChoiceService.postChoiceById(choice,surveyID);
                return new ResponseEntity<Choice>(cho, HttpStatus.OK);
            }catch (NotFoundException e){
                return new ResponseEntity<Choice>(HttpStatus.NOT_FOUND);
            }catch (DatabaseException d){
                return new ResponseEntity<Choice>(HttpStatus.INTERNAL_SERVER_ERROR);
            }catch (BadRequestException d){
                return new ResponseEntity<Choice>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<Choice>(HttpStatus.NOT_IMPLEMENTED);
    }

}
