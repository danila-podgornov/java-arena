// AI-Generated
package module15_arrays_ai.step05_arrays_and_methods_ai;

public class Challenge02Ai {
    /**
     * What does this program print? The method gets an array and an int, and changes both of its parameters.
     * Hints
     * 1. {@code values} leads to {@code main}'s own array, so {@code values[0] = 10} changes it. {@code number} is only a copy of {@code single}, so {@code single} stays 1.
     * 2. {@code int[] same = counts;} doesn't make a new array: {@code same[2] = 0} changes {@code counts[2]}.
     */
    public static void main(String[] args) {
        int[] counts = {1, 2, 3};
        int single = 1;
        grow(counts, single);
        System.out.println(counts[0] + " " + counts[1] + " " + counts[2]);
        System.out.println(single);
        int[] same = counts;
        same[2] = 0;
        System.out.println(counts[2]);
    }

    public static void grow(int[] values, int number) {
        values[0] = 10;
        number = 10;
    }
}
