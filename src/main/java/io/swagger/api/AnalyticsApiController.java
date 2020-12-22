package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Analytics;
import io.swagger.model.MostMaybe;
import io.swagger.model.MostPossible;
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

    public ResponseEntity<MostPossible> findDateByAvailable(@ApiParam(value = "ID du sondage pour lequel on souhaite avoir des statistiques", required = true) @PathVariable("surveyID") Long surveyID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            MostPossible maybe = AnalyticsService.findDateByAvailable(surveyID);
            return new ResponseEntity<MostPossible>(HttpStatus.OK);
        }
        //TODO Retourne un code d'erreur pour les différents cas possibles
        return new ResponseEntity<MostPossible>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<MostMaybe> findDateByMaybeAvailable(@ApiParam(value = "ID du sondage pour lequel on souhaite avoir des statistiques", required = true) @PathVariable("surveyID") Long surveyID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            MostMaybe maybe = AnalyticsService.findDateByMaybeAvailable(surveyID);
            return new ResponseEntity<MostMaybe>(HttpStatus.OK);
        }
        //TODO Retourne un code d'erreur pour les différents cas possibles
        return new ResponseEntity<MostMaybe>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Analytics> getAnalyticsById(@ApiParam(value = "ID du sondage pour lequel on souhaite avoir des statistiques", required = true) @PathVariable("surveyID") Long surveyID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Analytics analytics = AnalyticsService.getAnalyticsById(surveyID);
            return new ResponseEntity<Analytics>(HttpStatus.OK);
        }
        //TODO Retourne un code d'erreur pour les différents cas possibles
        return new ResponseEntity<Analytics>(HttpStatus.NOT_IMPLEMENTED);
    }

}
