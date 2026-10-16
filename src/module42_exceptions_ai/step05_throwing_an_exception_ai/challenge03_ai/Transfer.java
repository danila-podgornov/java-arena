// AI-Generated
package module42_exceptions_ai.step05_throwing_an_exception_ai.challenge03_ai;

public class Transfer {
    private String from;
    private String to;
    private int amount;

    public Transfer(String from, String to, int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("The amount must be positive, not " + amount);
        }
        if (from.equals(to)) {
            throw new IllegalArgumentException("Can't send money to yourself");
        }
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    @Override
    public String toString() {
        return this.from + " -> " + this.to + ": " + this.amount + " dollars";
    }
}
