import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class LionDoesHaveManeParamTest {
    private String lionSex;
    private boolean expectedResult;
    private boolean shouldThrowException;

    public LionDoesHaveManeParamTest(String lionSex, boolean expectedResult, boolean shouldThrowException) {
        this.expectedResult = expectedResult;
        this.lionSex = lionSex;
        this.shouldThrowException = shouldThrowException;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Самец", true, false},
                {"Самка", false, false},
                {" ", false, true},
        };
    }

    @Test
    public void doesHaveManeParamTest() throws Exception {
        Feline feline = mock(Feline.class);
        try {
            Lion lion = new Lion(lionSex, feline);
            if (shouldThrowException) {
                fail("Используйте допустимые значения пола животного - самец или самка");
            } else {
                boolean actualResult = lion.doesHaveMane();
                assertEquals(expectedResult, actualResult);
            }
        } catch (Exception exception) {
            if (!shouldThrowException) {
                fail(exception.getMessage());
            }
        }

    }
}

