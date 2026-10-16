// AI-Generated
package module46_random_numbers_ai.step01_random_and_nextint_ai;

import java.util.Random;

public class Challenge01Ai {
    /**
     * In a board game, a storm card blows your piece back a random number of squares: 2, 3, 4 or 5, each as likely as the others. Fill in the blanks so that {@code stormSquares} returns such a number. {@code main} draws 10000 storm cards and prints the smallest and the largest number of squares: see the expected output below.
     * Expected output
     * {@code smallest 2, largest 5}
     * Hints
     * 1. How many whole numbers are there from 2 to 5, counting both ends? That count is the bound, and {@code nextInt} starts at 0.
     * 2. 2, 3, 4 and 5 are four numbers, so the bound is 4: {@code nextInt(4)} gives 0 to 3. Adding the smallest number of squares, 2, moves that up to 2 to 5.
     */
    public static void main(String[] args) {
        Random random = new Random();
        int smallest = 100;
        int largest = -100;
        for (int i = 0; i < 10000; i++) {
            int squares = stormSquares(random);
            if (squares < smallest) {
                smallest = squares;
            }
            if (squares > largest) {
                largest = squares;
            }
        }
        System.out.println("smallest " + smallest + ", largest " + largest);
    }

    public static int stormSquares(Random random) {
        return random.nextInt(___) + ___;
    }
}
