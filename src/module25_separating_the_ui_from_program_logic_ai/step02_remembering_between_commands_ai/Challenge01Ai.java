// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step02_remembering_between_commands_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * A small campsite has 3 tent spots. The program remembers how many spots are taken, starting from 0. Create that variable before the loop, and add the commands:
     * <ul>
     * <li>{@code arrive}: a group arrives. Print {@code Welcome! Free spots: } and the number of spots still free, or {@code Sorry, the campsite is full} when all 3 spots are taken.
     * <li>{@code depart}: a group leaves. Print {@code Safe travels! Free spots: } and the number of free spots, or {@code Nobody is camping} when no spot is taken.
     * <li>{@code spots}: print {@code Free spots: } and the number of free spots.
     * <li>Anything else: print {@code Unknown command: } and the command.
     * </ul>
     * <p>{@code quit} is ready. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Welcome! Free spots: 2
     * > Welcome! Free spots: 1
     * > Free spots: 1
     * > Welcome! Free spots: 0
     * > Sorry, the campsite is full
     * > Safe travels! Free spots: 1
     * > Lights out
     * }</pre>
     * Hints
     * 1. {@code int taken = 0;} goes before the loop, so the count lasts from one command to the next. Inside the loop, it would be 0 again in every round.
     * 2. In the {@code arrive} branch, check {@code taken < 3} before adding one. In the {@code depart} branch, check {@code taken > 0} before taking one away. The free spots are {@code 3 - taken}, in parentheses when it's part of a longer {@code +}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Create the variable for the taken spots here.
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Lights out");
                break;
            }
            // Handle arrive, depart, spots and unknown commands here.
        }
    }
}
