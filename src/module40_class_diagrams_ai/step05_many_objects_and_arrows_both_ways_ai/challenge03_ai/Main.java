// AI-Generated
package module40_class_diagrams_ai.step05_many_objects_and_arrows_both_ways_ai.challenge03_ai;

public class Main {
    /**
     * A garden center sells seedlings in trays, and a tray has room for at most 6 of them. Write both classes of this diagram, {@code Seedling} in {@code Seedling.java} and {@code Tray} in {@code Tray.java}:
     * <pre>{@code
     * class Seedling
     * - name: String
     * - price: int
     * + Seedling(name: String, price: int)
     * + getPrice(): int
     * + toString(): String
     *
     * class Tray
     * + Tray()
     * + add(seedling: Seedling): boolean
     * + total(): int
     * + toString(): String
     *
     * Tray --> 0..6 Seedling : seedlings
     * }</pre>
     * <ul>
     * <li>A seedling's {@code toString} returns {@code Basil (3 dollars)}, with its own name and price.
     * <li>A new tray is empty. {@code add} puts the seedling in the tray and returns {@code true}, unless the tray already has 6 seedlings: then it returns {@code false} and adds nothing.
     * <li>{@code total} returns the prices of the tray's seedlings added up.
     * <li>A tray's {@code toString} returns {@code 3 seedlings, 11 dollars}.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Tray tray = new Tray();
     * tray.add(new Seedling("Basil", 3));
     * tray.add(new Seedling("Tomato", 4));
     * tray.add(new Seedling("Mint", 4));
     * System.out.println(tray);
     * System.out.println(new Seedling("Thyme", 2));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 3 seedlings, 11 dollars
     * Thyme (2 dollars)
     * }</pre>
     * Hints
     * 1. Seedling is a class like the lesson's first Act, the one with {@code getMinutes()}: two instance variables, a constructor, a getter and {@code toString}. Tray's box has no fields: its only instance variable is the list that the arrow stands for, {@code private ArrayList<Seedling> seedlings;}.
     * 2. {@code 0..6} means at most 6, so {@code add} returns {@code false} without adding when the list's size is already 6. {@code total} adds up {@code getPrice()} over the list, and {@code toString} uses the list's size and {@code total()}.
     */
    public static void main(String[] args) {
        Tray tray = new Tray();
        tray.add(new Seedling("Basil", 3));
        tray.add(new Seedling("Tomato", 4));
        tray.add(new Seedling("Mint", 4));
        System.out.println(tray);
        System.out.println(new Seedling("Thyme", 2));
    }
}
