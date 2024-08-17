import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    private Feline feline;

    @Test
    public void FelineGatMeatTest() throws Exception {
        List<String> expectedResult = Arrays.asList("Животные", "Птицы", "Рыба");
        doReturn(expectedResult).when(feline).getFood("Хищник");
        List<String> actualResult = feline.eatMeat();
        assertEquals(expectedResult, actualResult);
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void FelineGetFamilyTest() {
        assertEquals("Кошачьи", feline.getFamily());
        verify(feline).getFamily();
    }

    @Test
    public void FelineGetKittensWithOutParametersTest() {
        feline.getKittens();
        assertEquals(1, feline.getKittens());
        verify(feline, times(2)).getKittens();
    }

    @Test
    public void FelineGetKittensWithParametersTest() {
        assertEquals(5, feline.getKittens(5));
        verify(feline).getKittens(5);
    }
}
