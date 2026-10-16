// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step01_a_loop_that_reads_commands_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * A display at a tram stop answers commands: {@code next} prints {@code Tram 4 in 6 minutes}, {@code help} prints {@code Commands: next, help, quit}, and {@code quit} prints {@code Goodbye} and ends the program. Anything else prints {@code Unknown command: } and the command. Fill in the blanks. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Tram 4 in 6 minutes
     * > Commands: next, help, quit
     * > Unknown command: bus
     * > Goodbye
     * }</pre>
     * Hints
     * 1. The loop and the {@code quit} branch have the same shape as in the swimming pool program above. The prompt stays on the line where the command is typed.
     * 2. The condition is {@code true}, so the loop runs until {@code break;} stops it. The prompt is printed with {@code print}, not {@code println}, and the branch for everything else starts with {@code else}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (___) {
            System.out.___("> ");
            String command = scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Goodbye");
                ___;
            }
            if (command.equals("next")) {
                System.out.println("Tram 4 in 6 minutes");
            } else if (command.equals("help")) {
                System.out.println("Commands: next, help, quit");
            } ___ {
                System.out.println("Unknown command: " + command);
            }
        }
    }
}
