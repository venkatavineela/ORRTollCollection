import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TollOperatorTest {
    RingRoad ringRoad = mock(RingRoad.class);
    TollFeeCalculator tollFeeCalculator = mock(TollFeeCalculator.class);
    TollOperator tollOperator = new TollOperator(ringRoad,tollFeeCalculator);

    @Test
    public void invalidInputMethodShouldReturnFalseForCorrectInputs() {
        assertFalse(tollOperator.isInvalidInput(2,4,1));

    }

    @Test
    public void invalidInputMethodShouldReturnTrueForIncorrectWheelerType() {
        assertTrue(tollOperator.isInvalidInput(3,3,1));
    }

    @Test
    public void invalidInputMethodShouldReturnTrueForInvalidEntryTollNumber() {
        assertTrue(tollOperator.isInvalidInput(2,6,1));
    }

    @Test
    public void invalidInputMethodShouldReturnTrueForInvalidExitTollNumber() {
        assertTrue(tollOperator.isInvalidInput(2,1,6));
    }

    @Test
    public void calculateFeeMethodShouldReturnTheFee() {
        when(ringRoad.getTollGates()).thenReturn(Collections.emptyList());
        when(tollFeeCalculator.getCalculatedFee(Collections.emptyList(),3)).thenReturn(2);
        assertEquals(2,tollOperator.calculateFee(3,3,4));
    }
}