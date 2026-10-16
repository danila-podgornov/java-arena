// AI-Generated
package module12_finding_bugs_ai.step04_testing_with_different_inputs_ai;

public class Challenge03Ai {
    /**
     * Trace this program by hand, with a table for {@code a} and {@code b}, then write down what it prints.
     * Hints
     * 1. Each round, {@code next} is the sum of the two, {@code a} takes the old {@code b}, and {@code b} takes {@code next}.
     * 2. After the rounds, the pairs are (1, 2), (2, 3), (3, 5) and (5, 8).
     */
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        for (int round = 1; round <= 4; round++) {
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println(a);
        System.out.println(b);
    }
}
