// AI-Generated
package module41_packages_and_imports_ai.step04_packages_by_responsibility_ai.challenge01_ai;

import module41_packages_and_imports_ai.step04_packages_by_responsibility_ai.challenge01_ai.foodtruck.domain.Dish;
import module41_packages_and_imports_ai.step04_packages_by_responsibility_ai.challenge01_ai.foodtruck.logic.Order;

public class Main {
    /**
     * A food truck's program has the package {@code foodtruck.domain}, with the class {@code Dish}, ready: a dish has a name and a price in whole dollars, with {@code getName()}, {@code getPrice()} and a {@code toString()} like {@code Taco (4 dollars)}. In {@code foodtruck/logic/Order.java}, write the logic class {@code Order}, in the package {@code foodtruck.logic}:
     * <ul>
     * <li>a constructor {@code Order()}, which makes an empty order
     * <li>{@code add(Dish dish)}, which adds a dish to the order (the same dish can be ordered several times)
     * <li>{@code count()}, which returns the number of dishes in the order
     * <li>{@code total()}, which returns the total price of the order
     * <li>{@code mostExpensive()}, which returns the most expensive dish of the order (the first one ordered, if several cost the most), or {@code null} for an empty order
     * </ul>
     * <p>Order is logic: it returns values and prints nothing. The check runs:
     * <pre>{@code
     * Order order = new Order();
     * order.add(new Dish("Taco", 4));
     * order.add(new Dish("Burrito", 9));
     * order.add(new Dish("Taco", 4));
     * System.out.println(order.count() + " dishes, " + order.total() + " dollars");
     * System.out.println("Most expensive: " + order.mostExpensive());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 3 dishes, 17 dollars
     * Most expensive: Burrito (9 dollars)
     * }</pre>
     * Hints
     * 1. The file starts with {@code package foodtruck.logic;} and imports {@code java.util.ArrayList} and {@code foodtruck.domain.Dish}. The order keeps its dishes in an {@code ArrayList<Dish>}, made in the constructor.
     * 2. For {@code mostExpensive}, start with {@code Dish most = null;} and go through the dishes: a dish replaces {@code most} when {@code most} is still {@code null} or the dish costs more. Use {@code >}, not {@code >=}, so that the first of two equal prices stays.
     */
    public static void main(String[] args) {
        Order order = new Order();
        order.add(new Dish("Taco", 4));
        order.add(new Dish("Burrito", 9));
        order.add(new Dish("Taco", 4));
        System.out.println(order.count() + " dishes, " + order.total() + " dollars");
        System.out.println("Most expensive: " + order.mostExpensive());
    }
}
