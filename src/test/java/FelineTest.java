import com.example.Feline;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    Feline feline;



    @Test
    public void felineEatMeatTest() throws Exception {
        feline = new Feline();
        List<String> expectedResult = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualResult = feline.eatMeat();
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void felineGetFamilyTest() {
        feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void felineDefaultGetKittensTest() {
        feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

}
