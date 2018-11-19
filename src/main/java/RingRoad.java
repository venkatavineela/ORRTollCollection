import java.util.ArrayList;
import java.util.List;

public class RingRoad {
    private List<TollGate> tollGates = new ArrayList<>();

    public RingRoad() {
        addTollGates();
    }

    private void addTollGates() {
        tollGates.add(new TollGate(1,10,15));
        tollGates.add(new TollGate(2,25,45));
        tollGates.add(new TollGate(3,20,35));
        tollGates.add(new TollGate(4,15,30));
    }

    List<TollGate> getTollGates() {
        return tollGates;
    }

    TollGate getTollGate(int number) {
        for (int i = 0;i < tollGates.size();i++) {
            if(tollGates.get(i).number == number) {
                return tollGates.get(i);
            }
        }
        return null;
    }
}
