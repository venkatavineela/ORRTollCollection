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

    boolean invalidInput(int typeOfVehicle, int entryTollNumber, int exitTollNumber) {
        if(!(typeOfVehicle == 2 || typeOfVehicle == 4)) {
            System.out.println("Give the correct wheeler type");
            return true;
        }
        if(!(entryTollNumber >= 1 && entryTollNumber <= ringRoad.getTollGates().size())) {
            System.out.println("Invalid Entry Toll Number");
            return true;
        }
        if(!(exitTollNumber >= 0 && exitTollNumber <= ringRoad.getTollGates().size())) {
            System.out.println("Invalid Exit Toll Number");
            return true;
        }
        return false;
    }

    void calculateFee(int typeOfVehicle, int entryTollNumber, int exitTollNumber) {
        List<TollGate> tollGates = new ArrayList<>();
        int i = entryTollNumber;
        while (i <= ringRoad.getTollGates().size()) {
            if (i == ringRoad.getTollGates().size()) {
                i = 0;
            }
            tollGates.add(ringRoad.getTollGates().get(i));
            i++;
            if(i == exitTollNumber) break;
        }
        int tollFee = tollFeeCalculator.getCalculatedFee(tollGates,typeOfVehicle);
        displayCalculatedFee(entryTollNumber, exitTollNumber, tollFee);
    }

    private void displayCalculatedFee(int entryTollNumber, int exitTollNumber, int tollFee) {
        System.out.println("Collect Toll fee Rs." + tollFee +  "for travel from TollGate#" + entryTollNumber + "to TollGate#" + exitTollNumber);
    }

}
