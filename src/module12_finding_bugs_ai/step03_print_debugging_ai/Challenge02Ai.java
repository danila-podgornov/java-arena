// AI-Generated
package module12_finding_bugs_ai.step03_print_debugging_ai;

public class Challenge02Ai {
    /**
     * The method {@code sumBetween(int from, int to)} should add up every whole number from {@code from} to {@code to}, both included. For 3 and 6 that's 3 + 4 + 5 + 6 = 18, but it returns 12. Find the bug and fix it. The check runs {@code System.out.println(sumBetween(3, 6));} and expects: see the expected output below.
     * Expected output
     * {@code 18}
     * Hints
     * 1. Print {@code n} inside the loop. Which numbers are added, and which one is missing?
     * 2. {@code to} itself must be added too: the condition should be {@code n <= to}.
     */
    public static void main(String[] args) {
        System.out.println(sumBetween(3, 6));
    }

    public static int sumBetween(int from, int to) {
        int sum = 0;
        for (int n = from; n < to; n++) {
            sum += n;
        }
        return sum;
    }
}
