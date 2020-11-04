import io.swagger.model.Survey;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ModelSurveyTest {
    @Mock
    private Survey surveyMock;

    @Captor
    private ArgumentCaptor<String> stringCaptor;

    @Test
    public void setName(){
        System.out.println("Test sur le getter et setter du nom pour le model survey");
        String name = "Alexandre";
        surveyMock.setName(name);
        doReturn(name).when(surveyMock).getName();
        //assertSame( "Object must be the same", name, surveyMock.getName() );
    }
}
