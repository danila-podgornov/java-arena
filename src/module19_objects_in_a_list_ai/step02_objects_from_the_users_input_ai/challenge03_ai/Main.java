// AI-Generated
package module19_objects_in_a_list_ai.step02_objects_from_the_users_input_ai.challenge03_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * This program should read wishes until an empty line, then print how many there are and each one. But for the input {@code a bike}, {@code a kite} and an empty line, it says {@code 3 wishes}, and its last line is {@code I wish for} with nothing after it. Fix it, so the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * 2 wishes
     * I wish for a bike
     * I wish for a kite
     * }</pre>
     * Hints
     * 1. Follow the empty line through the loop: it's added to the list as a wish before the {@code if} stops the loop.
     * 2. Move {@code wishes.add(new Wish(thing));} below the {@code if}, so the loop stops before the empty line becomes a wish.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Wish> wishes = new ArrayList<>();

        while (true) {
            String thing = scanner.nextLine();
            wishes.add(new Wish(thing));
            if (thing.isEmpty()) {
                break;
            }
        }

        System.out.println(wishes.size() + " wishes");
        for (Wish wish : wishes) {
            System.out.println(wish);
        }
    }
}
