import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class LionDoesHaveManeParamTest {
    private String lionSex;
    private boolean expectedResult;


    public LionDoesHaveManeParamTest(String lionSex, boolean expectedResult) {
        this.expectedResult = expectedResult;
        this.lionSex = lionSex;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},

        };
    }

    @Test
    public void doesHaveManeParamTest() throws Exception {
        Feline feline = mock(Feline.class);
            Lion lion = new Lion(lionSex, feline);
                boolean actualResult = lion.doesHaveMane();
                assertEquals(expectedResult, actualResult);

        }

    }


