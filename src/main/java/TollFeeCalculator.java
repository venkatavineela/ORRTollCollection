import java.util.List;

public class TollFeeCalculator {
    int getCalculatedFee(List<TollGate> gatesList,int typeOfVehicle) {
        int fee = 0;

            for (TollGate aGatesList : gatesList) {
                if (typeOfVehicle == 2) {
                    fee += aGatesList.getTwoWheelerFee();
                } else if (typeOfVehicle == 4) {
                    fee += aGatesList.getFourWheelerFee();
                }
            }
        return fee;
    }
}
