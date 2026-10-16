// AI-Generated
package module42_exceptions_ai.step05_throwing_an_exception_ai.challenge02_ai;

public class Main {
    /**
     * A gift card refuses to spend what it doesn't have. What does this program print?
     * Hints
     * 1. After spending 20, the card has 30 left. Spending 40 is refused before the balance changes, and so is -10.
     * 2. When {@code spend} throws, the {@code println} after it in the {@code try} block is skipped, and the {@code catch} block prints the message instead.
     */
    public static void main(String[] args) {
        GiftCard card = new GiftCard(50);
        int[] purchases = {20, 40, -10, 30};
        for (int amount : purchases) {
            try {
                card.spend(amount);
                System.out.println("spent " + amount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("left: " + card.getBalance());
    }
}
