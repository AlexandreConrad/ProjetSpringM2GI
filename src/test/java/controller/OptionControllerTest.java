package controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.univlorraine.m2.gi.groupe2.api.OptionsApiController;
import fr.univlorraine.m2.gi.groupe2.model.Option;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Test en rapport avec la classe "OptionsController"
 */
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class OptionControllerTest {

    @Before
    public void init (){
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    ObjectMapper objectMapper;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    HttpServletRequest httpServletRequestAccept;

    @Mock
    OptionsApiController optionsApiController;

    /**
     * Fonction getOptions
     * Retourne toutes les options
     * Pour le status "NotImplemented" ou "OK"
     */
    @Test
    public void getOptions() {

        /** Test not implemented **/
        OptionsApiController optsNull = new OptionsApiController(objectMapper,httpServletRequest);
        ResponseEntity<List<Option>> listNotFound = new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        ResponseEntity<List<Option>> options =  optsNull.getOptions();
        Assert.assertEquals(options,listNotFound);

        /** Test OK **/
        Mockito.when(httpServletRequestAccept.getHeader("Accept")).thenReturn("application/json");
        OptionsApiController optsAccept = new OptionsApiController(objectMapper,httpServletRequestAccept);
        ResponseEntity<List<Option>> listOK= new ResponseEntity<>(null, HttpStatus.OK);
        ResponseEntity<List<Option>> optionsOk =  optsAccept.getOptions();
        Assert.assertEquals(optionsOk.getStatusCodeValue(),listOK.getStatusCodeValue());
    }

    /**
     * Fonction postOption
     * Fait persister un sondage
     * Pour le status "NotImplemented" ou "OK"
     */
    @Test
    public void postOption() {

        /** Variables **/
        String optionName = "postOption";

        /** Test not implemented **/
        OptionsApiController optsNull = new OptionsApiController(objectMapper,httpServletRequest);
        ResponseEntity<Option> optionNotImplemented = new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        ResponseEntity<Option> optionTest =  optsNull.postOption(optionName);
        Assert.assertEquals(optionTest,optionNotImplemented);

        /** Test OK **/
        Mockito.when(httpServletRequestAccept.getHeader("Accept")).thenReturn("application/json");
        OptionsApiController optsAccept = new OptionsApiController(objectMapper,httpServletRequestAccept);
        ResponseEntity<Option> optionNotFound = new ResponseEntity<>(null, HttpStatus.OK);
        ResponseEntity<Option> optionPostOk =  optsAccept.postOption(optionName);
        Assert.assertEquals(optionPostOk.getStatusCodeValue(),optionNotFound.getStatusCodeValue());
    }

    /**
     * Fonction getOptions
     * Retourne toutes les options
     */
    @Test
    public void optionController() {

        /** Logger **/

        /** Variables **/
        Option option1 = new Option("Option1");
        Option option2 = new Option("Option1");
        List<Option> options = new ArrayList<>();
        options.add(option1);
        options.add(option2);
        ResponseEntity<List<Option>> list = new ResponseEntity<>(options, HttpStatus.OK);

        /** Tests **/
        Mockito.when(optionsApiController.getOptions()).thenReturn(list);
        Assert.assertEquals(optionsApiController.getOptions(),list);
        Assert.assertEquals(optionsApiController.getOptions(),list);
        Mockito.verify(optionsApiController, Mockito.times(2)).getOptions();
    }

}
