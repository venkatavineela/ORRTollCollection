import java.util.Scanner;

public class ORRTollCollection {
    public static void main(String args[]) {
        InputOutput inputOutput = new ConsoleInputOutput(new Scanner(System.in));
        TollOperator tollOperator = new TollOperator(inputOutput);
        tollOperator.operate();
    }
}
