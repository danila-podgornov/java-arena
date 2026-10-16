// AI-Generated
package module14_for_each_list_methods_and_lists_in_methods_ai.step06_one_list_two_names_ai;

import java.util.ArrayList;

public class Challenge01Ai {
    /**
     * What does this program print? Count how many lists there really are.
     * Hints
     * 1. {@code other = plan} gives the one list a second name. {@code new ArrayList<>(plan)} makes a separate list with {@code swim} and {@code run}.
     * 2. Adding {@code bike} through {@code other} changes {@code plan} too. Removing index 0 from {@code backup} changes only the copy.
     */
    public static void main(String[] args) {
        ArrayList<String> plan = new ArrayList<>();
        plan.add("swim");
        plan.add("run");
        ArrayList<String> other = plan;
        ArrayList<String> backup = new ArrayList<>(plan);
        other.add("bike");
        backup.remove(0);
        System.out.println(plan);
        System.out.println(other);
        System.out.println(backup);
    }
}
