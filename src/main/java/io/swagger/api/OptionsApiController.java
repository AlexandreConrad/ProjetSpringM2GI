package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.service.OptionsService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-31T12:55:18.203Z")

@Controller
public class OptionsApiController implements OptionsApi{

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
            Option option = OptionsService.postOption(optionName);
            return new ResponseEntity<Option>(option,HttpStatus.OK);
        }
        //TODO Retourne un code d'erreur pour les différents cas possibles
        return new ResponseEntity<Option>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Option>> getOptions() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            List<Option> options = OptionsService.getOptions();
            return new ResponseEntity<List<Option> >(options,HttpStatus.OK);
        }
        //TODO Retourne un code d'erreur pour les différents cas possibles
        return new ResponseEntity<List<Option>>(HttpStatus.NOT_IMPLEMENTED);
    }
}
