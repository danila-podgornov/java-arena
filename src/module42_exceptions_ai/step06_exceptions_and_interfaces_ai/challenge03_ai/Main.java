// AI-Generated
package module42_exceptions_ai.step06_exceptions_and_interfaces_ai.challenge03_ai;

import java.util.Scanner;

public class Main {
    /**
     * Another door's code changes every day: the first line of {@code today.txt} is today's code. {@code DailyCode.java} reads it with a Scanner in a try-with-resources without a {@code catch}, so that its {@code isValid} passes the IOException on. The program reads a typed code and prints {@code The door opens} or {@code Wrong code}, but it doesn't compile. Fix it:
     * <ul>
     * <li>DailyCode's {@code isValid} declares more than DoorCodes allows. Make it declare what the interface says.
     * <li>Then {@code main} has to deal with the exception: when the code can't be read, the program prints {@code Keypad out of order}.
     * </ul>
     * <p>For the input {@code 7294} and the file shown below, the program prints: see the expected output below.
     * Expected output
     * {@code The door opens}
     * Hints
     * 1. javac's first message is about DailyCode: {@code overridden method does not throw Exception}. The interface allows {@code IOException}, which DailyCode already imports.
     * 2. Next javac says {@code unreported exception IOException} in {@code main}. Put the {@code if} and its {@code else} in a {@code try} block, and print {@code Keypad out of order} in {@code catch (IOException e)}, which needs {@code import java.io.IOException;} in Main.java.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String typed = scanner.nextLine();
        DoorCodes codes = new DailyCode("today.txt");
        if (codes.isValid(typed)) {
            System.out.println("The door opens");
        } else {
            System.out.println("Wrong code");
        }
    }
}
