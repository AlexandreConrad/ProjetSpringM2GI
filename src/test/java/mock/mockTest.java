import io.swagger.model.Option;
import io.swagger.model.Survey;
import io.swagger.resolvers.AvailableIOptionResolver;
import io.swagger.resolvers.MaybeIOptionResolver;
import io.swagger.service.OptionsService;
import io.swagger.service.SurveyService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.MissingFormatArgumentException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class mockkkkTest {

 @Before
 public void init (){
  MockitoAnnotations.initMocks(this);
 }

 @Mock
 Survey survey;

 @Mock
 Option option;

 @Mock
 MaybeIOptionResolver maybeIOptionResolver ;

 @InjectMocks
 private SurveyService surveyService;

 @Test
 public void workInProgress (){
  MaybeIOptionResolver maybe = new MaybeIOptionResolver();
  Option opt = new Option("Disponible");
  Assert.assertTrue(maybe.shouldMatch(opt));
 }

 @Test
 public void MaybeIOptionResolver (){
  Mockito.when(option.getName()).thenReturn("Disponible");
  Mockito.when(maybeIOptionResolver.shouldMatch(option)).thenReturn(true);
  Assert.assertTrue(maybeIOptionResolver.shouldMatch(option));

  Mockito.when(option.getName()).thenReturn("Peut-être");
  Mockito.when(maybeIOptionResolver.shouldMatch(option)).thenReturn(true);
  Assert.assertTrue(maybeIOptionResolver.shouldMatch(option));

  Mockito.when(option.getName()).thenReturn("Indisponible");
  Mockito.when(maybeIOptionResolver.shouldMatch(option)).thenReturn(false);
  Assert.assertFalse(maybeIOptionResolver.shouldMatch(option));

  Mockito.when(option.getName()).thenReturn("Alexandre");
  Mockito.when(maybeIOptionResolver.shouldMatch(option)).thenReturn(false);
  Assert.assertFalse(maybeIOptionResolver.shouldMatch(option));
 }

}
