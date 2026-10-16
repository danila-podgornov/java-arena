// AI-Generated
package module46_random_numbers_ai.step04_picking_shuffling_and_drawing_ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Challenge02Ai {
    /**
     * A teacher gives every student the spelling words in a different order, and keeps the master list in its own order. Write the method {@code shuffledCopy(ArrayList<String> words, Random random)}, which returns a new list with the same words, shuffled with {@code Collections.shuffle} and the given Random. The list it's given must keep its order. The check runs:
     * <pre>{@code
     * ArrayList<String> words = new ArrayList<>();
     * words.add("rhythm");
     * words.add("island");
     * words.add("receive");
     * words.add("necessary");
     * words.add("calendar");
     * System.out.println(shuffledCopy(words, new Random(5)));
     * System.out.println(words);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * [necessary, island, calendar, rhythm, receive]
     * [rhythm, island, receive, necessary, calendar]
     * }</pre>
     * Hints
     * 1. Make a copy first: {@code ArrayList<String> copy = new ArrayList<>(words);}. Shuffling {@code words} itself would change the teacher's list.
     * 2. Shuffle the copy with {@code Collections.shuffle(copy, random);} and return it.
     */
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("rhythm");
        words.add("island");
        words.add("receive");
        words.add("necessary");
        words.add("calendar");
        System.out.println(shuffledCopy(words, new Random(5)));
        System.out.println(words);
    }

    public static ArrayList<String> shuffledCopy(ArrayList<String> words, Random random) {
        return words;
    }
}
