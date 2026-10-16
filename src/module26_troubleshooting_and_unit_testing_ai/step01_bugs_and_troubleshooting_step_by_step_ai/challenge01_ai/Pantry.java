// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step01_bugs_and_troubleshooting_step_by_step_ai.challenge01_ai;

import java.util.ArrayList;

public class Pantry {
    private ArrayList<Supply> supplies;

    public Pantry() {
        this.supplies = new ArrayList<>();
    }

    public void add(Supply supply) {
        this.supplies.add(supply);
    }

    public Supply find(String food) {
        for (Supply supply : this.supplies) {
            if (supply.getFood().equals(food)) {
                return supply;
            }
        }
        return null;
    }

    public int gramsOf(String food) {
        return this.find(food).getGrams();
    }
}
