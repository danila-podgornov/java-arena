// AI-Generated
package module24_lists_inside_objects_ai.step05_printing_an_object_that_holds_a_list_ai.challenge02_ai;

import java.util.ArrayList;

public class Necklace {
    private ArrayList<String> beads;

    public Necklace() {
        this.beads = new ArrayList<>();
    }

    public void add(String color) {
        this.beads.add(color);
    }

    public int size() {
        return this.beads.size();
    }

    public String toString() {
        String text = "";
        for (int i = 0; i < this.beads.size(); i++) {
            if (i > 0) {
                text = text + "-";
            }
            text = text + this.beads.get(i);
        }
        return "(" + text + ")";
    }
}
