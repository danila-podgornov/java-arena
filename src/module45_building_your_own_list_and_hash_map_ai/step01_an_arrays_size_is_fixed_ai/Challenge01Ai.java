// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step01_an_arrays_size_is_fixed_ai;

import java.util.Arrays;

public class Challenge01Ai {
    /**
     * A knitting club keeps the names of the stitch patterns it has learned in an array, and it has just learned a fourth. Fill in the blanks of {@code twiceAsLong}, which returns a new array twice as long as {@code items}, with the same names at the same indexes. The first blank is the new array's length, and the second copies one name. The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * [garter, rib, cable, lace, null, null]
     * 6
     * }</pre>
     * Hints
     * 1. The old array's length is {@code items.length}, and the new one is twice that: {@code items.length * 2}.
     * 2. Each round of the loop copies the name at index {@code i} to the same index of the new array: {@code bigger[i] = items[i];}.
     */
    public static void main(String[] args) {
        String[] patterns = {"garter", "rib", "cable"};
        patterns = twiceAsLong(patterns);
        patterns[3] = "lace";
        System.out.println(Arrays.toString(patterns));
        System.out.println(patterns.length);
    }

    public static String[] twiceAsLong(String[] items) {
        int newLength = ___;
        String[] bigger = new String[newLength];
        for (int i = 0; i < items.length; i++) {
            ___
        }
        return bigger;
    }
}
