import static java.lang.Integer.parseInt;

public class Application {

    private int typeOfVehicle;
    private int entryTollNumber;
    private int exitTollNumber;
    TollOperator tollOperator;

    InputOutput io;

    public Application(InputOutput io,TollOperator tollOperator) {
        this.io = io;
        this.tollOperator = tollOperator;
    }

    void run() {
        io.display("Welcome to Electronic Toll Collection\n");
        do {
            getInput();
            if(tollOperator.isInvalidInput(typeOfVehicle, entryTollNumber, exitTollNumber)) {
                io.display("Give a valid input");
            }
        }while(tollOperator.isInvalidInput(typeOfVehicle, entryTollNumber, exitTollNumber));
        int tollFee = tollOperator.calculateFee(typeOfVehicle, entryTollNumber, exitTollNumber);
        displayCalculatedFee(entryTollNumber, exitTollNumber, tollFee);
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
            io.display("Invalid Input");
        }

    }

    void displayCalculatedFee(int entryTollNumber, int exitTollNumber, int tollFee) {
        io.display("Collect Toll fee Rs." + tollFee +  " for travel from TollGate#" + entryTollNumber + " to TollGate#" + exitTollNumber);
    }

}
