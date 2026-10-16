// AI-Generated
package module11_return_values_and_the_call_stack_ai.step03_returning_from_branches_ai;

public class Challenge03Ai {
    /**
     * Write a method {@code clamp(int value, int low, int high)} that keeps {@code value} inside the range from {@code low} to {@code high}: below it, return {@code low}; above it, return {@code high}; otherwise return the value itself. The check runs {@code System.out.println(clamp(130, 0, 100));} and expects: see the expected output below.
     * Expected output
     * {@code 100}
     * Hints
     * 1. Like the volume control in module 7, but with the limits as parameters and a {@code return} in each case.
     * 2. {@code if (value < low) { return low; }}, the same for {@code high}, and {@code return value;} last.
     */
    public static void main(String[] args) {
        System.out.println(clamp(130, 0, 100));
    }

    // Write the clamp method here.
}
