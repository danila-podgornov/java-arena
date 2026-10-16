// AI-Generated
package module54_libraries_maven_and_databases_ai.step05_packaging_other_tools_and_the_end_of_the_course_ai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Challenge03Ai {
    /**
     * A community kitchen plans its volunteer shifts. Read lines such as {@code Saturday Ada} (a day, a space and a name) until an empty line. Then print, for each day, the day, a colon and the names of that day's volunteers in the order they were read, separated by {@code , }. Print the days in the order they first came up in the input.
     * <p>Keep the names in a {@code HashMap<String, List<String>>} from each day to its list of names (module 33). A HashMap doesn't keep its keys in the order they came, so keep the days' order in a list of its own. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Saturday: Ada, Ben, Dina
     * Monday: Carl
     * }</pre>
     * Hints
     * 1. When a day comes up for the first time ({@code !shifts.containsKey(day)}), put a new empty list for it in the map and add the day to the list of days. Then add the name to {@code shifts.get(day)}.
     * 2. At the end, go through the list of days, not the map. {@code String.join(", ", names)} joins a list of Strings with {@code , } between them.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
}
