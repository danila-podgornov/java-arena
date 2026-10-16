// AI-Generated
package module23_objects_working_together_ai.step08_putting_it_all_together_ai.challenge03_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * A treasure hunt. The list {@code treasures} in {@code Main.java} holds the positions of three hidden coins, and {@code Position.java} is the class from the lesson. The player starts at (0, 0). Read moves, {@code up}, {@code down}, {@code left} or {@code right}, one per line, until an empty line, and move the player one square each time, with {@code moved}. After each move, if a coin is at the new position, remove it from the list and print {@code Found a coin at } and the position. At the end, print how many coins are left. Let {@code contains} and {@code remove} do the searching, without a loop over the list. For the input shown below, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Found a coin at (1, 0)
     * Found a coin at (2, 2)
     * Coins left: 1
     * }</pre>
     * Hints
     * 1. In the loop, read a move and {@code break} at the empty line. Then move with, for example, {@code here = here.moved(1, 0);} for {@code right}: {@code moved} returns the new position, and {@code here} must be set to it.
     * 2. After the move: {@code if (treasures.contains(here)) { treasures.remove(here); ... }}. The list's positions are other objects than {@code here}, but {@code equals} finds the equal one. At the end, {@code treasures.size()} is the number of coins left.
     */
    public static void main(String[] args) {
        ArrayList<Position> treasures = new ArrayList<>();
        treasures.add(new Position(1, 0));
        treasures.add(new Position(2, 2));
        treasures.add(new Position(-1, 3));

        Scanner scanner = new Scanner(System.in);
        Position here = new Position(0, 0);

    }
}
