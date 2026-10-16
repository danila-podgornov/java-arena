// AI-Generated
package module24_lists_inside_objects_ai.step01_lists_a_quick_review_ai.challenge03_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * Read runners until an empty line. Each line has a name and a time in minutes, separated by a space, like {@code Ada 27}. Make a {@code Runner} of each line and add it to the list {@code runners}. {@code Runner.java} is the class from the first challenge.
     * <p>Then print how many runners there are, like {@code Runners: 3}, and after that every runner, starting from the last one read and ending with the first. For the input shown below, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Runners: 3
     * Cy, 22 min
     * Bo, 35 min
     * Ada, 27 min
     * }</pre>
     * Hints
     * 1. Read in a {@code while (true)} loop and {@code break} at the empty line. {@code line.split(" ")} splits {@code Ada 27} into the name and the minutes, and {@code Integer.valueOf(parts[1])} turns the minutes into a number: {@code runners.add(new Runner(parts[0], Integer.valueOf(parts[1])));}
     * 2. A for-each loop only goes forwards. To start from the last runner, loop over the indexes backwards: {@code for (int i = runners.size() - 1; i >= 0; i--)}, and print {@code runners.get(i)}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Runner> runners = new ArrayList<>();

    }
}
