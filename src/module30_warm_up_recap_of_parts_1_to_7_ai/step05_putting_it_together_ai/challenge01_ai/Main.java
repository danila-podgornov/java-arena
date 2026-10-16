// AI-Generated
package module30_warm_up_recap_of_parts_1_to_7_ai.step05_putting_it_together_ai.challenge01_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * At the end of a woodworking course, each student's project is typed in, one per line, until an empty line: the student, the project and the hours it took, like {@code Ada,bird box,6}. {@code Project.java} is ready. In {@code Main.java}, read the projects into the {@code ArrayList<Project>}. The average isn't known until the last project has been read, so the list keeps them until then. After reading, print:
     * <ul>
     * <li>{@code Projects: } and the number of projects,
     * <li>{@code Average: }, the average hours as a {@code double} (the hours added up, divided by the number of projects), and {@code  hours},
     * <li>{@code Longer than average:}, and on the lines after it every project that took more hours than the average, in the order they were typed.
     * </ul>
     * <p>With no projects, print only {@code No projects}. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Projects: 4
     * Average: 7.5 hours
     * Longer than average:
     * Ben: stool, 11 hours
     * Dev: bookshelf, 9 hours
     * }</pre>
     * Hints
     * 1. Read in a {@code while (true)} loop that stops at the empty line. Split each line at the commas, and add {@code new Project(parts[0], parts[1], Integer.valueOf(parts[2]))} to the list.
     * 2. After the loop, check {@code projects.isEmpty()} first. Then one for-each loop adds up the hours, {@code (double) total / projects.size()} is the average, and a second loop prints each project whose {@code getHours()} is greater than the average.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Project> projects = new ArrayList<>();

    }
}
