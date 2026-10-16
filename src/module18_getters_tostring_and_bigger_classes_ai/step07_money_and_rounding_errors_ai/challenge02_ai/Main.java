// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step07_money_and_rounding_errors_ai.challenge02_ai;

public class Main {
    /**
     * A parking meter takes only coins of 10, 20, 50, 100 and 200 cents, and every 10 cents buys 3 minutes. Write {@code insert(int coin)}, which adds a valid coin to the money paid and returns {@code true}, but returns {@code false} for any other value and leaves the money as it was. Also write {@code minutes()}, which returns the minutes the money paid buys. {@code toString} is ready, and it calls {@code minutes()}. The check inserts 100, 5 and 20 cents, printing what {@code insert} returns each time, and then prints the meter: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * false
     * true
     * 120 cents, 36 minutes
     * }</pre>
     * Hints
     * 1. {@code insert} returns a boolean. Check the coin with {@code ||}: {@code if (coin == 10 || coin == 20 || ...) { ... return true; }}, and {@code return false;} after the {@code if}.
     * 2. Every coin is a whole number of 10 cents, so {@code minutes()} can be {@code return this.paid / 10 * 3;}
     */
    public static void main(String[] args) {
        ParkingMeter meter = new ParkingMeter();
        meter.insert(200);
        if (!meter.insert(2)) {
            System.out.println("Coin returned");
        }
        System.out.println(meter);
    }
}
