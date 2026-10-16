// AI-Generated
package module35_interfaces_ai.step06_javas_list_interface_ai;

import java.util.ArrayList;
import java.util.List;

public class Challenge03Ai {
    /**
     * For the return trip, write the method {@code reversed(List<String> stops)}, which returns a new list with the same stops in the opposite order. Its return type is {@code List<String>}. The list it gets must stay as it was. The check runs:
     * <pre>{@code
     * List<String> there = new ArrayList<>();
     * there.add("Harbor");
     * there.add("Old Mill");
     * there.add("Museum");
     * List<String> back = reversed(there);
     * System.out.println(back);
     * System.out.println(there);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * [Museum, Old Mill, Harbor]
     * [Harbor, Old Mill, Museum]
     * }</pre>
     * Hints
     * 1. The header is {@code public static List<String> reversed(List<String> stops)}. Make a new list inside, {@code List<String> result = new ArrayList<>();}, and return it at the end.
     * 2. Go through {@code stops} from the last index, {@code stops.size() - 1}, down to 0, and add each stop to {@code result}. Don't change {@code stops} itself.
     */
    public static void main(String[] args) {
        List<String> there = new ArrayList<>();
        there.add("Harbor");
        there.add("Old Mill");
        there.add("Museum");
        List<String> back = reversed(there);
        System.out.println(back);
        System.out.println(there);
    }

    // Write the method reversed here.
}
