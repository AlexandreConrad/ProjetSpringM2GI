package exceptions;
import fr.univlorraine.m2.gi.groupe2.api.NotFoundException;
import fr.univlorraine.m2.gi.groupe2.exceptions.DatabaseException;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;

/**
 * Test en rapport avec la classe "ApiException" , "NotFoundException" et "DatabaseException".
 */
@SpringBootTest
public class ApiExceptionTest {

    @Test(expected = NotFoundException.class)
    public void ApiException() throws NotFoundException {
        throw new NotFoundException(1,"Test Junit");
    }

    @Test(expected = DatabaseException.class)
    public void DatabaseException() throws DatabaseException {
        throw new DatabaseException("Test Junit");
    }
}
