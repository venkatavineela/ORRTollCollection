import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class TollOperator {
    RingRoad ringRoad = new RingRoad();
    TollFeeCalculator tollFeeCalculator = new TollFeeCalculator();
    Scanner scanner = new Scanner(System.in);

    void getInput() {
        System.out.println("Enter Vehicle Type:");
        int typeOfVehicle = parseInt(scanner.nextLine());
        System.out.println("Enter Entry Toll Number");
        int entryTollNumber = parseInt(scanner.nextLine());
        System.out.println("Enter Exit Toll Number");
        int exitTollNumber = parseInt(scanner.nextLine());
        calculateFee(typeOfVehicle, entryTollNumber, exitTollNumber);
    }

    private void calculateFee(int typeOfVehicle, int entryTollNumber, int exitTollNumber) {
        List<TollGate> tollGates = new ArrayList<>();
        int i = entryTollNumber;
        while(i <= exitTollNumber) {
            if(i == ringRoad.getTollGates().size()) {
                i = 1;
            }
            tollGates.add(ringRoad.getTollGates().get(i));
            i++;
        }
        tollFeeCalculator.getCalculatedFee(tollGates,typeOfVehicle);
    }
}
