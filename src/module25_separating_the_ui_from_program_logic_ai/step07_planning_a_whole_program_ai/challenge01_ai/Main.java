// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step07_planning_a_whole_program_ai.challenge01_ai;

import java.util.Scanner;

public class Main {
    /**
     * Steps 5 and 6 for the coat check. {@code CoatCheck.java} is the class above, and {@code Main.java} is ready. Write {@code UserInterface.java}: its constructor takes a {@code Scanner} and a {@code CoatCheck}, and {@code start()} runs the commands of the table, with the prompt {@code > } before each one. Anything else prints {@code Unknown command: } and the command. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Ana, your ticket is 1
     * > Ben, your ticket is 2
     * > Coats: 2
     * > Here's your coat, Ana
     * > No coat on hook 1
     * > Cleo, your ticket is 1
     * > No coat on hook 7
     * > Coats: 2
     * > Good night
     * }</pre>
     * Hints
     * 1. The user interface keeps a {@code Scanner} and a {@code CoatCheck}, set in the constructor. For {@code leave}, read the name, keep the ticket that {@code leave} returns, and print both.
     * 2. For {@code collect}, read the number with {@code Integer.valueOf(this.scanner.nextLine())}, keep what {@code collect} returns in a String variable, and check {@code if (owner == null)} to choose the message.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoatCheck check = new CoatCheck();
        UserInterface ui = new UserInterface(scanner, check);
        ui.start();
    }
}
