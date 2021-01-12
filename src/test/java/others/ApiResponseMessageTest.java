package others;
import io.swagger.api.ApiResponseMessage;
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
        Assert.assertEquals(api.getType(),"Code1");
        Mockito.when(apiResponseMessage.getType()).thenReturn("Code");
        Assert.assertEquals(apiResponseMessage.getType(),"Code");

        /** Test du Message */
        api.setMessage("Message 1");
        Assert.assertEquals(api.getMessage(),"Message 1");
        Mockito.when(apiResponseMessage.getMessage()).thenReturn("Message");
        Assert.assertEquals(apiResponseMessage.getMessage(),"Message");
    }

    /**
     * Fonction principale
     */
    @Test
    public void ApiResponseMessageTypes() {

        /** Tests des types **/
        ApiResponseMessage errorMessage = new ApiResponseMessage(ApiResponseMessage.ERROR,"error");
        Assert.assertEquals(errorMessage.getMessage(),"error");

        ApiResponseMessage infoMessage = new ApiResponseMessage(ApiResponseMessage.INFO,"info");
        Assert.assertEquals(infoMessage.getMessage(),"info");

        ApiResponseMessage warningMessage = new ApiResponseMessage(ApiResponseMessage.WARNING,"warning");
        Assert.assertEquals(warningMessage.getMessage(),"warning");

        ApiResponseMessage okMessage = new ApiResponseMessage(ApiResponseMessage.OK,"ok");
        Assert.assertEquals(okMessage.getCode(),ApiResponseMessage.OK);

        ApiResponseMessage busyMessage = new ApiResponseMessage(ApiResponseMessage.TOO_BUSY,"too busy");
        Assert.assertEquals(busyMessage.getMessage(),"too busy");

        ApiResponseMessage unknowMessage = new ApiResponseMessage(42,"unknown");
        Assert.assertEquals(unknowMessage.getMessage(),"unknown");
    }

}
