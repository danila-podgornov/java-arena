// AI-Generated
package module35_interfaces_ai.step08_javas_set_interface_and_hashset_ai;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Challenge01Ai {
    /**
     * Write the method {@code countDevices(List<String> reports)}, which returns how many different devices are in a log of reports. Use a HashSet. The check runs:
     * <pre>{@code
     * List<String> reports = new ArrayList<>();
     * reports.add("heater");
     * reports.add("doorbell");
     * reports.add("heater");
     * reports.add("fan");
     * reports.add("heater");
     * System.out.println(countDevices(reports));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code 3}
     * Hints
     * 1. The header is {@code public static int countDevices(List<String> reports)}. Make a {@code Set<String> devices = new HashSet<>();}, and add every report to it.
     * 2. The set keeps each device once, whatever you add, so the answer is {@code devices.size()}.
     */
    public static void main(String[] args) {
        List<String> reports = new ArrayList<>();
        reports.add("heater");
        reports.add("doorbell");
        reports.add("heater");
        reports.add("fan");
        reports.add("heater");
        System.out.println(countDevices(reports));
    }

    // Write the method countDevices here.
}
