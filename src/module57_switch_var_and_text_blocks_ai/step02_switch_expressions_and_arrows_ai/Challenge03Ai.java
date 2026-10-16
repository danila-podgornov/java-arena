// AI-Generated
package module57_switch_var_and_text_blocks_ai.step02_switch_expressions_and_arrows_ai;

public class Challenge03Ai {
    /**
     * A parcel service charges by zone, in cents. Write the method {@code postage(int zone, int grams)} with a switch expression on the zone:
     * <ul>
     * <li>zone 1 (the same town): 150, whatever the weight
     * <li>zone 2 (the same country): 300, whatever the weight
     * <li>zone 3 (abroad): 800, plus 50 for each full 100 grams over 500 grams. A parcel of 1250 grams is 750 grams over, which holds seven full hundreds, so it costs 800 + 7 * 50 = 1150.
     * <li>any other zone: -1
     * </ul>
     * <p>Work out zone 3's price in a block that ends with {@code yield}. The check runs {@code System.out.println(postage(3, 1250));}, which prints: see the expected output below.
     * Expected output
     * {@code 1150}
     * Hints
     * 1. Zone 3's case is a block: {@code case 3 -> { ... yield price; }}. Inside it, work out how many grams the parcel is over 500. A parcel under 500 grams is over by 0, not by a negative number: {@code Math.max(0, grams - 500)}.
     * 2. Integer division drops the rest: {@code 750 / 100} is 7, the number of full hundreds. Then {@code yield 800 + over / 100 * 50;}.
     */
    public static void main(String[] args) {
        System.out.println(postage(3, 1250));
    }

    public static int postage(int zone, int grams) {
        return 0;
    }
}
