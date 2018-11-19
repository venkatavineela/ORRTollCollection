import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TollFeeCalculatorTest {

    TollGate tollGate1 = new TollGate(1,20,30);
    TollGate tollGate2 = new TollGate(2,15,35);
    List<TollGate> tollGates = Arrays.asList(tollGate1,tollGate2);
    TollFeeCalculator tollFeeCalculator = new TollFeeCalculator();

    @Test
    public void getCalculatedFeeMethodShouldReturnTheCalculatedFeeForTwoWheeler() {
        assertEquals(35, tollFeeCalculator.getCalculatedFee(tollGates,2));
    }

    @Test
    public void getCalculatedFeeMethodShouldReturnTheCalculatedFeeForFourWheeler() {
        assertEquals(65, tollFeeCalculator.getCalculatedFee(tollGates,4));
    }

    @Test
    public void getCalculatedFeeMethodShouldReturnTheCalculatedFeeAsZeroForInvalidVehicleType() {
        assertEquals(0, tollFeeCalculator.getCalculatedFee(tollGates,3));
    }
}