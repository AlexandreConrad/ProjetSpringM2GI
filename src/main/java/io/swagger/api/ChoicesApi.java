/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.16).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.annotations.*;
import io.swagger.model.Choice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-31T12:55:18.203Z")

@Api(value = "choices", description = "the choices API")
@RequestMapping(value = "/Alex57x/Projet/1.0.0")
public interface ChoicesApi {

    @ApiOperation(value = "Liste des choix possibles", nickname = "getChoiceById", notes = "Retourne la liste de tous les choix d'un sondage", response = Choice.class, responseContainer = "List", tags = {"choices",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "opération réussie", response = Choice.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Ressource introuvable."),
            @ApiResponse(code = 500, message = "Echec de connexion à la base de données.")})
    @RequestMapping(value = "/choices/{surveyID}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<Choice>> getChoiceById(@ApiParam(value = "ID du sondage pour lequel on souhaite avoir les choix", required = true) @PathVariable("surveyID") Long surveyID);


    @ApiOperation(value = "Supprime un choix", nickname = "getDeleteById", notes = "Supprime définitivement un choix", response = Choice.class, tags = {"choices",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "opération réussie", response = Choice.class),
            @ApiResponse(code = 404, message = "Ressource introuvable"),
            @ApiResponse(code = 500, message = "Echec de connexion à la base de données.")})
    @RequestMapping(value = "/choices/{choiceID}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Choice> getDeleteById(@ApiParam(value = "ID du choix", required = true) @PathVariable("choiceID") Long choiceID);


    @ApiOperation(value = "Ajoute une date pour un sondage", nickname = "postChoiceById", notes = "Ajoute un choix (choice) pour un sondage", response = Choice.class, tags = {"choices",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "opération réussie", response = Choice.class),
            @ApiResponse(code = 400, message = "Manque des informations dans le corps."),
            @ApiResponse(code = 409, message = "Certaines informations ne respectent pas les conditions."),
            @ApiResponse(code = 500, message = "Echec de connexion à la base de données.")})
    @RequestMapping(value = "/choices/{surveyID}",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Choice> postChoiceById(@ApiParam(value = "ID du sondage pour lequel on souhaite ajouter un choix", required = true) @PathVariable("surveyID") Long surveyID, @ApiParam(value = "Ajout d'un choix.", required = true) @Valid @RequestBody Timestamp choice);

}
