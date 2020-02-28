import com.dev.WrongInpuStringException;
import com.dev.service.NoResultException;
import com.dev.service.SquareService;

import org.junit.Assert;
import org.junit.Test;

public class SquareServiceTest {
    private static final String INPUTCORRECTMATRIX = "QLGNAEKIRLRNGEAE";
    private static final String INPUTNOTCORRECTMATRIX = "SINPRGAIB";
    private static final String CORRECTWORD = "KING";
    private static final String NOTCORRECTWORD = "SPRING”";

    @Test(expected = WrongInpuStringException.class)
    public void testConstructorWithAssimetricParametr() {
        SquareService squareService = new SquareService();
        squareService.getResult("INPUTSTRING", CORRECTWORD);
    }

    @Test(expected = WrongInpuStringException.class)
    public void testConstructorWithNullString() {
        SquareService squareService = new SquareService();
        squareService.getResult("", CORRECTWORD);
    }

    @Test(expected = WrongInpuStringException.class)
    public void testConstructorWithNull() {
        SquareService squareService = new SquareService();
        squareService.getResult(null, CORRECTWORD);
    }

    @Test(expected = WrongInpuStringException.class)
    public void testNullAsFindingWord() {
        SquareService squareService = new SquareService();
        squareService.getResult(INPUTCORRECTMATRIX,null);
    }

    @Test(expected = WrongInpuStringException.class)
    public void testEmptyStringAsFindingWord() {
        SquareService squareService = new SquareService();
        squareService.getResult(INPUTCORRECTMATRIX,"");
    }

    @Test
    public void testCorrectResult() {
        SquareService squareService = new SquareService();
        Assert.assertEquals("The test was failed! The expected result " +
                        "is [1,2]->[1,3]->[0,3]->[0,2]" +
                        ", but was " + squareService.getResult(INPUTCORRECTMATRIX, CORRECTWORD),
                "[1,2]->[1,3]->[0,3]->[0,2]", squareService.getResult(INPUTCORRECTMATRIX, CORRECTWORD));
    }

    @Test(expected = NoResultException.class)
    public void testNoResult() {
        SquareService squareService = new SquareService();
        squareService.getResult(INPUTNOTCORRECTMATRIX, NOTCORRECTWORD);
    }


}
