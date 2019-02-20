package kata.stringcalc;

import static kata.stringcalc.Calculator.add;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jacob.briscoe
 */
public class CalculatorTest {

    @Test
    public void shouldReturnZeroWithEmptyString() {
        assertEquals(0, add(""));
    }

    @Test
    public void shouldReturnNumberWithSingleNumber(){
        assertEquals(1, add("1"));
    }
    
    @Test
    public void shouldReturnSumOfTwoNumbersCommaDelimited(){
        assertEquals(2, add("1,1"));
    }
    
    @Test
    public void shouldReturnSumOfTwoNumbersNewLineDelimited(){
        assertEquals(2, add("1\n1"));
    }
    
    @Test
    public void shouldReturnSumOfThreeNumbersWithCommaAndNewLineDelimiters(){
        assertEquals(3, add("1,1\n1"));
    }
    
    @Test
    public void shouldThrowExceptionWithNegativeNumber(){
        final Throwable exception = assertThrows(IllegalArgumentException.class, () -> add("-1"));
        assertTrue(exception.getMessage().contains("-1"));
    }
    
    @Test
    public void shouldIgnoreNumbersGreaterThan1000(){
        assertEquals(3, add("1,1001,2"));
    }
}
