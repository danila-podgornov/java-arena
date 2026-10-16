// AI-Generated
package module55_recursion_ai.step01_a_method_that_calls_itself_ai;

public class Challenge01Ai {
    /**
     * A quiz show's timer counts down the seconds of a round. {@code countDown(seconds)} prints the seconds from {@code seconds} down to 1, one per line. Fill in the blank, the value that the recursive call is given, so that the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * 5
     * 4
     * 3
     * 2
     * 1
     * Time is up
     * }</pre>
     * Hints
     * 1. Each call prints its own number, then leaves the rest of the countdown to a call with a smaller number.
     * 2. The next number to print is one less than this call's: {@code seconds - 1}. When it reaches 0, the base case stops the calls.
     */
    public static void main(String[] args) {
        countDown(5);
        System.out.println("Time is up");
    }

    public static void countDown(int seconds) {
        if (seconds == 0) {
            return;
        }
        System.out.println(seconds);
        countDown(___);
    }
}
