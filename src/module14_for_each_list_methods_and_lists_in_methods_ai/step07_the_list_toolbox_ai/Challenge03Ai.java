// AI-Generated
package module14_for_each_list_methods_and_lists_in_methods_ai.step07_the_list_toolbox_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Challenge03Ai {
    /**
     * Write a shopping list program that reads commands until {@code quit}. The commands {@code add} and {@code remove} are followed by a line with an item.
     * <ul>
     * <li>{@code add}: add the item and print {@code Added } and the item. If it's already on the list, print {@code bread is already on the list} (with the item's name) instead.
     * <li>{@code remove}: remove the item and print {@code Removed } and the item. If it isn't on the list, print {@code cheese is not on the list} (with the item's name) instead.
     * <li>{@code show}: print each item as {@code - } and the item, with a for-each loop, or {@code The list is empty} when there's nothing on it.
     * <li>{@code quit}: print {@code Bye!} and stop.
     * </ul>
     * <p>For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Added bread
     * Added apples
     * bread is already on the list
     * cheese is not on the list
     * Removed bread
     * - apples
     * Bye!
     * }</pre>
     * Hints
     * 1. One {@code if} per command. For {@code add} and {@code remove}, read the item with another {@code scanner.nextLine()} inside that branch.
     * 2. {@code items.contains(item)} decides between the two messages of {@code add}, and of {@code remove}. For {@code show}, {@code items.isEmpty()} tells when to print {@code The list is empty}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> items = new ArrayList<>();
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Bye!");
                break;
            }
            // Handle add, remove and show here.
        }
    }
}
