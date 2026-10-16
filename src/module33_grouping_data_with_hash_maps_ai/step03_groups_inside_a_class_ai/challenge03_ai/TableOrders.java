// AI-Generated
package module33_grouping_data_with_hash_maps_ai.step03_groups_inside_a_class_ai.challenge03_ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TableOrders {
    private HashMap<Integer, ArrayList<String>> orders;

    public TableOrders() {
        this.orders = new HashMap<>();
    }

    public void add(int table, String dish) {
        if (!this.orders.containsKey(table)) {
            this.orders.put(table, new ArrayList<>());
        }
        this.orders.get(table).add(dish);
    }

    public ArrayList<String> dishesAt(int table) {
        return this.orders.getOrDefault(table, new ArrayList<>());
    }

    public ArrayList<Integer> tables() {
        ArrayList<Integer> tables = new ArrayList<>(this.orders.keySet());
        Collections.sort(tables);
        return tables;
    }

    // Write the methods countOf and tablesWith here.
}
