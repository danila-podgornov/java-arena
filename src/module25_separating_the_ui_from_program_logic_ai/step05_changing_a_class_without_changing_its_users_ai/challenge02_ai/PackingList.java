// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step05_changing_a_class_without_changing_its_users_ai.challenge02_ai;

import java.util.ArrayList;

public class PackingList {
    private ArrayList<String> names;
    private ArrayList<Integer> grams;

    public PackingList() {
        this.names = new ArrayList<>();
        this.grams = new ArrayList<>();
    }

    public void add(String name, int grams) {
        this.names.add(name);
        this.grams.add(grams);
    }

    public int totalGrams() {
        int total = 0;
        for (int weight : this.grams) {
            total = total + weight;
        }
        return total;
    }

    public String heaviest() {
        if (this.names.isEmpty()) {
            return "nothing";
        }
        int best = 0;
        for (int i = 1; i < this.names.size(); i++) {
            if (this.grams.get(i) > this.grams.get(best)) {
                best = i;
            }
        }
        return this.names.get(best);
    }
}
