// AI-Generated
package module42_exceptions_ai.step05_throwing_an_exception_ai.challenge02_ai;

public class GiftCard {
    private int balance;

    public GiftCard(int balance) {
        this.balance = balance;
    }

    public void spend(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("not an amount: " + amount);
        }
        if (amount > this.balance) {
            throw new IllegalArgumentException("only " + this.balance + " left");
        }
        this.balance -= amount;
    }

    public int getBalance() {
        return this.balance;
    }
}
