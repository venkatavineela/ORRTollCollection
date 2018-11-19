import java.util.Scanner;

public class ORRTollCollection {

    public static void main(String args[]) {
        InputOutput io = new ConsoleInputOutput(new Scanner(System.in));
        TollOperator tollOperator = new TollOperator(new RingRoad(),new TollFeeCalculator());
        Application app = new Application(io,tollOperator);
        app.run();
    }
}
