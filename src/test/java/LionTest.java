import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private final String EXCEPTION_MESSAGE_TEXT = "Используйте допустимые значения пола животного - самец или самка";
    @Mock
    Feline feline;


    @Test
    public void lionGetKittensTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
        verify(feline).getKittens();
    }

    @Test
    public void lionGetFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expectedResult = Arrays.asList("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedResult);
        assertEquals(expectedResult, lion.getFood());
        verify(feline).getFood("Хищник");

    }
//Не разобрался как использовать assertThrows
    @Test
    public void lionConstructorExceptionTest() throws Exception {
        try {
            Lion lion = new Lion("undefined", feline);
            fail(EXCEPTION_MESSAGE_TEXT);
        } catch (Exception exception){
            assertEquals(EXCEPTION_MESSAGE_TEXT,exception.getMessage());
        }
    }
}
