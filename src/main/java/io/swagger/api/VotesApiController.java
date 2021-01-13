package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.exceptions.BadRequestException;
import io.swagger.exceptions.DatabaseException;
import io.swagger.exceptions.NotFoundException;
import io.swagger.model.Vote;
import io.swagger.service.VoteService;
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
public class VotesApiController implements VotesApi {

    private static final Logger log = LoggerFactory.getLogger(VotesApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public VotesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Vote> postVote(@ApiParam(value = "ID de l'option qu'on souhaite", required = true) @PathVariable("optionID") Long optionID, @ApiParam(value = "ID du choix de la date", required = true) @PathVariable("choiceID") Long choiceID, @ApiParam(value = "Nom du participant", required = true) @Valid @RequestBody String auteur) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try{
                Vote vote = VoteService.postVote(auteur, choiceID, optionID);
                return new ResponseEntity<Vote>(vote, HttpStatus.OK);
            }catch (NotFoundException e){
                return new ResponseEntity<Vote>(HttpStatus.NOT_FOUND);
            }catch (DatabaseException d){
                return new ResponseEntity<Vote>(HttpStatus.INTERNAL_SERVER_ERROR);
            }catch (BadRequestException d){
                return new ResponseEntity<Vote>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<Vote>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Vote>> getVoteOption(@ApiParam(value = "ID de l'option", required = true) @PathVariable("optionID") Long optionID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try{
                List<Vote> votes = VoteService.getVoteOption(optionID);
                return new ResponseEntity<List<Vote>>(votes, HttpStatus.OK);
            }catch (NotFoundException e){
                return new ResponseEntity<List<Vote>>(HttpStatus.NOT_FOUND);
            }catch (DatabaseException d){
                return new ResponseEntity<List<Vote>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }catch (BadRequestException d){
                return new ResponseEntity<List<Vote>>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<List<Vote>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Vote>> getVoteChoice(@ApiParam(value = "ID du choix", required = true) @PathVariable("choiceID") Long choiceID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try{
                List<Vote> votes = VoteService.getVoteChoice(choiceID);
                return new ResponseEntity<List<Vote>>(votes, HttpStatus.OK);
            }catch (NotFoundException e){
                return new ResponseEntity<List<Vote>>(HttpStatus.NOT_FOUND);
            }catch (DatabaseException d){
                return new ResponseEntity<List<Vote>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }catch (BadRequestException d){
                return new ResponseEntity<List<Vote>>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<List<Vote>>(HttpStatus.NOT_IMPLEMENTED);
    }
}
