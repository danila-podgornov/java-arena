// AI-Generated
package module41_packages_and_imports_ai.step04_packages_by_responsibility_ai.challenge03_ai;

import java.util.Scanner;
import module41_packages_and_imports_ai.step04_packages_by_responsibility_ai.challenge03_ai.foodtruck.domain.Dish;
import module41_packages_and_imports_ai.step04_packages_by_responsibility_ai.challenge03_ai.foodtruck.logic.Menu;
import module41_packages_and_imports_ai.step04_packages_by_responsibility_ai.challenge03_ai.foodtruck.logic.Order;
import module41_packages_and_imports_ai.step04_packages_by_responsibility_ai.challenge03_ai.foodtruck.ui.TextUI;

public class Main {
    /**
     * The food truck gets its user interface. {@code Dish.java} and {@code Order.java} are the ones from the first task, and {@code Menu.java}, in {@code foodtruck.logic}, is ready: {@code add(Dish dish)} puts a dish on the menu, and {@code find(String name)} returns the dish of that name, with capital letters or not, or {@code null} if the menu has none. {@code Main.java} is ready too.
     * <p>In {@code foodtruck/ui/TextUI.java}, write the class {@code TextUI}, in the package {@code foodtruck.ui}, with the imports it needs. Its constructor takes a {@code Scanner}, a {@code Menu} and an {@code Order}, and its method {@code start()} reads commands, with the prompt {@code > } before each one:
     * <ul>
     * <li>{@code order}: the next line is the name of a dish. If the menu has it, add it to the order and print {@code Added } and the dish, like {@code Added Taco (4 dollars)}. Otherwise print {@code Not on the menu: } and the name.
     * <li>{@code total}: print the number of dishes and the total, like {@code 3 dishes, 17 dollars}.
     * <li>{@code done}: print {@code Thank you! You pay } and the total and {@code  dollars}, and return.
     * <li>Anything else: print {@code Unknown command: } and the command.
     * </ul>
     * <p>For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Added Taco (4 dollars)
     * > Added Burrito (9 dollars)
     * > Not on the menu: Pizza
     * > Added Taco (4 dollars)
     * > 3 dishes, 17 dollars
     * > Thank you! You pay 17 dollars
     * }</pre>
     * Hints
     * 1. TextUI uses four classes from other packages: {@code java.util.Scanner}, {@code foodtruck.domain.Dish}, {@code foodtruck.logic.Menu} and {@code foodtruck.logic.Order}. Import each, then keep the three constructor parameters in instance variables.
     * 2. For {@code order}, ask the menu first: {@code Dish dish = this.menu.find(name);}. If {@code dish} is {@code null}, print the message about the menu; otherwise add it with {@code this.order.add(dish)} and print {@code "Added " + dish}.
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.add(new Dish("Taco", 4));
        menu.add(new Dish("Burrito", 9));
        menu.add(new Dish("Nachos", 6));
        TextUI ui = new TextUI(new Scanner(System.in), menu, new Order());
        ui.start();
    }
}
