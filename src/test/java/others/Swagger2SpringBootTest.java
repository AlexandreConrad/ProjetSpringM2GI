package others;
import io.swagger.Swagger2SpringBoot;
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
 * Test en rapport avec la classe "Swagger2SpringBootTest"
 */
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class Swagger2SpringBootTest {

    @Before
    public void init (){
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Swagger2SpringBoot swagger2SpringBoot;

    /**
     * Test de la classe
     */
    @Test
    public void Swagger2SpringBoot() {
        String[] args = new String[1];
        swagger2SpringBoot.run(args);
        Mockito.verify(swagger2SpringBoot, Mockito.times(1)).run(args);
    }

    @Test
    public void Swagger() {
        String[] args = new String[0];
        Swagger2SpringBoot s = new Swagger2SpringBoot();
        s.run(args);
    }

    @Test(expected = Exception.class)
    public void exceptions() {
        Swagger2SpringBoot s = new Swagger2SpringBoot();
        String[] argsBis = {"exitcode"};
        s.run(argsBis);
    }
}
