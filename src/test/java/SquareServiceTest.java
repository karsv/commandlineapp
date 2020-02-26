import com.dev.WrongInpuStringException;
import com.dev.service.SquareService;

import org.junit.Assert;
import org.junit.Test;

public class SquareServiceTest {
    private static final String INPUTSTRING = "QLGNAEKIRLRNGEAE";

    @Test(expected = WrongInpuStringException.class)
    public void testConstructorWithAssimetricParametr() {
        SquareService squareService = new SquareService("QLGNAEKIRLRNGEA");
    }

    @Test(expected = WrongInpuStringException.class)
    public void testConstructorWithNullString() {
        SquareService squareService = new SquareService("");
    }

    @Test(expected = WrongInpuStringException.class)
    public void testConstructorWithNull() {
        SquareService squareService = new SquareService(null);
    }

    @Test
    public void testCorrectResult() {
        SquareService squareService = new SquareService(INPUTSTRING);
        Assert.assertEquals("The test was failed! The expected result " +
                        "is [1,2]->[1,3]->[0,3]->[0,2]" +
                        ", but was " + squareService.getResult("KING"),
                "[1,2]->[1,3]->[0,3]->[0,2]", squareService.getResult("KING"));
    }

    @Test
    public void testWhenLeterIsntInMatrix() {
        SquareService squareService = new SquareService(INPUTSTRING);
        Assert.assertEquals("The test was failed! The expected result " +
                        "is [1,2]->[X]->[0,3]->[0,2]" +
                        ", but was " + squareService.getResult("KZNG"),
                "[1,2]->[X]->[0,3]->[0,2]", squareService.getResult("KZNG"));
    }
}
