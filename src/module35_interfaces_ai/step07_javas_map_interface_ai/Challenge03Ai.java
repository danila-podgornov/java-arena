// AI-Generated
package module35_interfaces_ai.step07_javas_map_interface_ai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Challenge03Ai {
    /**
     * The bakery lets its customers vote for next month's special bread. Write the method {@code countVotes(List<String> votes)}, which returns a {@code Map<String, Integer>} from each kind of bread to the number of votes it got. The check runs:
     * <pre>{@code
     * List<String> votes = new ArrayList<>();
     * votes.add("walnut");
     * votes.add("olive");
     * votes.add("walnut");
     * Map<String, Integer> counts = countVotes(votes);
     * System.out.println(counts.get("walnut") + " " + counts.get("olive"));
     * System.out.println(counts.size());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 2 1
     * 2
     * }</pre>
     * Hints
     * 1. The header is {@code public static Map<String, Integer> countVotes(List<String> votes)}. Inside, make {@code Map<String, Integer> counts = new HashMap<>();} and return it at the end.
     * 2. For each vote, count as module 31 did: {@code counts.put(vote, counts.getOrDefault(vote, 0) + 1);}.
     */
    public static void main(String[] args) {
        List<String> votes = new ArrayList<>();
        votes.add("walnut");
        votes.add("olive");
        votes.add("walnut");
        Map<String, Integer> counts = countVotes(votes);
        System.out.println(counts.get("walnut") + " " + counts.get("olive"));
        System.out.println(counts.size());
    }

    // Write the method countVotes here.
}
