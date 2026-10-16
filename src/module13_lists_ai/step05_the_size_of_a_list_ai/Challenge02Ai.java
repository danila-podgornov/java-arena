// AI-Generated
package module13_lists_ai.step05_the_size_of_a_list_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Challenge02Ai {
    /**
     * The block party is held in front of the house in the middle of the block. Read the house numbers along the block, in order, one per line, until {@code 0}. Keep them in a list. Then print {@code Houses: } and how many there are, and on the next line {@code Party at number } and the number of the middle house. With an even number of houses, take the later of the two in the middle. When no houses were read, print {@code Houses: 0} and then {@code No party}. For the input {@code 101}, {@code 103}, {@code 105}, {@code 107}, {@code 109} and {@code 0} the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Houses: 5
     * Party at number 105
     * }</pre>
     * Hints
     * 1. After the loop, {@code houses.size()} is the number of houses. Check that it's above 0 before you use {@code get}.
     * 2. The middle index is {@code houses.size() / 2}. It's whole-number division: for 5 houses it's 2 (the third house), and for 4 houses it's also 2, the later of the two middle ones.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> houses = new ArrayList<>();

    }
}
