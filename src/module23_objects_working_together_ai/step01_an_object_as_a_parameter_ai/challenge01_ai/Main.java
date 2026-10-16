// AI-Generated
package module23_objects_working_together_ai.step01_an_object_as_a_parameter_ai.challenge01_ai;

public class Main {
    /**
     * A piggy bank counts the coins put into it and adds up their value in cents. In {@code PiggyBank.java}, write the method {@code insert(Coin coin)}: it adds one to {@code coins}, and the coin's value to {@code cents}. {@code Coin.java} is ready, and a coin tells its value with {@code getCents()}. The check runs:
     * <pre>{@code
     * PiggyBank piggy = new PiggyBank();
     * piggy.insert(new Coin(50));
     * piggy.insert(new Coin(20));
     * piggy.insert(new Coin(100));
     * System.out.println(piggy);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code Coins: 3, total 170 cents}
     * Hints
     * 1. The parameter's type is the class: <code>public void insert(Coin coin) {</code>. Inside the method, {@code coin} is the coin that was put in.
     * 2. {@code this.coins++;} counts the coin, and {@code this.cents = this.cents + coin.getCents();} adds its value. {@code coin.cents} doesn't compile in PiggyBank, because it's private to Coin.
     */
    public static void main(String[] args) {
        PiggyBank piggy = new PiggyBank();
        piggy.insert(new Coin(50));
        piggy.insert(new Coin(20));
        piggy.insert(new Coin(100));
        System.out.println(piggy);
    }
}
