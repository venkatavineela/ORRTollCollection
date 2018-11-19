import java.util.ArrayList;
import java.util.List;

public class TollOperator {
    private RingRoad ringRoad;
    private TollFeeCalculator tollFeeCalculator;


    public TollOperator(RingRoad ringRoad,TollFeeCalculator tollFeeCalculator) {
       this.ringRoad = ringRoad;
       this.tollFeeCalculator = tollFeeCalculator;
    }

    boolean isInvalidInput(int typeOfVehicle, int entryTollNumber, int exitTollNumber) {
        if(!(typeOfVehicle == 2 || typeOfVehicle == 4)) {
            return true;
        }
        if(!(entryTollNumber >= 1 && entryTollNumber <= ringRoad.getTollGates().size())) {
            return true;
        }
        if(!(exitTollNumber >= 0 && exitTollNumber <= ringRoad.getTollGates().size())) {
            return true;
        }
        return false;
    }

    int calculateFee(int typeOfVehicle, int entryTollNumber, int exitTollNumber) {
        List<TollGate> tollGates = new ArrayList<>();
        int i = entryTollNumber;
        while (i <= ringRoad.getTollGates().size()) {
            if (i == ringRoad.getTollGates().size()) {
                i = 0;
            }
            i++;
            tollGates.add(ringRoad.getTollGate(i));
            if(i == exitTollNumber) break;

        }
        return tollFeeCalculator.getCalculatedFee(tollGates,typeOfVehicle);
    }

}
