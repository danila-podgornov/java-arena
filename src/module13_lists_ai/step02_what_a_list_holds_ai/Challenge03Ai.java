// AI-Generated
package module13_lists_ai.step02_what_a_list_holds_ai;

import java.util.ArrayList;

public class Challenge03Ai {
    /**
     * This program doesn't compile: javac finds two errors, one for each list. Fix them so the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * [31, 8]
     * [1.82, 1.0]
     * }</pre>
     * Hints
     * 1. A list holds objects: the type for whole numbers is {@code Integer}, not {@code int}.
     * 2. Java won't turn the {@code int} 1 into a {@code Double}. Write it as a decimal number: {@code heights.add(1.0);}
     */
    public static void main(String[] args) {
        ArrayList<int> ages = new ArrayList<>();
        ages.add(31);
        ages.add(8);
        ArrayList<Double> heights = new ArrayList<>();
        heights.add(1.82);
        heights.add(1);
        System.out.println(ages);
        System.out.println(heights);
    }
}
