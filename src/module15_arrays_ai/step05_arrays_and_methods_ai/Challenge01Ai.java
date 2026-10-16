// AI-Generated
package module15_arrays_ai.step05_arrays_and_methods_ai;

public class Challenge01Ai {
    /**
     * Fill in the blanks of {@code countAbove}, which returns how many elements of the array are greater than {@code limit}. The check runs {@code int[] values = {3, 8, 5, 10};} and then {@code System.out.println(countAbove(values, 4));}, and expects: see the expected output below.
     * Expected output
     * {@code 3}
     * Hints
     * 1. The method returns a count, which is a whole number.
     * 2. A parameter is a type and a name. The type here is an array of ints, and the loop calls it {@code values}: {@code int[] values}.
     */
    public static void main(String[] args) {
        int[] ages = {12, 35, 8, 41, 19};
        System.out.println(countAbove(ages, 18));
    }

    public static ___ countAbove(___, int limit) {
        int count = 0;
        for (int value : values) {
            if (value > limit) {
                count++;
            }
        }
        return count;
    }
}
