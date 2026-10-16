// AI-Generated
package module58_pattern_matching_and_sealed_types_ai.step02_sealed_interfaces_ai.challenge01_ai;

public class Main {
    /**
     * A café's till takes payments. Make {@code Payment} a sealed interface that permits {@code Cash} and {@code BankCard}, and make {@code Cash} final. Then write the class {@code BankCard}: it's final, implements Payment, its constructor takes the card's last four digits (a String) and the amount in cents, and {@code receipt()} returns {@code card ending } and the digits, a comma, and the cents, as below. The check runs:
     * <pre>{@code
     * Payment first = new Cash(450);
     * Payment second = new BankCard("4921", 1250);
     * System.out.println(first.receipt());
     * System.out.println(second.receipt());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * cash, 450 cents
     * card ending 4921, 1250 cents
     * }</pre>
     * Hints
     * 1. The interface's header becomes {@code public sealed interface Payment permits Cash, BankCard}. Each permitted class then needs {@code final} before {@code class}.
     * 2. BankCard is written like Cash: two {@code private final} instance variables, a constructor that stores them, and {@code receipt()} with {@code @Override}, returning {@code "card ending " + this.lastDigits + ", " + this.cents + " cents"}.
     */
    public static void main(String[] args) {
        Payment first = new Cash(450);
        Payment second = new BankCard("4921", 1250);
        System.out.println(first.receipt());
        System.out.println(second.receipt());
    }
}
