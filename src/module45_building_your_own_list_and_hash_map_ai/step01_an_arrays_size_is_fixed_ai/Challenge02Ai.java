// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step01_an_arrays_size_is_fixed_ai;

import java.util.Arrays;

public class Challenge02Ai {
    /**
     * A pottery class keeps its sign-up sheet in an array with a count, as in this step. What does this program print?
     * Hints
     * 1. The count goes up by one for each name, and it's also the index where the next name goes. The array keeps its length of 4, and its unused places print as {@code null}.
     * 2. The longer array has 4 + 2 places. Only the two names are copied, so after Lena goes in at index 2, index 3 is still {@code null}.
     */
    public static void main(String[] args) {
        String[] names = new String[4];
        int count = 0;
        names[count] = "Ines";
        count++;
        names[count] = "Kofi";
        count++;
        System.out.println(count + " of " + names.length);
        System.out.println(Arrays.toString(names));

        String[] longer = new String[names.length + 2];
        for (int i = 0; i < count; i++) {
            longer[i] = names[i];
        }
        names = longer;
        names[count] = "Lena";
        count++;
        System.out.println(count + " of " + names.length + ": " + names[2] + ", " + names[3]);
    }
}
