// AI-Generated
package module27_procedural_and_object_oriented_programs_ai.step03_a_command_program_procedurally_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * A bike-share station has 12 slots, and in the morning 5 of them hold a bike. The program is procedural: its state is two local variables, {@code slots} and {@code bikes}, and the commands {@code status} and {@code close} are ready. Add the two commands that change the state, as {@code else if} branches before the last {@code else}. Each one checks its own limit before it changes anything:
     * <ul>
     * <li>{@code rent}: the next line is a number of bikes. If the station has that many, take them and print {@code Enjoy the ride! Bikes here: } and the bikes left. If it doesn't, change nothing and print {@code Sorry, bikes here: } and the bikes.
     * <li>{@code return}: the next line is a number of bikes. If there are that many free slots, put the bikes back and print {@code Thanks! Bikes here: } and the bikes. If not, change nothing and print {@code Sorry, free slots: } and the free slots.
     * </ul>
     * <p>For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Enjoy the ride! Bikes here: 2
     * > Sorry, bikes here: 2
     * > Thanks! Bikes here: 11
     * > Sorry, free slots: 1
     * > Bikes: 11, free slots: 1
     * > Station closed
     * }</pre>
     * Hints
     * 1. Each new branch is shaped like the box office's {@code sell}: <code>} else if (command.equals("rent")) {</code>, then the number from the next line, with {@code Integer.valueOf(scanner.nextLine())}.
     * 2. Check the limit first, and change {@code bikes} only when the command is allowed. {@code rent} is refused when {@code count > bikes}, and {@code return} when {@code bikes + count > slots}. The free slots are {@code slots - bikes}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int slots = 12;
        int bikes = 5;
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            if (command.equals("close")) {
                System.out.println("Station closed");
                break;
            }
            // Add the branches for rent and return before the last else.
            if (command.equals("status")) {
                System.out.println("Bikes: " + bikes + ", free slots: " + (slots - bikes));
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }
}
