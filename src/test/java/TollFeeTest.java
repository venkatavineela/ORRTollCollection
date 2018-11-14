import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TollFeeTest {
    @Test
    public void getCalculatedFeeMethodShouldReturnTheCalculatedFeeForTwoWheeler() {
        TollGate tollGate1 = new TollGate(20,30);
        TollGate tollGate2 = new TollGate(15,35);
        List<TollGate> tollGates = Arrays.asList(tollGate1,tollGate2);
        TollFee tollFee = new TollFee();


        assertEquals(35,tollFee.getCalculatedFee(tollGates,2));
    }
}