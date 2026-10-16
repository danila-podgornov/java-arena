// AI-Generated
package module32_comparing_objects_equals_and_hashcode_ai.step04_equal_enough_ignoring_some_values_or_capitals_ai.challenge03_ai;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    /**
     * Here's the stamp from the last challenge of step 3, done right. A dealer's price list is a {@code HashMap<Stamp, Integer>}, with prices in cents. A stamp has a country, a year and a condition, {@code mint} or {@code used}, and this dealer pays the same for either condition. In {@code Stamp.java}, write {@code equals} and {@code hashCode}: two stamps are equal when the country and the year match, whatever the condition. Then, in {@code Main.java}, write the method {@code albumValue(HashMap<Stamp, Integer> prices, ArrayList<Stamp> album)}, which returns what the stamps of an album are worth together: the price of each stamp, or 0 for a stamp that isn't on the list. The check runs:
     * <pre>{@code
     * HashMap<Stamp, Integer> prices = new HashMap<>();
     * prices.put(new Stamp("Chile", 1970, "mint"), 250);
     * prices.put(new Stamp("Peru", 1985, "mint"), 400);
     * ArrayList<Stamp> album = new ArrayList<>();
     * album.add(new Stamp("Chile", 1970, "used"));
     * album.add(new Stamp("Peru", 1985, "mint"));
     * album.add(new Stamp("Chile", 1971, "mint"));
     * System.out.println(albumValue(prices, album));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code 650}
     * Hints
     * 1. {@code equals} and {@code hashCode} leave the condition out, as the paint shop's Color leaves the name out: {@code equals} compares the country and the year, and {@code hashCode} gives {@code Objects.hash} the same two values (with {@code import java.util.Objects;} at the top).
     * 2. {@code albumValue} goes through the album and adds up {@code prices.getOrDefault(stamp, 0)} for each stamp. A used Chile 1970 is equal to the mint one on the list, and has the same hash code, so the map finds its price.
     */
    public static void main(String[] args) {
        HashMap<Stamp, Integer> prices = new HashMap<>();
        prices.put(new Stamp("Chile", 1970, "mint"), 250);
        prices.put(new Stamp("Peru", 1985, "mint"), 400);
        ArrayList<Stamp> album = new ArrayList<>();
        album.add(new Stamp("Chile", 1970, "used"));
        album.add(new Stamp("Peru", 1985, "mint"));
        album.add(new Stamp("Chile", 1971, "mint"));
        System.out.println(albumValue(prices, album));
    }

    // Write the method albumValue here.
}
