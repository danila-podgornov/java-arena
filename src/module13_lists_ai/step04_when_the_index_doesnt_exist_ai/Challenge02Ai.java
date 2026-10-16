// AI-Generated
package module13_lists_ai.step04_when_the_index_doesnt_exist_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Challenge02Ai {
    /**
     * The cafeteria's menu has a dish for each index from 0 to 4. The program reads an index and prints that dish, but it crashes for an index outside the menu. Add a check: for an index from 0 to 4, print the dish as before; for any other index, print {@code No dish at index} and the index. For the input {@code 7} the program prints:
     * {@code No dish at index 7}
     * <p>For the input {@code 2} it prints {@code Dish: curry}.
     * Hints
     * 1. An index works when it's at least 0 and at most 4: {@code index >= 0 && index <= 4}.
     * 2. Put the {@code get} line inside the {@code if}, and the {@code No dish} line in the {@code else}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> menu = new ArrayList<>();
        menu.add("soup");
        menu.add("pasta");
        menu.add("curry");
        menu.add("tacos");
        menu.add("salad");
        int index = Integer.valueOf(scanner.nextLine());
        System.out.println("Dish: " + menu.get(index));
    }
}
