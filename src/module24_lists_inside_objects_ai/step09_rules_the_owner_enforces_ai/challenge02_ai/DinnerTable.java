// AI-Generated
package module24_lists_inside_objects_ai.step09_rules_the_owner_enforces_ai.challenge02_ai;

import java.util.ArrayList;

public class DinnerTable {
    private int chairs;
    private ArrayList<String> guests;

    public DinnerTable(int chairs) {
        this.chairs = chairs;
        this.guests = new ArrayList<>();
    }

    public boolean seat(String guest) {
        if (this.guests.size() >= this.chairs) {
            return false;
        }
        this.guests.add(guest);
        return true;
    }

    public ArrayList<String> getGuests() {
        return this.guests;
    }

    public String toString() {
        return this.guests.size() + " guests, " + this.chairs + " chairs: " + this.guests;
    }
}
