// AI-Generated
package module38_ordering_objects_comparable_and_comparator_ai.step02_comparator_an_order_given_to_the_sort_ai.challenge01_ai;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * A podcast app plays the short episodes first. {@code Episode.java} is ready: an episode has a title and a length in minutes, and no {@code compareTo}. In {@code Main.java}, write the method {@code sortShortestFirst(List<Episode> episodes)}, which sorts the list, the shortest episode first. Episodes of the same length keep the order they had in the list. Use the list's own {@code sort} with a lambda of two episodes: {@code episodes.sort((a, b) -> ...)}. The check runs:
     * <pre>{@code
     * List<Episode> queue = new ArrayList<>();
     * queue.add(new Episode("The deep sea", 48));
     * queue.add(new Episode("Tiny houses", 22));
     * queue.add(new Episode("Night trains", 35));
     * sortShortestFirst(queue);
     * System.out.println(queue);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code [Tiny houses (22 min), Night trains (35 min), The deep sea (48 min)]}
     * Hints
     * 1. The header is {@code public static void sortShortestFirst(List<Episode> episodes)}. It returns nothing: {@code sort} changes the list it's called on.
     * 2. The lambda gets two episodes and compares their lengths: {@code episodes.sort((a, b) -> Integer.compare(a.getMinutes(), b.getMinutes()));}.
     */
    public static void main(String[] args) {
        List<Episode> queue = new ArrayList<>();
        queue.add(new Episode("The deep sea", 48));
        queue.add(new Episode("Tiny houses", 22));
        queue.add(new Episode("Night trains", 35));
        sortShortestFirst(queue);
        System.out.println(queue);
    }

    // Write the method sortShortestFirst here.
}
