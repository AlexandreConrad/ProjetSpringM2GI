/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.16).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.annotations.*;
import io.swagger.model.ChoicessurveyIDAnswers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.threeten.bp.OffsetDateTime;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-31T12:55:18.203Z")

@Api(value = "analytics", description = "the analytics API")
@RequestMapping(value = "/Alex57x/Projet/1.0.0")
public interface AnalyticsApi {

    @ApiOperation(value = "Date avec le plus de personnes présentes", nickname = "findDateByAvailable", notes = "Trouve la date pour laquelle le plus de personnes sont sûres d'être présentes", response = OffsetDateTime.class, tags = {"analytics",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Opération réussie", response = OffsetDateTime.class),
            @ApiResponse(code = 404, message = "Ressource introuvable."),
            @ApiResponse(code = 500, message = "Echec de connexion à la base de données.")})
    @RequestMapping(value = "/analytics/{surveyID}/available",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<OffsetDateTime> findDateByAvailable(@ApiParam(value = "ID du sondage pour lequel on souhaite avoir des statistiques", required = true) @PathVariable("surveyID") Long surveyID);


    @ApiOperation(value = "Date avec le plus de personnes potentiellement présentes", nickname = "findDateByMaybeAvailable", notes = "Trouve la date pour laquelle le plus de personnes sont présents ou potentiellement présentes", response = OffsetDateTime.class, tags = {"analytics",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Opération réussie", response = OffsetDateTime.class),
            @ApiResponse(code = 404, message = "Ressource introuvable."),
            @ApiResponse(code = 500, message = "Echec de connexion à la base de données.")})
    @RequestMapping(value = "/analytics/{surveyID}/maybe",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<OffsetDateTime> findDateByMaybeAvailable(@ApiParam(value = "ID du sondage pour lequel on souhaite avoir des statistiques", required = true) @PathVariable("surveyID") Long surveyID);


    @ApiOperation(value = "Statistiques du sondage", nickname = "getAnalyticsById", notes = "Retourne les statistiques liées au sondage passé en paramètre", response = ChoicessurveyIDAnswers.class, tags = {"analytics",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Opération réussie", response = ChoicessurveyIDAnswers.class),
            @ApiResponse(code = 404, message = "Ressource introuvable."),
            @ApiResponse(code = 500, message = "Echec de connexion à la base de données.")})
    @RequestMapping(value = "/analytics/{surveyID}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<ChoicessurveyIDAnswers> getAnalyticsById(@ApiParam(value = "ID du sondage pour lequel on souhaite avoir des statistiques", required = true) @PathVariable("surveyID") Long surveyID);

}
