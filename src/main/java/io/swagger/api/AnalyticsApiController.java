package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Analytics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.threeten.bp.OffsetDateTime;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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

    public ResponseEntity<OffsetDateTime> findDateByAvailable(@ApiParam(value = "ID du sondage pour lequel on souhaite avoir des statistiques", required = true) @PathVariable("surveyID") Long surveyID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<OffsetDateTime>(objectMapper.readValue("\"2000-01-23T04:56:07.000+00:00\"", OffsetDateTime.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<OffsetDateTime>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<OffsetDateTime>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<OffsetDateTime> findDateByMaybeAvailable(@ApiParam(value = "ID du sondage pour lequel on souhaite avoir des statistiques", required = true) @PathVariable("surveyID") Long surveyID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<OffsetDateTime>(objectMapper.readValue("\"2000-01-23T04:56:07.000+00:00\"", OffsetDateTime.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<OffsetDateTime>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<OffsetDateTime>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Analytics> getAnalyticsById(@ApiParam(value = "ID du sondage pour lequel on souhaite avoir des statistiques", required = true) @PathVariable("surveyID") Long surveyID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Analytics>(objectMapper.readValue("{  \"unavailable\" : [ \"unavailable\", \"unavailable\" ],  \"available\" : [ \"available\", \"available\" ],  \"unknown\" : [ \"unknown\", \"unknown\" ]}", Analytics.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Analytics>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Analytics>(HttpStatus.NOT_IMPLEMENTED);
    }

}
