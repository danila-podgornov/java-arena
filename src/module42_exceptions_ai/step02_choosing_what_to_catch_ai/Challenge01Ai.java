// AI-Generated
package module42_exceptions_ai.step02_choosing_what_to_catch_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * A kitchen timer is set with minutes and seconds with a colon between them, such as {@code 2:30}. The program below reads one line and prints the time in seconds, but it crashes on bad input. Add a {@code try} with two {@code catch} blocks, so that:
     * <ul>
     * <li>a line without a colon, such as {@code 150}, prints {@code Use minutes:seconds, like 2:30}
     * <li>a line whose parts aren't whole numbers, such as {@code 2:3o}, prints {@code Minutes and seconds must be whole numbers}
     * </ul>
     * <p>A good time still prints the seconds: {@code Timer set for 150 seconds} for {@code 2:30}. With the input {@code 150} the program prints: see the expected output below.
     * Expected output
     * {@code Use minutes:seconds, like 2:30}
     * Hints
     * 1. Put the lines from {@code split} to the {@code println} inside {@code try { ... }}.
     * 2. {@code parts[1]} throws an {@code ArrayIndexOutOfBoundsException} when there's no colon, and {@code Integer.parseInt} throws a {@code NumberFormatException}: one {@code catch} block for each.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String time = scanner.nextLine();
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        System.out.println("Timer set for " + (minutes * 60 + seconds) + " seconds");
    }
}
