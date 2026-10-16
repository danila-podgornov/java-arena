// AI-Generated
package module24_lists_inside_objects_ai.step06_clearing_and_removing_ai.challenge01_ai;

import java.util.ArrayList;

public class Fridge {
    private ArrayList<Food> foods;

    public Fridge() {
        this.foods = new ArrayList<>();
    }

    public void put(Food food) {
        this.foods.add(food);
    }

    // Write the throwOutOld method here.

    public String toString() {
        return "Fridge: " + this.foods;
    }
}
