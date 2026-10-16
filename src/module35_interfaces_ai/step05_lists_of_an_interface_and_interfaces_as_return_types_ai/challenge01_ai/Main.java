// AI-Generated
package module35_interfaces_ai.step05_lists_of_an_interface_and_interfaces_as_return_types_ai.challenge01_ai;

import java.util.ArrayList;

public class Main {
    /**
     * Write the method {@code find(ArrayList<Playable> queue, String title)}, which returns the item in the queue with that title, or {@code null} if there's none. If several items have the title, return the first of them. {@code Playable.java}, {@code VoiceMemo.java} and {@code RadioShow.java} are ready. The check runs:
     * <pre>{@code
     * ArrayList<Playable> queue = new ArrayList<>();
     * queue.add(new VoiceMemo("Groceries", 45));
     * queue.add(new RadioShow("Morning News", 5));
     * Playable found = find(queue, "Morning News");
     * found.play();
     * System.out.println(found.seconds());
     * System.out.println(find(queue, "Weather") == null);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * On air: Morning News
     * 300
     * true
     * }</pre>
     * Hints
     * 1. The header is {@code public static Playable find(ArrayList<Playable> queue, String title)}. Go through the queue with a for-each loop, and compare each item's {@code title()} with {@code equals}.
     * 2. Return the item as soon as its title matches: that makes the first match win. After the loop, nothing matched, so {@code return null;}.
     */
    public static void main(String[] args) {
        ArrayList<Playable> queue = new ArrayList<>();
        queue.add(new VoiceMemo("Groceries", 45));
        queue.add(new RadioShow("Morning News", 5));
        Playable found = find(queue, "Morning News");
        found.play();
        System.out.println(found.seconds());
        System.out.println(find(queue, "Weather") == null);
    }

    // Write the method find here.
}
