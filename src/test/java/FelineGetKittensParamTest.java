import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineGetKittensParamTest {
    private int kittensCount;

    public FelineGetKittensParamTest(int kittensCount) {
        this.kittensCount = kittensCount;
    }

    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[][]{
                {Integer.MIN_VALUE},
                {Integer.MAX_VALUE},
                {0},
        };

    }
    @Test
    public void felineGetKittensParamTest() {
        Feline feline = new Feline();
        assertEquals(kittensCount,feline.getKittens(kittensCount));
    }
}