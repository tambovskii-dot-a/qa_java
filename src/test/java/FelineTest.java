import com.example.Feline;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    Feline feline;



    @Test
    public void FelineEatMeatTest() throws Exception {
        feline = new Feline();
        List<String> expectedResult = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualResult = feline.eatMeat();
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void FelineGetFamilyTest() {
        feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void FelineDefaultGetKittensTest() {
        feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

}
