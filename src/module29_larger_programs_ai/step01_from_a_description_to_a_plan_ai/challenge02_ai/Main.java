// AI-Generated
package module29_larger_programs_ai.step01_from_a_description_to_a_plan_ai.challenge02_ai;

import java.util.Scanner;

public class Main {
    /**
     * Now the input part of the movie marathon. {@code Film.java} and {@code Marathon.java} are ready. In {@code Main.java}, read films until an empty line. Each line has a title and a length in minutes, separated by a comma, like {@code Night Train,118}. Add a Film to the marathon for each line. Then, using the marathon's methods ({@code count()}, {@code totalMinutes()} and {@code shortest()}), print:
     * <ul>
     * <li>{@code Films: } and the number of films,
     * <li>{@code Watching time: } and the total as hours and minutes, like {@code 5 h 15 min}: always both numbers, such as {@code 3 h 0 min},
     * <li>{@code Shortest: } and the shortest film.
     * </ul>
     * <p>If no films were typed, print only {@code No films}. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Films: 3
     * Watching time: 5 h 15 min
     * Shortest: Paper Moons (95 min)
     * }</pre>
     * Hints
     * 1. The loop of the game night's {@code main}: read a line, {@code break} when it {@code isEmpty()}, split it at the comma, and add {@code new Film(parts[0], Integer.valueOf(parts[1]))} to the marathon.
     * 2. After the loop, check {@code marathon.count() == 0} first. The hours are {@code total / 60}, and the minutes left over are {@code total % 60}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Marathon marathon = new Marathon();
        // Read the films here, and then print the results.
    }
}
