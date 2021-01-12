package exceptions;
import io.swagger.api.NotFoundException;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;

/**
 * Test en rapport avec la classe "ApiException" et "NotFoundException"
 */
@SpringBootTest
public class ApiExceptionTest {

    @Test(expected = NotFoundException.class)
    public void ApiException() throws NotFoundException {
        throw new NotFoundException(1,"Test Junit");
    }
}
