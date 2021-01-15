package others;
import fr.univlorraine.m2.gi.groupe2.api.ApiResponseMessage;
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

/**
 * Test en rapport avec la classe "ApiResponseMessage"
 */
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ApiResponseMessageTest {

    @Before
    public void init (){
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    ApiResponseMessage apiResponseMessage;

    /**
     * Test du controller et des Getters/Setters
     */
    @Test
    public void ApiResponseMessage() {

        /** Variables **/
        ApiResponseMessage api = new ApiResponseMessage();
        int code = 1;
        int codeBis = 2;

        /** Test du code */
        api.setCode(codeBis);
        Assert.assertEquals(api.getCode(),codeBis);
        Mockito.when(apiResponseMessage.getCode()).thenReturn(code);
        Assert.assertEquals(apiResponseMessage.getCode(),code);

        /** Test du Type */
        api.setType("Code1");
        Assert.assertEquals("Code1", api.getType());
        Mockito.when(apiResponseMessage.getType()).thenReturn("Code");
        Assert.assertEquals("Code", apiResponseMessage.getType());

        /** Test du Message */
        api.setMessage("Message 1");
        Assert.assertEquals("Message 1", api.getMessage());
        Mockito.when(apiResponseMessage.getMessage()).thenReturn("Message");
        Assert.assertEquals("Message", apiResponseMessage.getMessage());
    }

    /**
     * Fonction principale
     */
    @Test
    public void ApiResponseMessageTypes() {

        /** Tests des types **/
        ApiResponseMessage errorMessage = new ApiResponseMessage(ApiResponseMessage.ERROR,"error");
        Assert.assertEquals("error", errorMessage.getMessage());

        ApiResponseMessage infoMessage = new ApiResponseMessage(ApiResponseMessage.INFO,"info");
        Assert.assertEquals("info", infoMessage.getMessage());

        ApiResponseMessage warningMessage = new ApiResponseMessage(ApiResponseMessage.WARNING,"warning");
        Assert.assertEquals("warning", warningMessage.getMessage());

        ApiResponseMessage okMessage = new ApiResponseMessage(ApiResponseMessage.OK,"ok");
        Assert.assertEquals(ApiResponseMessage.OK, okMessage.getCode());

        ApiResponseMessage busyMessage = new ApiResponseMessage(ApiResponseMessage.TOO_BUSY,"too busy");
        Assert.assertEquals("too busy", busyMessage.getMessage());

        ApiResponseMessage unknowMessage = new ApiResponseMessage(42,"unknown");
        Assert.assertEquals("unknown", unknowMessage.getMessage());
    }

}
