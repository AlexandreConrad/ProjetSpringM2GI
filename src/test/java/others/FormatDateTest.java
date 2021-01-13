package others;
import io.swagger.MyDate;
import io.swagger.RFC3339DateFormat;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.FieldPosition;
import java.util.Date;

/**
 * Test en rapport avec la classe "MyDateTest"
 */
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class FormatDateTest {

    /**
     * Test de la classe
     */
    @Test
    public void formatDate() {

        /** MyDate classe **/
        StringBuffer stringBuffer = new StringBuffer();
        FieldPosition fieldPosition = new FieldPosition(1);
        Date date = new Date();
        MyDate myDate = new MyDate();
        myDate.format(date,stringBuffer,fieldPosition);

        /** RFC3339DateFormat  **/
        RFC3339DateFormat rfc3339DateFormat = new RFC3339DateFormat();
        rfc3339DateFormat.format(date,stringBuffer,fieldPosition);
    }
}