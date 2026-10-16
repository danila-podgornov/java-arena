// AI-Generated
package module35_interfaces_ai.step08_javas_set_interface_and_hashset_ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Challenge03Ai {
    /**
     * Write the method {@code reportedTwice(List<String> reports)}, which returns a list of the devices that reported in more than once, each device once, in alphabetical order. Use two HashSets: one for the devices seen so far, and one for those seen again. The check runs:
     * <pre>{@code
     * List<String> reports = new ArrayList<>();
     * reports.add("sprinkler");
     * reports.add("heater");
     * reports.add("camera");
     * reports.add("heater");
     * reports.add("sprinkler");
     * reports.add("heater");
     * System.out.println(reportedTwice(reports));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code [heater, sprinkler]}
     * Hints
     * 1. Go through the reports. When a device is in {@code seen} already (or when {@code seen.add(device)} returns {@code false}), add it to the second set, {@code again}. The heater gets added to {@code again} twice, but a set keeps it once.
     * 2. At the end, copy {@code again} into a list with {@code new ArrayList<>(again)}, sort it with {@code Collections.sort}, and return the list.
     */
    public static void main(String[] args) {
        List<String> reports = new ArrayList<>();
        reports.add("sprinkler");
        reports.add("heater");
        reports.add("camera");
        reports.add("heater");
        reports.add("sprinkler");
        reports.add("heater");
        System.out.println(reportedTwice(reports));
    }

    // Write the method reportedTwice here.
}
