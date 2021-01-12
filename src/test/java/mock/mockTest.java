package mock;
import io.swagger.model.Option;
import io.swagger.resolvers.MaybeIOptionResolver;
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

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class mockTest {

 @Before
 public void init (){
  MockitoAnnotations.initMocks(this);
 }

 @Mock
 Option option;

 @Mock
 MaybeIOptionResolver maybeIOptionResolver ;

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
