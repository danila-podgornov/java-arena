// AI-Generated
package module21_designing_classes_and_overloading_ai.step01_turning_a_program_into_objects_ai.challenge02_ai;

import java.util.Scanner;

public class Main {
    /**
     * This program counts the visitors at the two gates of a zoo. It reads a line for each visitor, {@code north} or {@code south}, until the line {@code end}, and then prints both counts. Any other line is skipped. It keeps the counts in plain variables. {@code Gate.java} holds a class that does the counting: rewrite {@code main} so it uses two Gate objects instead of the two counters, gives each visitor to the right gate with {@code pass()}, and prints the gates. For the input {@code north}, {@code south}, {@code north} and {@code end}, one per line, the program still prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * North gate: 2
     * South gate: 1
     * }</pre>
     * Hints
     * 1. Replace the two counters with two gates before the loop: {@code Gate north = new Gate("North");} and {@code Gate south = new Gate("South");}.
     * 2. In the loop, {@code north.pass();} instead of {@code northVisitors++;}, and the same for south. At the end, {@code System.out.println(north);} prints the gate with its {@code toString}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int northVisitors = 0;
        int southVisitors = 0;
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("end")) {
                break;
            }
            if (line.equals("north")) {
                northVisitors++;
            } else if (line.equals("south")) {
                southVisitors++;
            }
        }
        System.out.println("North gate: " + northVisitors);
        System.out.println("South gate: " + southVisitors);
    }
}
