// AI-Generated
package module32_comparing_objects_equals_and_hashcode_ai.step03_writing_hashcode_ai.challenge02_ai;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    /**
     * The coin collector from step 1 now counts coins in a {@code HashMap<Coin, Integer>}. {@code Coin.java} has its {@code equals}. Give it a {@code hashCode} too, with {@code Objects.hash} and the same three values that {@code equals} compares. Then, in {@code Main.java}, write the method {@code countCoins(ArrayList<Coin> coins)}, which returns a {@code HashMap<Coin, Integer>} from each different coin to how many times it's in the list. The check runs:
     * <pre>{@code
     * ArrayList<Coin> box = new ArrayList<>();
     * box.add(new Coin("Italy", 2002, 50));
     * box.add(new Coin("Kenya", 2005, 10));
     * box.add(new Coin("Italy", 2002, 50));
     * box.add(new Coin("Italy", 2002, 20));
     * HashMap<Coin, Integer> counts = countCoins(box);
     * System.out.println(counts.get(new Coin("Italy", 2002, 50)));
     * System.out.println(counts.get(new Coin("Kenya", 2005, 10)));
     * System.out.println(counts.size());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 2
     * 1
     * 3
     * }</pre>
     * Hints
     * 1. {@code hashCode} gives {@code Objects.hash} the three values that {@code equals} compares, and {@code Coin.java} needs {@code import java.util.Objects;} at the top. {@code countCoins} makes a new {@code HashMap<Coin, Integer>}, goes through the coins, adds one to each coin's count, and returns the map.
     * 2. The method is {@code public int hashCode() { return Objects.hash(this.country, this.year, this.cents); }}. In the loop of {@code countCoins}, count as module 31 did: {@code counts.put(coin, counts.getOrDefault(coin, 0) + 1);}.
     */
    public static void main(String[] args) {
        ArrayList<Coin> box = new ArrayList<>();
        box.add(new Coin("Italy", 2002, 50));
        box.add(new Coin("Kenya", 2005, 10));
        box.add(new Coin("Italy", 2002, 50));
        box.add(new Coin("Italy", 2002, 20));
        HashMap<Coin, Integer> counts = countCoins(box);
        System.out.println(counts.get(new Coin("Italy", 2002, 50)));
        System.out.println(counts.get(new Coin("Kenya", 2005, 10)));
        System.out.println(counts.size());
    }

    // Write the method countCoins here.
}
