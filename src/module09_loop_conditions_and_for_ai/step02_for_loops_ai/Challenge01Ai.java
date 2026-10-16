// AI-Generated
package module09_loop_conditions_and_for_ai.step02_for_loops_ai;

public class Challenge01Ai {
    /**
     * Rewrite this {@code while} loop as a {@code for} loop. The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Lap 1
     * Lap 2
     * Lap 3
     * Lap 4
     * }</pre>
     * Hints
     * 1. The three parts are already there: {@code int lap = 1}, {@code lap <= 4} and {@code lap++}.
     * 2. {@code for (int lap = 1; lap <= 4; lap++) { ... }}, and the loop's block keeps only the print line.
     */
    public static void main(String[] args) {
        int lap = 1;
        while (lap <= 4) {
            System.out.println("Lap " + lap);
            lap++;
        }
    }
}
