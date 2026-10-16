// AI-Generated
package module35_interfaces_ai.step06_javas_list_interface_ai;

import java.util.ArrayList;
import java.util.List;

public class Challenge02Ai {
    /**
     * What does this program print?
     * Hints
     * 1. {@code remove(value)} takes out only the first copy of the value, so the second Mill stays, at the end.
     * 2. {@code addDepot} gets the same list object, not a copy (module 14), so the Depot it puts at index 0 is in {@code line} too.
     */
    public static void main(String[] args) {
        List<String> line = new ArrayList<>();
        line.add("Harbor");
        line.add("Mill");
        line.add("Museum");
        line.add("Mill");
        line.remove("Mill");
        System.out.println(line);
        System.out.println(line.indexOf("Mill") + " " + line.size());
        addDepot(line);
        System.out.println(line.get(0) + " " + line.contains("Depot"));
    }

    public static void addDepot(List<String> stops) {
        stops.add(0, "Depot");
    }
}
