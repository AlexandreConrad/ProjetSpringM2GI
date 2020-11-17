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
        //Mockito.when(surveyMock.getName()).thenReturn("Mon premier sondage");
        //doReturn("Mon premier sondage").when(surveyMock).getName();
        //when(surveyMock.getName()).thenReturn("Mon premier sondage");
        //when(surveyMock.getId_survey()).thenReturn(1L);
        //when(surveyMock.getName()).thenReturn("Mon premier sondage");
        //when(surveyMock.getDescription()).thenReturn("Mon tout premier sondage !");
        //when(surveyMock.getIsAvailable()).thenReturn(true);
        //when(surveyMock.getEndDate()).thenReturn(new Date(1604666145));*/
    }
}
