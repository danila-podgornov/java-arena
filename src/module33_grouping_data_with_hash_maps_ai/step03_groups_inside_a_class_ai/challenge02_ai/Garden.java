// AI-Generated
package module33_grouping_data_with_hash_maps_ai.step03_groups_inside_a_class_ai.challenge02_ai;

import java.util.ArrayList;
import java.util.HashMap;

public class Garden {
    private HashMap<String, ArrayList<String>> beds;

    public Garden() {
        this.beds = new HashMap<>();
    }

    public void plant(String bed, String plant) {
        if (!this.beds.containsKey(bed)) {
            this.beds.put(bed, new ArrayList<>());
        }
        this.beds.get(bed).add(plant);
    }

    public ArrayList<String> plantsIn(String bed) {
        return this.beds.getOrDefault(bed, new ArrayList<>());
    }

    public int totalPlants() {
        int total = 0;
        for (ArrayList<String> plants : this.beds.values()) {
            total += plants.size();
        }
        return total;
    }

    public int bedCount() {
        return this.beds.size();
    }
}
