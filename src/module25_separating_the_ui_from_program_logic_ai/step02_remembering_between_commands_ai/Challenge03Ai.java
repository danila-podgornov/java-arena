// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step02_remembering_between_commands_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Challenge03Ai {
    /**
     * At a deli counter, customers take their place in line and are served in the order they came. Write the program. Keep the names of the waiting customers in a list, first in line first. The commands:
     * <ul>
     * <li>{@code take}: the next line is a name. Add it to the end of the line, and print the name, {@code , you're number } and their place in line, like {@code Ana, you're number 1}.
     * <li>{@code next}: print {@code Now serving } and the first name in line, and take it off the line. If nobody is waiting, print {@code Nobody is waiting}.
     * <li>{@code queue}: print {@code In line: } and the list, like {@code In line: [Ben, Cleo]}.
     * <li>{@code close}: print {@code Closed for today} and end the program.
     * <li>Anything else: print {@code Unknown command: } and the command.
     * </ul>
     * <p>Print the prompt {@code > } before each command. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Ana, you're number 1
     * > Ben, you're number 2
     * > Now serving Ana
     * > Cleo, you're number 2
     * > In line: [Ben, Cleo]
     * > Now serving Ben
     * > Now serving Cleo
     * > Nobody is waiting
     * > Closed for today
     * }</pre>
     * Hints
     * 1. Right after {@code names.add(name)}, the new customer is last in line, so their place is {@code names.size()}.
     * 2. The first in line is at index 0: print {@code names.get(0)}, then {@code names.remove(0)}. Check {@code names.isEmpty()} first. Printing the list itself gives the {@code [Ben, Cleo]} form.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Write the program here.
    }
}
