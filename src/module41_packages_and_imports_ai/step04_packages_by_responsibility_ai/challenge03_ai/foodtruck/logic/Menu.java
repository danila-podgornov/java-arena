// AI-Generated
package module41_packages_and_imports_ai.step04_packages_by_responsibility_ai.challenge03_ai.foodtruck.logic;

import java.util.ArrayList;
import module41_packages_and_imports_ai.step04_packages_by_responsibility_ai.challenge03_ai.foodtruck.domain.Dish;

public class Menu {
    private ArrayList<Dish> dishes;

    public Menu() {
        this.dishes = new ArrayList<>();
    }

    public void add(Dish dish) {
        this.dishes.add(dish);
    }

    public Dish find(String name) {
        for (Dish dish : this.dishes) {
            if (dish.getName().equalsIgnoreCase(name)) {
                return dish;
            }
        }
        return null;
    }
}
