import java.util.ArrayList;
import java.util.List;

public class RingRoad {
    private List<TollGate> tollGates = new ArrayList<>();

    public RingRoad() {
        addTollGates();
    }

    private void addTollGates() {
        tollGates.add(new TollGate(10,15));
        tollGates.add(new TollGate(25,45));
        tollGates.add(new TollGate(20,35));
        tollGates.add(new TollGate(15,30));
    }

    List<TollGate> getTollGates() {
        return tollGates;
    }
}
