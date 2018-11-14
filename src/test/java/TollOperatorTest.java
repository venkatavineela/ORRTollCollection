import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TollOperatorTest {
    InputOutput io = mock(InputOutput.class);
    TollOperator tollOperator = new TollOperator(io);
    @Test
    public void getInputMethodShouldAskForVehicleTypeAndEntryAndExitTollNumbers() {
        when(io.getInput()).thenReturn("4").thenReturn("4").thenReturn("2");

        tollOperator.getInput();

        verify(io).display("Enter Vehicle Type:");
        verify(io).display("Enter Entry Toll Number");
        verify(io).display("Enter Exit Toll Number");
    }

    @Test
    public void getInputMethodShouldAskForVehicleTypeAndEntryTollNumberAndShouldCatchExceptionForInvalidData() {
        when(io.getInput()).thenReturn("4").thenReturn("X").thenReturn("2");

        tollOperator.getInput();

        verify(io).display("Enter Vehicle Type:");
        verify(io).display("Enter Entry Toll Number");
        verify(io).display("Give a valid input");
    }
}