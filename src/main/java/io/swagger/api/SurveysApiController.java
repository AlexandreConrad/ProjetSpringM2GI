package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Sondage;
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
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-31T12:55:18.203Z")

@Controller
public class SurveysApiController implements SurveysApi {

    private static final Logger log = LoggerFactory.getLogger(SurveysApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SurveysApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    /**
     * Supprime un survey depuis un surveyID
     * @param surveyID
     * @return
     */
    public ResponseEntity<Survey> deleteSurvey(@ApiParam(value = "Identifiant du sondage à supprimer.", required = true) @PathVariable("surveyID") Long surveyID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Survey survey = SurveyService.deleteSurvey(surveyID);
            return new ResponseEntity<Survey>(survey, HttpStatus.OK);
        }
        //TODO Retourne un code d'erreur pour les différents cas possibles
        return new ResponseEntity<Survey>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Clôture un sondage
     * @param surveyID
     * @return
     */
    public ResponseEntity<Survey> endSurveys(@ApiParam(value = "ID du sondage pour lequel on souhaite la fin", required = true) @PathVariable("surveyID") Long surveyID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Survey survey = SurveyService.endSurvey(surveyID);
            return new ResponseEntity<Survey>(survey, HttpStatus.OK);
        }
        //TODO Retourne un code d'erreur pour les différents cas possibles
        return new ResponseEntity<Survey>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Récupération d'un survey à l'aide d'un ID
     * @param surveyID
     * @return survey
     */
    public ResponseEntity<Survey> getSurvey(@ApiParam(value = "ID du sondage", required = true) @PathVariable("surveyID") Long surveyID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Survey survey = SurveyService.getSurveyByID(surveyID);
            return new ResponseEntity<Survey>(survey, HttpStatus.OK);
        }
        //TODO Retourne un code d'erreur pour les différents cas possibles
        return new ResponseEntity<Survey>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Récupération de tous les surveys
     * @return List<survey>
     */
    public ResponseEntity<List<Survey>> getSurveys() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            List<Survey> surveys = SurveyService.getSurveys();
            return new ResponseEntity<List<Survey>>(surveys,HttpStatus.OK);
        }
        //TODO Retourne un code d'erreur pour les différents cas possibles
        return new ResponseEntity<List<Survey>>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Récupération de tous les surveys actifs
     * @return List<Survey>
     */
    public ResponseEntity<List<Survey>> getSurveysIsActifs() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            List<Survey> surveys = SurveyService.getSurveysIsActives();
            return new ResponseEntity<List<Survey>>(surveys,HttpStatus.OK);
        }
        //TODO Retourne un code d'erreur pour les différents cas possibles
        return new ResponseEntity<List<Survey>>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Récupération de tous les surveys inactifs
     * @return List<Survey>
     */
    public ResponseEntity<List<Survey>> getSurveysIsInactifs() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            List<Survey> surveys = SurveyService.getSurveysIsExpireds();
            return new ResponseEntity<List<Survey>>(surveys,HttpStatus.OK);
        }
        //TODO Retourne un code d'erreur pour les différents cas possibles
        return new ResponseEntity<List<Survey>>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Mise a jour d'un survey
     * @param surveyID
     * @param body
     * @return Survey
     */
    public ResponseEntity<Survey> updateSurvey(@ApiParam(value = "Identifiant du sondage à modifier.", required = true) @PathVariable("surveyID") Long surveyID, @ApiParam(value = "Sondage modifié", required = true) @Valid @RequestBody Survey body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Survey survey = SurveyService.updateSurvey(surveyID,body);
            return new ResponseEntity<Survey>(survey,HttpStatus.OK);
        }
        //TODO Retourne un code d'erreur pour les différents cas possibles
        return new ResponseEntity<Survey>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Création d'un sondage
     * @param sondage
     * @return
     */
    public ResponseEntity<Survey> createSurvey(@ApiParam(value = "Un sondage doit être construit à l'aide d'un nom, d'une description et d'une date de fin.", required = true) @Valid @RequestBody Sondage sondage) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Survey survey = SurveyService.createSurvey(sondage);
            return new ResponseEntity<Survey>(survey,HttpStatus.OK);
        }
        //TODO Retourne un code d'erreur pour les différents cas possibles
        return new ResponseEntity<Survey>(HttpStatus.NOT_IMPLEMENTED);
    }

}
