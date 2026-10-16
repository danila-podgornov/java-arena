// AI-Generated
package module23_objects_working_together_ai.step05_equals_and_lists_ai.challenge01_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * At a bakery, the orders waiting to be picked up are in a list, in the order they were placed. {@code Main.java} is ready: it reads pick-ups such as {@code Ben bagel} (a customer and an item) until an empty line. For each one, it looks for the order's place in line with {@code indexOf}, prints it, and takes the order out of the list with {@code remove}. But no order is ever found, because {@code Order} has no {@code equals} of its own. Write {@code equals} in {@code Order.java}: two orders are equal when they're for the same customer and the same item. For the input shown below, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Picked up: bagel for Ben, number 2 in line
     * No order: muffin for Ada
     * Picked up: bagel for Di, number 3 in line
     * Still waiting: [croissant for Ada, muffin for Cy]
     * }</pre>
     * Hints
     * 1. {@code indexOf} and {@code remove} call {@code equals}, so {@code Main} needs no change. Once {@code Order} has an {@code equals} that compares the customer and the item, they find the order in the list that's equal to the one typed in.
     * 2. Write it as in the previous step: {@code public boolean equals(Object compared)}, the {@code this ==} check, {@code instanceof Order}, the cast, and {@code return this.customer.equals(other.customer) && this.item.equals(other.item);}.
     */
    public static void main(String[] args) {
        ArrayList<Order> waiting = new ArrayList<>();
        waiting.add(new Order("Ada", "croissant"));
        waiting.add(new Order("Ben", "bagel"));
        waiting.add(new Order("Cy", "muffin"));
        waiting.add(new Order("Di", "bagel"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            String[] parts = line.split(" ");
            Order order = new Order(parts[0], parts[1]);
            int place = waiting.indexOf(order);
            if (place == -1) {
                System.out.println("No order: " + order);
            } else {
                System.out.println("Picked up: " + order + ", number " + (place + 1) + " in line");
                waiting.remove(order);
            }
        }
        System.out.println("Still waiting: " + waiting);
    }
}
