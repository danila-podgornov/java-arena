// AI-Generated
package module14_for_each_list_methods_and_lists_in_methods_ai.step06_one_list_two_names_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Challenge03Ai {
    /**
     * The program reads scores until the line {@code end}, keeps the list as it was in {@code before}, and then doubles every score. But {@code Before:} shows the doubled scores too. Fix the line that makes {@code before}, so it holds a real copy. For the input 3, 5 and 8 the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Before: [3, 5, 8]
     * After: [6, 10, 16]
     * }</pre>
     * Hints
     * 1. {@code before = scores} gives the same list a second name, so doubling the scores shows up through both names.
     * 2. Make a new list with the same values: {@code ArrayList<Integer> before = new ArrayList<>(scores);}
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> scores = new ArrayList<>();
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("end")) {
                break;
            }
            scores.add(Integer.valueOf(line));
        }

        ArrayList<Integer> before = scores;
        for (int i = 0; i < scores.size(); i++) {
            scores.set(i, scores.get(i) * 2);
        }
        System.out.println("Before: " + before);
        System.out.println("After: " + scores);
    }
}
