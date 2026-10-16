// AI-Generated
package module55_recursion_ai.step03_recursion_on_strings_and_arrays_ai;

public class Challenge03Ai {
    /**
     * A hiking trail is split into stages, and an array holds each stage's length in kilometers. Write the method {@code kilometersFrom(int[] stages, int start)}, which returns the total length of the stages from index {@code start} to the end of the array, with recursion and no loop: the stage at {@code start} plus the kilometers from {@code start + 1}. When {@code start} is the array's length, no stages are left, and the total is 0. The check runs:
     * <pre>{@code
     * int[] stages = {12, 8, 15, 6, 9};
     * System.out.println(kilometersFrom(stages, 0));
     * System.out.println(kilometersFrom(stages, 3));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 50
     * 15
     * }</pre>
     * Hints
     * 1. The base case: when {@code start} is {@code stages.length}, there are no stages left, so return 0.
     * 2. Otherwise, add this stage to the rest: {@code return stages[start] + kilometersFrom(stages, start + 1);}
     */
    public static void main(String[] args) {
        int[] stages = {12, 8, 15, 6, 9};
        System.out.println(kilometersFrom(stages, 0));
        System.out.println(kilometersFrom(stages, 3));
    }

    // Write the method kilometersFrom here.
}
