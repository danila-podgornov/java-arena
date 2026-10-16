// AI-Generated
package module27_procedural_and_object_oriented_programs_ai.step03_a_command_program_procedurally_ai;

import java.util.Scanner;

public class Challenge02Ai {
    /**
     * The box office added the command {@code one}, which sells a single ticket, for people who buy at the door. But once the concert is sold out, {@code one} goes on selling, and {@code status} shows more tickets sold than there are seats. Fix the {@code one} branch so that it follows the same rule as {@code sell}: when no ticket is left, it sells nothing and prints {@code Sorry, sold out}. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Sold! Tickets left: 2
     * > Sold! Tickets left: 1
     * > Sold! Tickets left: 0
     * > Sorry, sold out
     * > Sold: 200, left: 0
     * > Box office closed
     * }</pre>
     * Hints
     * 1. The {@code sell} branch checks before it changes {@code sold}. The {@code one} branch changes {@code sold} without any check. That's the copy of the rule that went missing.
     * 2. Wrap the two lines of {@code one} in an {@code if}: when {@code sold >= seats}, print {@code Sorry, sold out}, and otherwise add one to {@code sold} and print what it printed before.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seats = 200;
        int sold = 0;
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Box office closed");
                break;
            }
            if (command.equals("sell")) {
                int count = Integer.valueOf(scanner.nextLine());
                if (sold + count > seats) {
                    System.out.println("Sorry, tickets left: " + (seats - sold));
                } else {
                    sold = sold + count;
                    System.out.println("Sold! Tickets left: " + (seats - sold));
                }
            } else if (command.equals("one")) {
                sold++;
                System.out.println("Sold! Tickets left: " + (seats - sold));
            } else if (command.equals("refund")) {
                int count = Integer.valueOf(scanner.nextLine());
                if (count > sold) {
                    System.out.println("Sorry, tickets sold: " + sold);
                } else {
                    sold = sold - count;
                    System.out.println("Refunded! Tickets left: " + (seats - sold));
                }
            } else if (command.equals("status")) {
                System.out.println("Sold: " + sold + ", left: " + (seats - sold));
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }
}
