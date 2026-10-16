// AI-Generated
package module14_for_each_list_methods_and_lists_in_methods_ai.step04_removing_values_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Challenge03Ai {
    /**
     * The list {@code taken} holds the numbers of the taken spots in a parking garage. Read the spot numbers of cars that leave until {@code 0}, and remove each one from the list by its value. Then print what's still taken. For the input {@code 3} and {@code 25} the program prints: see the expected output below.
     * Expected output
     * {@code Still taken: [12, 7, 1]}
     * Hints
     * 1. A reading loop that stops at 0, and removes each spot it reads.
     * 2. {@code taken.remove(spot)} with an {@code int} would remove an index. Remove the value: {@code taken.remove(Integer.valueOf(spot));}
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> taken = new ArrayList<>();
        taken.add(12);
        taken.add(3);
        taken.add(7);
        taken.add(25);
        taken.add(1);

    }
}
