package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Choice;
import io.swagger.model.Survey;
import io.swagger.service.SurveyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.OffsetDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;

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
     *
     * @param surveyID
     * @return
     */
    public ResponseEntity<Survey> deleteSurvey(@ApiParam(value = "Identifiant du sondage à supprimer.", required = true) @PathVariable("surveyID") Long surveyID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Survey survey = SurveyService.deleteSurvey(surveyID);
            if (survey == null)  // l'objet est null donc il n'a pas été trouvé en base
                return new ResponseEntity<Survey>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<Survey>(survey, HttpStatus.OK);
        }
        else
            return new ResponseEntity<Survey>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Clôture un sondage
     *
     * @param surveyID
     * @return
     */
    public ResponseEntity<Survey> endSurveys(@ApiParam(value = "ID du sondage pour lequel on souhaite la fin", required = true) @PathVariable("surveyID") Long surveyID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Survey survey = SurveyService.endSurvey(surveyID);
            if (survey == null)
                return new ResponseEntity<Survey>(HttpStatus.NOT_FOUND);
            if (survey.getEndDate() == null || survey.getDescription() == null || survey.getName() == null || survey.getIsAvailable() == null)
                return new ResponseEntity<Survey>(HttpStatus.BAD_REQUEST);
            if (survey.getName().length() == 0 || survey.getDescription().length() == 0)
                return new ResponseEntity<Survey>(HttpStatus.CONFLICT);
            return new ResponseEntity<Survey>(survey, HttpStatus.OK);
        }
        return new ResponseEntity<Survey>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Récupération d'un survey à l'aide d'un ID
     *
     * @param surveyID
     * @return survey
     */
    public ResponseEntity<Survey> getSurvey(@ApiParam(value = "ID du sondage", required = true) @PathVariable("surveyID") Long surveyID) {
        String accept = request.getHeader("Accept");
        Survey survey = SurveyService.getSurveyByID(surveyID);
        if (accept != null && accept.contains("application/json")) {
            if (survey == null)
                return new ResponseEntity<Survey>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<Survey>(survey, HttpStatus.OK);
        }
        else
            return new ResponseEntity<Survey>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Récupération de tous les surveys
     *
     * @return List<survey>
     */
    public ResponseEntity<List<Survey>> getSurveys() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            List<Survey> surveys = SurveyService.getSurveys();
            if (surveys == null)
                return new ResponseEntity<List<Survey>>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<List<Survey>>(surveys,HttpStatus.OK);
        }
        else
            return new ResponseEntity<List<Survey>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Récupération de tous les surveys actifs
     *
     * @return List<Survey>
     */
    public ResponseEntity<List<Survey>> getSurveysIsActifs() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            List<Survey> surveys = SurveyService.getSurveysIsActives();
            for (Survey survey : surveys) {
                if (survey == null)
                    return new ResponseEntity<List<Survey>>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<List<Survey>>(surveys,HttpStatus.OK);
        }
        else
            return new ResponseEntity<List<Survey>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Récupération de tous les surveys inactifs
     *
     * @return List<Survey>
     */
    public ResponseEntity<List<Survey>> getSurveysIsInactifs() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            List<Survey> surveys = SurveyService.getSurveysIsExpireds();
            for (Survey survey : surveys) {
                if (survey == null)
                    return new ResponseEntity<List<Survey>>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<List<Survey>>(surveys,HttpStatus.OK);
        }
        else
            return new ResponseEntity<List<Survey>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Mise a jour d'un survey
     *
     * @param surveyID
     * @param body
     * @return Survey
     */
    public ResponseEntity<Survey> updateSurvey(@ApiParam(value = "Identifiant du sondage à modifier.", required = true) @PathVariable("surveyID") Long surveyID, @ApiParam(value = "Sondage modifié", required = true) @Valid @RequestBody Survey body) {
        String accept = request.getHeader("Accept");
        Survey survey = SurveyService.updateSurvey(surveyID,body);
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<Survey>(survey,HttpStatus.OK);
        }
        else if (body == null)
            return new ResponseEntity<Survey>(HttpStatus.CONFLICT);
        else if (body.getDescription().length() == 0 || body.getName().length() == 0)
            return new ResponseEntity<Survey>(HttpStatus.BAD_REQUEST);
        else if (survey == null)
            return new ResponseEntity<Survey>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<Survey>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Création d'un sondage
     *
     * @param Survey
     * @return
     */
    public ResponseEntity<Survey> createSurvey(@ApiParam(value = "Un sondage doit être construit à l'aide d'un nom, d'une description et d'une date de fin.", required = true) @Valid @RequestBody Survey sondage) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Survey survey = SurveyService.createSurvey(sondage);
            return new ResponseEntity<Survey>(survey,HttpStatus.CREATED);
        }
        else if (sondage.getEndDate().before(new Timestamp(System.currentTimeMillis())))
            return new ResponseEntity<Survey>(HttpStatus.CONFLICT);
        else if (sondage.getDescription().length() == 0 || sondage.getName().length() == 0)
            return new ResponseEntity<Survey>(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<Survey>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
