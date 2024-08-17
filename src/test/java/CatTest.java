import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Cat cat;
    Feline feline;

    @Test
    public void CatGetSoundTest() {
        cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void CatGetFoodTest() throws Exception {
        Feline feline = Mockito.spy(new Feline());
        cat = new Cat(feline);
        List<String> expectedResult = Arrays.asList("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedResult);
        assertEquals(expectedResult, cat.getFood());
        verify(feline, times(2)).eatMeat();
    }
}
