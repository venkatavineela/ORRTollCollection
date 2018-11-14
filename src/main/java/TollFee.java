import java.util.List;

public class TollFee {
    int getCalculatedFee(List<TollGate> gatesList,int typeOfVehicle) {
        int fee = 0;
        if(typeOfVehicle == 2) {
            for (TollGate aGatesList : gatesList) {
                fee += aGatesList.getTwoWheelerFee();
            }
        }
        return fee;
    }
}
