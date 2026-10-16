// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step01_a_loop_that_reads_commands_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * This program should answer every command, but for the input shown it prints only {@code > Unknown command} and {@code > Disconnected}. With other input it even crashes. Find out why, and fix it, so that it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > pong
     * > Server 2.4
     * > pong
     * > Disconnected
     * }</pre>
     * Hints
     * 1. Each {@code scanner.nextLine()} reads a new line. How many lines does one round of the loop read, when the command isn't {@code quit}?
     * 2. Read the command once, at the start of the round, into a variable: {@code String command = scanner.nextLine();}. Then compare that variable in every {@code if}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            if (scanner.nextLine().equals("quit")) {
                System.out.println("Disconnected");
                break;
            }
            if (scanner.nextLine().equals("ping")) {
                System.out.println("pong");
            } else if (scanner.nextLine().equals("version")) {
                System.out.println("Server 2.4");
            } else {
                System.out.println("Unknown command");
            }
        }
    }
}
