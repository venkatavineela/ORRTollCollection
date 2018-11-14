import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class TollOperator {
    RingRoad ringRoad = new RingRoad();
    TollFeeCalculator tollFeeCalculator = new TollFeeCalculator();
    Scanner scanner = new Scanner(System.in);

    void getInput() {
        try {
            System.out.println("Enter Vehicle Type:");
            typeOfVehicle = parseInt(scanner.nextLine());

            System.out.println("Enter Entry Toll Number");
            entryTollNumber = parseInt(scanner.nextLine());

            System.out.println("Enter Exit Toll Number");
            exitTollNumber = parseInt(scanner.nextLine());
        }catch (Exception e) {
            System.out.println("Give a valid input");
        }

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
