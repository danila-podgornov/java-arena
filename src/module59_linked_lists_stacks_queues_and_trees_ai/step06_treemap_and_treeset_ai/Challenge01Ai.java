// AI-Generated
package module59_linked_lists_stacks_queues_and_trees_ai.step06_treemap_and_treeset_ai;

import java.util.Scanner;
import java.util.TreeMap;

public class Challenge01Ai {
    /**
     * Count the words of a text and print them in alphabetical order. The program reads lines until the line {@code end}. Each line has words separated by single spaces. It counts each word in small letters, so {@code The} and {@code the} are the same word, and then prints each word and its count, like {@code the: 3}, in alphabetical order. Use a TreeMap. With this input:
     * <p>Input
     * <pre>{@code
     * the cat saw the dog
     * The dog ran
     * end
     * }</pre>
     * <p>the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * cat: 1
     * dog: 2
     * ran: 1
     * saw: 1
     * the: 3
     * }</pre>
     * Hints
     * 1. Split each line with {@code line.split(" ")}, and count {@code word.toLowerCase()} in a {@code TreeMap<String, Integer>}: {@code counts.put(word, counts.getOrDefault(word, 0) + 1);}.
     * 2. After the loop, {@code for (String word : counts.keySet())} goes through the words in alphabetical order, since the TreeMap keeps its keys sorted.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
}
