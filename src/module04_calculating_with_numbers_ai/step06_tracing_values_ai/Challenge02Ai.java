// AI-Generated
package module04_calculating_with_numbers_ai.step06_tracing_values_ai;

public class Challenge02Ai {
    /**
     * And this one? Watch the change to {@code b} after the copy.
     * Hints
     * 1. {@code b} starts as {@code 4 * 2}, which is 8. Then {@code a} gets a copy of 8.
     * 2. {@code b = b + 1} changes only {@code b}: it becomes 9, while {@code a} stays 8.
     */
    public static void main(String[] args) {
        int a = 4;
        int b = a * 2;
        a = b;
        b = b + 1;
        System.out.println(a);
        System.out.println(b);
    }
}
