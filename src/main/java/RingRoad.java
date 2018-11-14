import java.util.ArrayList;
import java.util.List;

public class RingRoad {
    private List<TollGate> tollGates = new ArrayList<>();

    public RingRoad() {
        addTollGates();
    }

    private void addTollGates() {
        tollGates.add(1,new TollGate(10,15));
        tollGates.add(2,new TollGate(25,45));
        tollGates.add(3,new TollGate(20,35));
        tollGates.add(4,new TollGate(15,30));
    }

    List<TollGate> getTollGates() {
        return tollGates;
    }
}
