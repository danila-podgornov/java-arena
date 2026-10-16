// AI-Generated
package module51_data_visualization_ai.step07_honest_charts_ai.challenge02_ai;

public class Main {
    /**
     * Which tick unit to use? An auto-ranging axis picks a "nice" one, and {@code Bounds} can too. Add the method {@code public static int niceTick(int max)} to {@code Bounds} (in {@code Bounds.java}, next to {@code upperBound}). It returns the first number of the sequence 1, 2, 5, 10, 20, 50, 100, 200, 500, 1000, ... (each step multiplies by 2, then by 2.5, then by 2, as 1, 2, 5 repeat with one more zero) for which 10 ticks reach the largest value: {@code tick * 10 >= max}. So {@code niceTick(1010)} is 200 (100 gives only 1000), {@code niceTick(47)} is 5 and {@code niceTick(0)} is 1.
     * <p>The check runs:
     * <pre>{@code
     * System.out.println(Bounds.niceTick(1010));
     * System.out.println(Bounds.niceTick(47));
     * System.out.println(Bounds.niceTick(0));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 200
     * 5
     * 1
     * }</pre>
     * Hints
     * 1. Go through the sequence by powers of ten: 1, 10, 100, ... For each power, try the power itself, then 2 times it, then 5 times it, and return the first whose 10 ticks reach {@code max}.
     * 2. A {@code while (true)} loop can hold the three checks, each with a {@code return}, and multiply the power by 10 at its end.
     */
    public static void main(String[] args) {
        System.out.println(Bounds.niceTick(1010));
        System.out.println(Bounds.niceTick(47));
        System.out.println(Bounds.niceTick(0));
    }
}
