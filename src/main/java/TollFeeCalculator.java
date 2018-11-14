import java.util.List;

public class TollFeeCalculator {
    int getCalculatedFee(List<TollGate> gatesList,int typeOfVehicle) {
        int fee = 0;
        if(typeOfVehicle == 2) {
            for (TollGate aGatesList : gatesList) {
                fee += aGatesList.getTwoWheelerFee();
            }
        }
        else if(typeOfVehicle == 4) {
            for (TollGate aGatesList : gatesList) {
                fee += aGatesList.getFourWheelerFee();
            }
        }
        return fee;
    }
}
