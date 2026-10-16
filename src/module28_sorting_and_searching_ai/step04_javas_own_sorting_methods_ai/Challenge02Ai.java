// AI-Generated
package module28_sorting_and_searching_ai.step04_javas_own_sorting_methods_ai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Challenge02Ai {
    /**
     * What does this program print? It sorts the same three numbers twice, once as ints and once as Strings, and then a list of words.
     * Hints
     * 1. The ints sort by their value. The Strings sort character by character, from the first one, and the character {@code 1} comes before {@code 9}. {@code "10"} is the start of {@code "100"}, so it comes first.
     * 2. Capital letters come before small ones, so the words that start with a capital come first, in alphabetical order among themselves, and then the others.
     */
    public static void main(String[] args) {
        int[] sizes = {10, 9, 100};
        Arrays.sort(sizes);
        System.out.println(Arrays.toString(sizes));

        String[] codes = {"10", "9", "100"};
        Arrays.sort(codes);
        System.out.println(Arrays.toString(codes));

        ArrayList<String> fruit = new ArrayList<>();
        fruit.add("pear");
        fruit.add("Plum");
        fruit.add("apple");
        fruit.add("Fig");
        Collections.sort(fruit);
        System.out.println(fruit);
    }
}
