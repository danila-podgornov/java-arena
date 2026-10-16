// AI-Generated
package module15_arrays_ai.step06_the_short_way_to_create_an_array_ai;

import java.util.Arrays;

public class Challenge02Ai {
    /**
     * A form stores its answers in an array of Strings, and a question left unanswered is the empty String {@code ""}. Write a method {@code withoutBlanks(String[] answers)} that returns a <b>new</b> array holding only the answers that aren't empty, in the same order. An array can't grow, so count those answers first, and then create an array of exactly that size. The check passes the array {@code {"red", "", "green", "", "blue"}} and prints what your method returns with {@code Arrays.toString}: see the expected output below.
     * Expected output
     * {@code [red, green, blue]}
     * Hints
     * 1. The method starts <code>public static String[] withoutBlanks(String[] answers) {</code>. A first loop counts the answers where {@code !answer.equals("")}, and then {@code String[] result = new String[count];} makes the new array.
     * 2. A second loop copies each answer that isn't empty to {@code result[next]}, and then adds one to {@code next}, the index where the next answer goes.
     */
    public static void main(String[] args) {
        String[] answers = {"red", "", "green", "", "blue"};
        System.out.println(Arrays.toString(withoutBlanks(answers)));
    }

    // Write the withoutBlanks method here.
}
