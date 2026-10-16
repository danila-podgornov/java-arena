// AI-Generated
package module35_interfaces_ai.step08_javas_set_interface_and_hashset_ai;

import java.util.HashSet;
import java.util.Set;

public class Challenge02Ai {
    /**
     * The door of a conference hall scans each visitor's badge number, every time the visitor comes in. What does this program print?
     * Hints
     * 1. {@code add} returns {@code false} when the number is in the set already, and then {@code repeats} goes up.
     * 2. The first 105, 212 and 330 are new; the other three scans are repeats, and the set holds three numbers. A set has no indexes, so {@code remove(212)} removes the value 212, not index 212. Then {@code contains(212)} is false, while 330 is still there.
     */
    public static void main(String[] args) {
        Set<Integer> badges = new HashSet<>();
        int[] scans = {105, 212, 105, 330, 212, 105};
        int repeats = 0;
        for (int scan : scans) {
            if (!badges.add(scan)) {
                repeats++;
            }
        }
        System.out.println(badges.size() + " " + repeats);
        badges.remove(212);
        System.out.println(badges.contains(212) + " " + badges.contains(330));
    }
}
