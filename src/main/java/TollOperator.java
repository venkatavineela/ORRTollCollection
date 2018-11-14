import java.util.ArrayList;
import java.util.List;
import static java.lang.Integer.parseInt;

public class TollOperator {
    private  InputOutput io;
    RingRoad ringRoad = new RingRoad();
    TollFeeCalculator tollFeeCalculator = new TollFeeCalculator();
    private int typeOfVehicle;
    private int entryTollNumber;
    private int exitTollNumber;

    public TollOperator(InputOutput io) {
        this.io = io;
    }

    void operate() {
        do {
            getInput();
        }while(invalidInput(typeOfVehicle, entryTollNumber, exitTollNumber));
        calculateFee(typeOfVehicle, entryTollNumber, exitTollNumber);
    }

    void getInput() {
        try {
            io.display("Enter Vehicle Type:");
            typeOfVehicle = parseInt(io.getInput());

            io.display("Enter Entry Toll Number");
            entryTollNumber = parseInt(io.getInput());

            io.display("Enter Exit Toll Number");
            exitTollNumber = parseInt(io.getInput());
        }catch (Exception e) {
            io.display("Give a valid input");
        }

    }

    boolean invalidInput(int typeOfVehicle, int entryTollNumber, int exitTollNumber) {
        if(!(typeOfVehicle == 2 || typeOfVehicle == 4)) {
            io.display("Give the correct wheeler type");
            return true;
        }
        if(!(entryTollNumber >= 1 && entryTollNumber <= ringRoad.getTollGates().size())) {
            io.display("Invalid Entry Toll Number");
            return true;
        }
        if(!(exitTollNumber >= 0 && exitTollNumber <= ringRoad.getTollGates().size())) {
            io.display("Invalid Exit Toll Number");
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
        io.display("Collect Toll fee Rs." + tollFee +  "for travel from TollGate#" + entryTollNumber + "to TollGate#" + exitTollNumber);
    }

}
