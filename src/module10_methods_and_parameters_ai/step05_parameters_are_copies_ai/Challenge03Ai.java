// AI-Generated
package module10_methods_and_parameters_ai.step05_parameters_are_copies_ai;

public class Challenge03Ai {
    /**
     * What does this program print? The method changes its parameter in a loop.
     * Hints
     * 1. Inside the method, {@code n} starts at 0 and goes up by one before each print.
     * 2. The loop prints 1, 2 and 3. Then {@code main} prints its own {@code n}, which is still 0.
     */
    public static void main(String[] args) {
        int n = 0;
        countUp(n);
        System.out.println("n is still " + n);
    }

    public static void countUp(int n) {
        while (n < 3) {
            n++;
            System.out.println(n);
        }
    }
}
