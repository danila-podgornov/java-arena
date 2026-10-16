// AI-Generated
package module43_writing_files_ai.step03_try_with_resources_and_objects_in_a_file_ai.challenge03_ai;

import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {
    /**
     * A summer camp splits its campers into two groups. {@code Camper.java} is ready: a camper has a name and an age. Write the method {@code splitGroups(ArrayList<Camper> campers)}, which writes every camper aged 12 or under into {@code juniors.txt}, and every older camper into {@code seniors.txt}, one per line as {@code name,age}, in the list's order. Both files are always written, even when a group is empty.
     * <p>Open both writers in one try-with-resources: its parentheses can hold several resources, separated by a semicolon (module 42). The method prints nothing, and passes exceptions on with {@code throws Exception}. For the campers of {@code main}, {@code juniors.txt} should hold:
     * <pre>{@code
     * Aino,11
     * Ben,9
     * Dara,12
     * }</pre>
     * <p>and {@code seniors.txt}:
     * {@code Chloe,14}
     * Hints
     * 1. <code>try (PrintWriter juniors = new PrintWriter("juniors.txt"); PrintWriter seniors = new PrintWriter("seniors.txt")) {</code> creates both files, and closes both when the block ends.
     * 2. Inside, one loop: when {@code camper.getAge() <= 12}, the line goes to {@code juniors}, and otherwise to {@code seniors}. The line is {@code camper.getName() + "," + camper.getAge()}, not the camper's {@code toString}.
     */
    public static void main(String[] args) throws Exception {
        ArrayList<Camper> campers = new ArrayList<>();
        campers.add(new Camper("Aino", 11));
        campers.add(new Camper("Ben", 9));
        campers.add(new Camper("Chloe", 14));
        campers.add(new Camper("Dara", 12));
        splitGroups(campers);
    }

    // Write the method splitGroups here.
}
