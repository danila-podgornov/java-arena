// AI-Generated
package module28_sorting_and_searching_ai.step01_algorithms_and_the_smallest_value_ai;

public class Challenge01Ai {
    /**
     * A greenhouse logs its lowest temperature every night. Fill in the blanks of {@code coldestFrom(int[] temps, int start)}, which returns the index of the lowest temperature from index {@code start} on. The check runs:
     * <pre>{@code
     * int[] temps = {3, -2, 5, -4, 1};
     * System.out.println(coldestFrom(temps, 0));
     * System.out.println(coldestFrom(temps, 4));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 3
     * 4
     * }</pre>
     * Hints
     * 1. It works like {@code fastestFrom} above. The coldest so far starts at the index where the search starts, not at 0.
     * 2. The loop starts right after {@code start}, at {@code start + 1}, and each temperature is compared with the coldest one so far, {@code temps[coldest]}.
     */
    public static void main(String[] args) {
        int[] temps = {3, -2, 5, -4, 1};
        System.out.println(coldestFrom(temps, 0));
        System.out.println(coldestFrom(temps, 4));
    }

    public static int coldestFrom(int[] temps, int start) {
        int coldest = ___;
        for (int i = ___; i < temps.length; i++) {
            if (temps[i] < temps[___]) {
                coldest = i;
            }
        }
        return coldest;
    }
}
