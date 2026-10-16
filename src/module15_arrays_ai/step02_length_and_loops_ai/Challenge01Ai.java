// AI-Generated
package module15_arrays_ai.step02_length_and_loops_ai;

public class Challenge01Ai {
    /**
     * Fill in the blanks, so the first loop runs once for each element and the for-each loop goes through the array {@code tens}. The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * 10
     * 20
     * 30
     * 40
     * }</pre>
     * Hints
     * 1. An array's size is its field {@code length}, with no parentheses.
     * 2. A for-each loop names the array after the colon: {@code for (int value : tens)}.
     */
    public static void main(String[] args) {
        int[] tens = new int[4];
        for (int i = 0; i < tens.___; i++) {
            tens[i] = (i + 1) * 10;
        }
        for (int value : ___) {
            System.out.println(value);
        }
    }
}
