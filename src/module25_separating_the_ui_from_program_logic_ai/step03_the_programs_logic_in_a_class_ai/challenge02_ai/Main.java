// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step03_the_programs_logic_in_a_class_ai.challenge02_ai;

import java.util.Scanner;

public class Main {
    /**
     * A thermostat's logic is ready in {@code Thermostat.java}. {@code warmer()} and {@code cooler()} change the target temperature by one degree and return {@code true}. If the target is already at its limit, 28 or 15 degrees, they change nothing and return {@code false}. {@code getTarget()} returns the target.
     * <p>Write the user interface in {@code Main.java}: create a Thermostat with the target 21, and read commands, with the prompt {@code > } before each one:
     * <ul>
     * <li>{@code up}: make it one degree warmer and print the new target like {@code Target: 22 degrees}, or {@code Already at the maximum} when it can't go higher.
     * <li>{@code down}: make it one degree cooler and print the new target, or {@code Already at the minimum}.
     * <li>{@code show}: print the target like {@code Target: 21 degrees}.
     * <li>{@code off}: print {@code Thermostat off} and end the program.
     * <li>Anything else: print {@code Unknown command: } and the command.
     * </ul>
     * <p>For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Target: 21 degrees
     * > Target: 22 degrees
     * > Target: 23 degrees
     * > Target: 22 degrees
     * > Unknown command: heat
     * > Thermostat off
     * }</pre>
     * Hints
     * 1. {@code Thermostat thermostat = new Thermostat(21);} goes before the loop. The loop is shaped like the campsite's, with {@code off} in the place of {@code quit}.
     * 2. {@code if (thermostat.warmer()) { ... } else { ... }} both changes the target and tells which message to print. After it, {@code thermostat.getTarget()} gives the new target.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Create the thermostat, then write the command loop.
    }
}
