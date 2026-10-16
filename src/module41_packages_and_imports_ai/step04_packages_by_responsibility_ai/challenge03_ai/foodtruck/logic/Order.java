// AI-Generated
package module41_packages_and_imports_ai.step04_packages_by_responsibility_ai.challenge03_ai.foodtruck.logic;

import java.util.ArrayList;
import module41_packages_and_imports_ai.step04_packages_by_responsibility_ai.challenge03_ai.foodtruck.domain.Dish;

public class Order {
    private ArrayList<Dish> dishes;

    public Order() {
        this.dishes = new ArrayList<>();
    }

    public void add(Dish dish) {
        this.dishes.add(dish);
    }

    public int count() {
        return this.dishes.size();
    }

    public int total() {
        int total = 0;
        for (Dish dish : this.dishes) {
            total += dish.getPrice();
        }
        return total;
    }

    public Dish mostExpensive() {
        Dish most = null;
        for (Dish dish : this.dishes) {
            if (most == null || dish.getPrice() > most.getPrice()) {
                most = dish;
            }
        }
        return most;
    }
}
