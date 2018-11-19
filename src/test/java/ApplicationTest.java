import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ApplicationTest {

    InputOutput io = mock(InputOutput.class);
    TollOperator tollOperator = mock(TollOperator.class);
    Application app = new Application(io,tollOperator);
    @Test
    public void getInputMethodShouldAskForVehicleTypeAndEntryAndExitTollNumbers() {
        when(io.getInput()).thenReturn("4").thenReturn("4").thenReturn("2");

        app.getInput();

        verify(io).display("Enter Vehicle Type:");
        verify(io).display("Enter Entry Toll Number");
        verify(io).display("Enter Exit Toll Number");
    }

    @Test
    public void getInputMethodShouldAskForVehicleTypeAndEntryTollNumberAndShouldCatchExceptionForInvalidData() {
        when(io.getInput()).thenReturn("4").thenReturn("X").thenReturn("2");

        app.getInput();

        verify(io).display("Enter Vehicle Type:");
        verify(io).display("Enter Entry Toll Number");
        verify(io).display("Give a valid input");
    }

    @Test
    public void displayCalculatedFeeShouldDisplayTheFee() {
        app.displayCalculatedFee(2,4,50);

        verify(io).display("Collect Toll fee Rs.50 for travel from TollGate#2 to TollGate#4");
    }

    @Test
    public void runMethodShouldDisplayWelcomeMessage() {
        int typeOfVehicle = 2;
        int entryTollNumber = 2;
        int exitTollNumber = 4;
        when(tollOperator.isInvalidInput(typeOfVehicle,entryTollNumber,exitTollNumber)).thenReturn(false).thenReturn(false);
        when(tollOperator.calculateFee(typeOfVehicle,entryTollNumber,exitTollNumber)).thenReturn(50);
        app.run();

        verify(io).display("Welcome to Electronic Toll Collection\n");
    }

}