// AI-Generated
package module32_comparing_objects_equals_and_hashcode_ai.step01_equals_again_ai.challenge02_ai;

import java.util.ArrayList;

public class Main {
    /**
     * A coin collector describes each coin by its country, its year and its value in cents. Two coins are equal when all three are the same. In {@code Coin.java}, write the method {@code equals} the classic way, as in the recap. The check runs:
     * <pre>{@code
     * Coin mine = new Coin("Italy", 2002, 50);
     * System.out.println(mine.equals(new Coin("Italy", 2002, 50)));
     * System.out.println(mine.equals(new Coin("Italy", 2002, 20)));
     * ArrayList<Coin> album = new ArrayList<>();
     * album.add(new Coin("Kenya", 2005, 10));
     * album.add(mine);
     * System.out.println(album.indexOf(new Coin("Italy", 2002, 50)));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * false
     * 1
     * }</pre>
     * Hints
     * 1. Follow Seat's {@code equals}: the header {@code public boolean equals(Object compared)}, the {@code this == compared} check, {@code instanceof Coin}, and the cast {@code Coin other = (Coin) compared;}.
     * 2. The last line compares all three values: {@code return this.country.equals(other.country) && this.year == other.year && this.cents == other.cents;}. The country is a String, so it's compared with {@code equals}.
     */
    public static void main(String[] args) {
        Coin mine = new Coin("Italy", 2002, 50);
        System.out.println(mine.equals(new Coin("Italy", 2002, 50)));
        System.out.println(mine.equals(new Coin("Italy", 2002, 20)));
        ArrayList<Coin> album = new ArrayList<>();
        album.add(new Coin("Kenya", 2005, 10));
        album.add(mine);
        System.out.println(album.indexOf(new Coin("Italy", 2002, 50)));
    }
}
