// AI-Generated
package module13_lists_ai.step03_getting_values_by_index_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Challenge03Ai {
    /**
     * Four people stand in line. Read their names, one per line, into a list (the starter code does this). Then read a place in line, counted the way people count it (1 is the front), and print who stands there. For the input {@code Ada}, {@code Ben}, {@code Cai}, {@code Dev} and {@code 2} the program prints: see the expected output below.
     * Expected output
     * {@code Place 2: Ben}
     * Hints
     * 1. Place 1 is index 0, and place 2 is index 1: the index is one less than the place.
     * 2. {@code queue.get(place - 1)} is the person at that place.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> queue = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            queue.add(scanner.nextLine());
        }
        int place = Integer.valueOf(scanner.nextLine());

    }
}
