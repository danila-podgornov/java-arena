// AI-Generated
package module24_lists_inside_objects_ai.step09_rules_the_owner_enforces_ai.challenge02_ai;

import java.util.ArrayList;

public class Main {
    /**
     * What does this program print? The dinner table lets a guest sit only when there's a free chair, but it also has a getter that returns its list.
     * Hints
     * 1. {@code seat} checks the chairs: Ada and Ben get the two chairs, and Cleo is turned away.
     * 2. {@code getGuests()} returns a reference to the table's own list, not a copy. So {@code guests.add("Dan")} adds Dan to the table's list, and {@code seat}'s rule is never asked.
     */
    public static void main(String[] args) {
        DinnerTable table = new DinnerTable(2);
        System.out.println(table.seat("Ada"));
        System.out.println(table.seat("Ben"));
        System.out.println(table.seat("Cleo"));
        ArrayList<String> guests = table.getGuests();
        guests.add("Dan");
        System.out.println(table);
    }
}
