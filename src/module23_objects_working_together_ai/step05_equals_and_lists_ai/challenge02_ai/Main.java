// AI-Generated
package module23_objects_working_together_ai.step05_equals_and_lists_ai.challenge02_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * The lost and found keeps the things people have left behind in a list, and {@code Item.java} (with {@code equals}) is ready. In {@code Main.java}, read lines such as {@code red scarf} (a color and a thing) until an empty line. For each, make an {@code Item}. If an equal item is in the list, remove it from the list and print {@code Returned: } and the item; if not, print {@code No } and the item and {@code  here}. At the end, print how many items are left. Let {@code contains} and {@code remove} do the searching, without a loop over the list. For the input shown below, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Returned: red scarf
     * No green hat here
     * Returned: red scarf
     * No red scarf here
     * Items left: 2
     * }</pre>
     * Hints
     * 1. Read in a {@code while (true)} loop that breaks at the empty line. Split each line at the space and make the item: {@code Item item = new Item(parts[0], parts[1]);}.
     * 2. {@code if (found.contains(item))}, then {@code found.remove(item);} and print {@code "Returned: " + item}. The new item isn't the object in the list, but it's equal to it, and that's all {@code contains} and {@code remove} need.
     */
    public static void main(String[] args) {
        ArrayList<Item> found = new ArrayList<>();
        found.add(new Item("blue", "umbrella"));
        found.add(new Item("red", "scarf"));
        found.add(new Item("black", "glove"));
        found.add(new Item("red", "scarf"));

        Scanner scanner = new Scanner(System.in);

    }
}
