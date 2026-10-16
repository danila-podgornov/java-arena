// AI-Generated
package module30_warm_up_recap_of_parts_1_to_7_ai.step01_reading_input_in_a_loop_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * At a school play, the ticket seller types each ticket sold at the door, one per line: {@code adult} or {@code child}. The word {@code curtain} ends the input when the play begins. An adult ticket costs 10 euros, and a child's ticket 6. Any other line is a typing mistake: it's only counted as a mistake. Fill in the blanks. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Tickets: 4
     * Mistakes: 1
     * Sales: 32 euros
     * }</pre>
     * Hints
     * 1. {@code curtain} ends the loop, and the statement that leaves a loop is {@code break}. Text is compared with {@code equals}, never with {@code ==}.
     * 2. A line that's neither {@code adult} nor {@code child} falls through both conditions to the last branch of the chain, the one without a condition: {@code else}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tickets = 0;
        int mistakes = 0;
        int sales = 0;
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("curtain")) {
                ___;
            }
            if (line.equals("adult")) {
                tickets++;
                sales += 10;
            } else if (line.___("child")) {
                tickets++;
                sales += 6;
            } ___ {
                mistakes++;
            }
        }
        System.out.println("Tickets: " + tickets);
        System.out.println("Mistakes: " + mistakes);
        System.out.println("Sales: " + sales + " euros");
    }
}
