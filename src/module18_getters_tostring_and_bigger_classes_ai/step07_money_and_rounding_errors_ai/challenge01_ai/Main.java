// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step07_money_and_rounding_errors_ai.challenge01_ai;

public class Main {
    /**
     * A {@code CoinJar} keeps its money in cents. Add a {@code toString} that shows the money as euros and cents, with two digits for the cents and the word {@code euros} after them. The check adds a 2-euro coin (200 cents) and a 5-cent coin, and prints the jar: see the expected output below.
     * Expected output
     * {@code 2.05 euros}
     * Hints
     * 1. {@code this.cents / 100} gives the whole euros, and {@code this.cents % 100} the cents left over.
     * 2. When the cents are below 10, put a {@code 0} in front of them: {@code if (rest < 10) { return euros + ".0" + rest + " euros"; }}
     */
    public static void main(String[] args) {
        CoinJar jar = new CoinJar();
        jar.addCoin(200);
        jar.addCoin(5);
        System.out.println(jar);
    }
}
