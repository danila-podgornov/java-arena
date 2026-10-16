// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step02_remembering_between_commands_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Challenge02Ai {
    /**
     * A birdwatcher notes each bird seen. Write the program. Keep the sightings in a list of Strings, one entry for each bird seen, and create the list before the loop. The commands:
     * <ul>
     * <li>{@code saw}: the next line is a species. Add it to the list and print {@code Noted: } and the species.
     * <li>{@code count}: the next line is a species. Print the species, {@code : } and how many times it was seen, spelled exactly the same, capitals included, like {@code robin: 2}.
     * <li>{@code total}: print {@code Birds seen: } and the number of sightings.
     * <li>{@code quit}: print {@code Happy birding!} and end the program.
     * <li>Anything else: print {@code Unknown command: } and the command.
     * </ul>
     * <p>Print the prompt {@code > } before each command. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Noted: robin
     * > Noted: heron
     * > Noted: robin
     * > robin: 2
     * > owl: 0
     * > Birds seen: 3
     * > Happy birding!
     * }</pre>
     * Hints
     * 1. Three small problems: the command loop, adding to a list, and counting the entries of a list that equal a given String. {@code total} is the list's {@code size()}.
     * 2. For {@code count}, read the species with another {@code scanner.nextLine()}, then go through the list with a for-each loop and add one to a counter for each entry that {@code equals} the species.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Write the program here.
    }
}
