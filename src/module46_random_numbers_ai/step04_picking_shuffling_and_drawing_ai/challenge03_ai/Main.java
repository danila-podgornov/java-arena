// AI-Generated
package module46_random_numbers_ai.step04_picking_shuffling_and_drawing_ai.challenge03_ai;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    /**
     * Housemates draw chores out of a hat. In {@code ChoreHat.java}, write the class {@code ChoreHat} with:
     * <ul>
     * <li>a constructor {@code ChoreHat(ArrayList<String> chores, Random random)}, which keeps a copy of the list, so that the list it was given isn't emptied by the draws
     * <li>{@code draw()}, which picks an index with {@code random.nextInt} of how many chores are left, removes that chore from the hat and returns it. When the hat is empty, it returns {@code nothing left}.
     * <li>{@code left()}, which returns how many chores are still in the hat
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * ArrayList<String> chores = new ArrayList<>();
     * chores.add("dishes");
     * chores.add("vacuuming");
     * chores.add("trash");
     * ChoreHat hat = new ChoreHat(chores, new Random(6));
     * for (int i = 0; i < 4; i++) {
     *     System.out.println(hat.draw());
     * }
     * System.out.println(hat.left() + " left, " + chores.size() + " chores in all");
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * vacuuming
     * dishes
     * trash
     * nothing left
     * 0 left, 3 chores in all
     * }</pre>
     * Hints
     * 1. In the constructor, keep a copy: {@code this.chores = new ArrayList<>(chores);}. Keep the Random in an instance variable too.
     * 2. {@code draw()} returns {@code nothing left} when {@code this.chores.isEmpty()}. Otherwise it returns {@code this.chores.remove(this.random.nextInt(this.chores.size()))}: {@code remove} with an index returns the element it removed.
     */
    public static void main(String[] args) {
        ArrayList<String> chores = new ArrayList<>();
        chores.add("dishes");
        chores.add("vacuuming");
        chores.add("trash");
        ChoreHat hat = new ChoreHat(chores, new Random(6));
        for (int i = 0; i < 4; i++) {
            System.out.println(hat.draw());
        }
        System.out.println(hat.left() + " left, " + chores.size() + " chores in all");
    }
}
