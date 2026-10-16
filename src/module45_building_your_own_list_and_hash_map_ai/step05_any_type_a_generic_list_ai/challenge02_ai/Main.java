// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step05_any_type_a_generic_list_ai.challenge02_ai;

public class Main {
    /**
     * {@code SimpleList.java} is the class from this step. A list of Integers has two {@code remove} methods that both seem to fit. What does this program print?
     * Hints
     * 1. {@code scores.remove(1)} gives an int, and {@code remove(int index)} takes an int as it is, so it removes the value at index 1, whatever that value is.
     * 2. {@code Integer.valueOf(1)} is an Integer, which matches {@code remove(T value)}: it removes the first value that equals 1. The value 9 isn't there, so that {@code remove} returns false. Count the indexes again after the removals.
     */
    public static void main(String[] args) {
        SimpleList<Integer> scores = new SimpleList<>();
        int[] values = {3, 1, 4, 1, 5};
        for (int value : values) {
            scores.add(value);
        }
        scores.remove(1);
        System.out.println(scores);
        scores.remove(Integer.valueOf(1));
        System.out.println(scores);
        System.out.println(scores.remove(Integer.valueOf(9)) + " " + scores.indexOf(5));
    }
}
