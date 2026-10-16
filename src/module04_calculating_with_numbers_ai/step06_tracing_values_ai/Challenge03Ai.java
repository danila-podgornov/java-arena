// AI-Generated
package module04_calculating_with_numbers_ai.step06_tracing_values_ai;

public class Challenge03Ai {
    /**
     * Three values this time. Trace carefully: the order of the lines matters.
     * Hints
     * 1. After the first three lines: x is 2, y is 5 and z is 10.
     * 2. Then {@code x = z - y} makes x 5, and {@code y = y + x} uses that new x: 5 + 5.
     */
    public static void main(String[] args) {
        int x = 2;
        int y = x + 3;
        int z = y * x;
        x = z - y;
        y = y + x;
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }
}
