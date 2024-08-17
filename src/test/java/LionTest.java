import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Lion lion;
    @Spy
    Feline feline;

    @Test
    public void LionGetKittensTest() throws Exception {
        lion = new Lion("Самец", feline);
        assertEquals(1, lion.getKittens());
        verify(feline).getKittens();
    }

    @Test
    public void LionGetFoodText() throws Exception {
        lion = new Lion("Самец", feline);
        List<String> expectedResult = Arrays.asList("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedResult);
        assertEquals(expectedResult, lion.getFood());
        verify(feline, times(2)).eatMeat();

    }
}
