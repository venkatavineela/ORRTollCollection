import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TollFeeTest {

    TollGate tollGate1 = new TollGate(20,30);
    TollGate tollGate2 = new TollGate(15,35);
    List<TollGate> tollGates = Arrays.asList(tollGate1,tollGate2);
    TollFee tollFee = new TollFee();

    @Test
    public void getCalculatedFeeMethodShouldReturnTheCalculatedFeeForTwoWheeler() {
        assertEquals(35,tollFee.getCalculatedFee(tollGates,2));
    }

    @Test
    public void getCalculatedFeeMethodShouldReturnTheCalculatedFeeForFourWheeler() {
        assertEquals(65,tollFee.getCalculatedFee(tollGates,4));
    }

    @Test
    public void getCalculatedFeeMethodShouldReturnTheCalculatedFeeAsZeroForInvalidVehicleType() {
        assertEquals(0,tollFee.getCalculatedFee(tollGates,3));
    }
}