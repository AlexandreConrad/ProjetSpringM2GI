package io.swagger.api;

import io.swagger.model.InlineResponse201;
import io.swagger.util.HibernateUtil;
import org.hibernate.*;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.threeten.bp.OffsetDateTime;
import io.swagger.model.Sondage;
import io.swagger.model.Survey;
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


import javax.validation.Configuration;
import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
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

    public ResponseEntity<Survey> deleteSurvey(@ApiParam(value = "Identifiant du sondage à supprimer.",required=true) @PathVariable("surveyID") Long surveyID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<Survey>(objectMapper.readValue("<Survey>  <id>123456789</id>  <name>aeiou</name>  <description>aeiou</description>  <isAvailable>true</isAvailable>  <endDate>2000-01-23T04:56:07.000Z</endDate>  <comments>  </comments>  <votes>  </votes></Survey>", Survey.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Survey>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Survey>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<OffsetDateTime> endSurveys(@ApiParam(value = "ID du sondage pour lequel on souhaite la fin",required=true) @PathVariable("surveyID") Long surveyID) {
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

    public ResponseEntity<Survey> getSurvey(@ApiParam(value = "ID du sondage",required=true) @PathVariable("surveyID") Long surveyID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Survey>(objectMapper.readValue("{  \"isAvailable\" : false,  \"comments\" : [ \"{\\\"id\\\":0,\\\"name\\\":\\\"Commentaire numéro 1\\\"}\", \"{\\\"id\\\":0,\\\"name\\\":\\\"Commentaire numéro 1\\\"}\" ],  \"endDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"name\" : \"name\",  \"description\" : \"description\",  \"votes\" : [ {    \"answers\" : {      \"unavailable\" : [ \"unavailable\", \"unavailable\" ],      \"available\" : [ \"available\", \"available\" ],      \"unknown\" : [ \"unknown\", \"unknown\" ]    },    \"id\" : 6,    \"option\" : \"2000-01-23T04:56:07.000+00:00\"  }, {    \"answers\" : {      \"unavailable\" : [ \"unavailable\", \"unavailable\" ],      \"available\" : [ \"available\", \"available\" ],      \"unknown\" : [ \"unknown\", \"unknown\" ]    },    \"id\" : 6,    \"option\" : \"2000-01-23T04:56:07.000+00:00\"  } ],  \"id\" : 0}", Survey.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Survey>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Survey>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Survey>> getSurveys() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                /*CODE A FAIRE*/
                Session session = HibernateUtil.getSessionFactory().openSession();//Ouverture d'une session
                Transaction transaction = session.beginTransaction();//Ouverture d'une transaction en cas de problème
                Survey survey = session.load(Survey.class, 1);//Récupération du sondage 1
                System.out.println(survey.getName());
                transaction.commit();
                session.close();
                HibernateUtil.getSessionFactory().close();
                //return survey;
                return new ResponseEntity<List<Survey>>(objectMapper.readValue("[ {  \"isAvailable\" : false,  \"comments\" : [ \"{\\\"id\\\":0,\\\"name\\\":\\\"Commentaire numéro 1\\\"}\", \"{\\\"id\\\":0,\\\"name\\\":\\\"Commentaire numéro 1\\\"}\" ],  \"endDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"name\" : \"name\",  \"description\" : \"description\",  \"votes\" : [ {    \"answers\" : {      \"unavailable\" : [ \"unavailable\", \"unavailable\" ],      \"available\" : [ \"available\", \"available\" ],      \"unknown\" : [ \"unknown\", \"unknown\" ]    },    \"id\" : 6,    \"option\" : \"2000-01-23T04:56:07.000+00:00\"  }, {    \"answers\" : {      \"unavailable\" : [ \"unavailable\", \"unavailable\" ],      \"available\" : [ \"available\", \"available\" ],      \"unknown\" : [ \"unknown\", \"unknown\" ]    },    \"id\" : 6,    \"option\" : \"2000-01-23T04:56:07.000+00:00\"  } ],  \"id\" : 0}, {  \"isAvailable\" : false,  \"comments\" : [ \"{\\\"id\\\":0,\\\"name\\\":\\\"Commentaire numéro 1\\\"}\", \"{\\\"id\\\":0,\\\"name\\\":\\\"Commentaire numéro 1\\\"}\" ],  \"endDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"name\" : \"name\",  \"description\" : \"description\",  \"votes\" : [ {    \"answers\" : {      \"unavailable\" : [ \"unavailable\", \"unavailable\" ],      \"available\" : [ \"available\", \"available\" ],      \"unknown\" : [ \"unknown\", \"unknown\" ]    },    \"id\" : 6,    \"option\" : \"2000-01-23T04:56:07.000+00:00\"  }, {    \"answers\" : {      \"unavailable\" : [ \"unavailable\", \"unavailable\" ],      \"available\" : [ \"available\", \"available\" ],      \"unknown\" : [ \"unknown\", \"unknown\" ]    },    \"id\" : 6,    \"option\" : \"2000-01-23T04:56:07.000+00:00\"  } ],  \"id\" : 0} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Survey>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Survey>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Survey>> getSurveysIsActifs() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Survey>>(objectMapper.readValue("[ {  \"isAvailable\" : false,  \"comments\" : [ \"{\\\"id\\\":0,\\\"name\\\":\\\"Commentaire numéro 1\\\"}\", \"{\\\"id\\\":0,\\\"name\\\":\\\"Commentaire numéro 1\\\"}\" ],  \"endDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"name\" : \"name\",  \"description\" : \"description\",  \"votes\" : [ {    \"answers\" : {      \"unavailable\" : [ \"unavailable\", \"unavailable\" ],      \"available\" : [ \"available\", \"available\" ],      \"unknown\" : [ \"unknown\", \"unknown\" ]    },    \"id\" : 6,    \"option\" : \"2000-01-23T04:56:07.000+00:00\"  }, {    \"answers\" : {      \"unavailable\" : [ \"unavailable\", \"unavailable\" ],      \"available\" : [ \"available\", \"available\" ],      \"unknown\" : [ \"unknown\", \"unknown\" ]    },    \"id\" : 6,    \"option\" : \"2000-01-23T04:56:07.000+00:00\"  } ],  \"id\" : 0}, {  \"isAvailable\" : false,  \"comments\" : [ \"{\\\"id\\\":0,\\\"name\\\":\\\"Commentaire numéro 1\\\"}\", \"{\\\"id\\\":0,\\\"name\\\":\\\"Commentaire numéro 1\\\"}\" ],  \"endDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"name\" : \"name\",  \"description\" : \"description\",  \"votes\" : [ {    \"answers\" : {      \"unavailable\" : [ \"unavailable\", \"unavailable\" ],      \"available\" : [ \"available\", \"available\" ],      \"unknown\" : [ \"unknown\", \"unknown\" ]    },    \"id\" : 6,    \"option\" : \"2000-01-23T04:56:07.000+00:00\"  }, {    \"answers\" : {      \"unavailable\" : [ \"unavailable\", \"unavailable\" ],      \"available\" : [ \"available\", \"available\" ],      \"unknown\" : [ \"unknown\", \"unknown\" ]    },    \"id\" : 6,    \"option\" : \"2000-01-23T04:56:07.000+00:00\"  } ],  \"id\" : 0} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Survey>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Survey>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Survey>> getSurveysIsInactifs() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Survey>>(objectMapper.readValue("[ {  \"isAvailable\" : false,  \"comments\" : [ \"{\\\"id\\\":0,\\\"name\\\":\\\"Commentaire numéro 1\\\"}\", \"{\\\"id\\\":0,\\\"name\\\":\\\"Commentaire numéro 1\\\"}\" ],  \"endDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"name\" : \"name\",  \"description\" : \"description\",  \"votes\" : [ {    \"answers\" : {      \"unavailable\" : [ \"unavailable\", \"unavailable\" ],      \"available\" : [ \"available\", \"available\" ],      \"unknown\" : [ \"unknown\", \"unknown\" ]    },    \"id\" : 6,    \"option\" : \"2000-01-23T04:56:07.000+00:00\"  }, {    \"answers\" : {      \"unavailable\" : [ \"unavailable\", \"unavailable\" ],      \"available\" : [ \"available\", \"available\" ],      \"unknown\" : [ \"unknown\", \"unknown\" ]    },    \"id\" : 6,    \"option\" : \"2000-01-23T04:56:07.000+00:00\"  } ],  \"id\" : 0}, {  \"isAvailable\" : false,  \"comments\" : [ \"{\\\"id\\\":0,\\\"name\\\":\\\"Commentaire numéro 1\\\"}\", \"{\\\"id\\\":0,\\\"name\\\":\\\"Commentaire numéro 1\\\"}\" ],  \"endDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"name\" : \"name\",  \"description\" : \"description\",  \"votes\" : [ {    \"answers\" : {      \"unavailable\" : [ \"unavailable\", \"unavailable\" ],      \"available\" : [ \"available\", \"available\" ],      \"unknown\" : [ \"unknown\", \"unknown\" ]    },    \"id\" : 6,    \"option\" : \"2000-01-23T04:56:07.000+00:00\"  }, {    \"answers\" : {      \"unavailable\" : [ \"unavailable\", \"unavailable\" ],      \"available\" : [ \"available\", \"available\" ],      \"unknown\" : [ \"unknown\", \"unknown\" ]    },    \"id\" : 6,    \"option\" : \"2000-01-23T04:56:07.000+00:00\"  } ],  \"id\" : 0} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Survey>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Survey>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Survey> updateSurvey(@ApiParam(value = "Identifiant du sondage à modifier.",required=true) @PathVariable("surveyID") Long surveyID,@ApiParam(value = "Sondage modifié" ,required=true )  @Valid @RequestBody Survey body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<Survey>(objectMapper.readValue("<Survey>  <id>123456789</id>  <name>aeiou</name>  <description>aeiou</description>  <isAvailable>true</isAvailable>  <endDate>2000-01-23T04:56:07.000Z</endDate>  <comments>  </comments>  <votes>  </votes></Survey>", Survey.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Survey>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Survey>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse201> uploadFile(@ApiParam(value = "Un sondage doit être construit à l'aide d'un nom, d'une description et d'une date de fin." ,required=true )  @Valid @RequestBody Sondage sondage) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse201>(objectMapper.readValue("{  \"isAvailable\" : true,  \"comments\" : [ \"{}\", \"{}\" ],  \"endDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"name\" : \"name\",  \"description\" : \"description\",  \"votes\" : [ \"{}\", \"{}\" ],  \"id\" : 0}", InlineResponse201.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse201>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse201>(HttpStatus.NOT_IMPLEMENTED);
    }

}
