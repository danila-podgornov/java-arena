// AI-Generated
package module46_random_numbers_ai.step05_simulations_and_checking_random_results_ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Challenge02Ai {
    /**
     * {@code Collections.shuffle} only changes the order of a list. What does this program print?
     * Hints
     * 1. The deck is a copy of the cards 10, 20, 30, 40 and 50, in some new order. The order changes, but not which numbers there are, nor how many.
     * 2. After sorting, the deck is in increasing order again, just like {@code cards}, and {@code equals} compares two lists element by element.
     */
    public static void main(String[] args) {
        ArrayList<Integer> cards = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            cards.add(i * 10);
        }
        ArrayList<Integer> deck = new ArrayList<>(cards);
        Collections.shuffle(deck, new Random(9));
        int sum = 0;
        for (int card : deck) {
            sum += card;
        }
        System.out.println(deck.size() + " " + sum);
        System.out.println(deck.contains(30) + " " + deck.contains(60));
        Collections.sort(deck);
        System.out.println(deck.equals(cards));
    }
}
