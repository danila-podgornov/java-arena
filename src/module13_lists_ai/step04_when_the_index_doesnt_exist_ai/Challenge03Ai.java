// AI-Generated
package module13_lists_ai.step04_when_the_index_doesnt_exist_ai;

import java.util.ArrayList;

public class Challenge03Ai {
    /**
     * This program prints four lap times and then crashes before {@code Race over}. Read the message to find the cause, and fix it, so the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Lap 1: 62 s
     * Lap 2: 58 s
     * Lap 3: 60 s
     * Lap 4: 57 s
     * Race over
     * }</pre>
     * Hints
     * 1. The message says {@code Index 4 out of bounds for length 4}: in its last round, the loop asks for index 4, one past the end.
     * 2. The loop must stop after index 3: {@code i < 4} instead of {@code i <= 4}.
     */
    public static void main(String[] args) {
        ArrayList<Integer> laps = new ArrayList<>();
        laps.add(62);
        laps.add(58);
        laps.add(60);
        laps.add(57);
        for (int i = 0; i <= 4; i++) {
            System.out.println("Lap " + (i + 1) + ": " + laps.get(i) + " s");
        }
        System.out.println("Race over");
    }
}
