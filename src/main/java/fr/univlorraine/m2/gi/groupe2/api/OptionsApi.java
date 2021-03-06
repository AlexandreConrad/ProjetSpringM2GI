/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.16).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package fr.univlorraine.m2.gi.groupe2.api;

import io.swagger.annotations.*;
import fr.univlorraine.m2.gi.groupe2.model.Option;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-31T12:55:18.203Z")

@Api(value = "vote", description = "choix des options pour la participation")
@RequestMapping(value = "/Alex57x/Projet/1.0.0")
public interface OptionsApi {

    @ApiOperation(value = "Ajout d'une option", nickname = "postOption", notes = "Option possible", response = Option.class, tags = {"votes",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Opération réussie", response = Option.class),
            @ApiResponse(code = 409, message = "Certaines informations ne respectent pas les conditions."),
            @ApiResponse(code = 500, message = "Echec de connexion à la base de données.")})
    @RequestMapping(value = "/option/",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Option> postOption(@ApiParam(value = "Nom de l'option", required = true) @Valid @RequestBody String option);

    @ApiOperation(value = "Retourne toutes les options", nickname = "getOption", notes = "Toutes les options", response = Option.class, tags = {"votes",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Opération réussie", response = Option.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Ressource introuvable"),
            @ApiResponse(code = 500, message = "Echec de connexion à la base de données.")})
    @RequestMapping(value = "/option/",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<Option>> getOptions();
}
