package fr.univlorraine.m2.gi.groupe2.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import fr.univlorraine.m2.gi.groupe2.exceptions.BadRequestException;
import fr.univlorraine.m2.gi.groupe2.exceptions.DatabaseException;
import fr.univlorraine.m2.gi.groupe2.exceptions.NotFoundException;
import fr.univlorraine.m2.gi.groupe2.model.Option;
import fr.univlorraine.m2.gi.groupe2.service.OptionsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-31T12:55:18.203Z")

@Controller
public class OptionsApiController implements OptionsApi {

    private static final Logger log = LoggerFactory.getLogger(OptionsApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public OptionsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Option> postOption(@ApiParam(value = "Nom de l'option", required = true) @Valid @RequestBody String optionName) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try{
                Option option = OptionsService.postOption(optionName);
                return new ResponseEntity<Option>(option, HttpStatus.OK);
            }catch (DatabaseException d){
                return new ResponseEntity<Option>(HttpStatus.INTERNAL_SERVER_ERROR);
            }catch (BadRequestException d){
                return new ResponseEntity<Option>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<Option>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Option>> getOptions() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try{
                List<Option> options = OptionsService.getOptions();
                return new ResponseEntity<List<Option>>(options, HttpStatus.OK);
            } catch (DatabaseException e) {
                return new ResponseEntity<List<Option>>(HttpStatus.INTERNAL_SERVER_ERROR);
            } catch (NotFoundException e) {
                return new ResponseEntity<List<Option>>(HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<List<Option>>(HttpStatus.NOT_IMPLEMENTED);
    }
}
