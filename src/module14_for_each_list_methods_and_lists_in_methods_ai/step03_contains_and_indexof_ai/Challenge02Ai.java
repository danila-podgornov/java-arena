// AI-Generated
package module14_for_each_list_methods_and_lists_in_methods_ai.step03_contains_and_indexof_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Challenge02Ai {
    /**
     * The list {@code finishers} holds the runners of a race in the order they finished. Read a name and print the place that runner finished in (the winner is place 1), or say they're not in the results. Use {@code indexOf}, without a loop. For the input {@code Kim} the program prints:
     * {@code Kim finished in place 3}
     * <p>and for the input {@code Otto} it prints {@code Otto is not in the results}.
     * Hints
     * 1. {@code int index = finishers.indexOf(name);} and then an {@code if} on {@code index == -1}.
     * 2. Indexes start at 0 and places at 1, so the place is {@code index + 1}. Put it in parentheses in the print line.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> finishers = new ArrayList<>();
        finishers.add("Mona");
        finishers.add("Raj");
        finishers.add("Kim");
        finishers.add("Lea");

        String name = scanner.nextLine();

    }
}
