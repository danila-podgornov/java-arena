// AI-Generated
package module58_pattern_matching_and_sealed_types_ai.step02_sealed_interfaces_ai.challenge02_ai;

public final class BankCard implements Payment {
    private final String lastDigits;
    private final int cents;

    public BankCard(String lastDigits, int cents) {
        this.lastDigits = lastDigits;
        this.cents = cents;
    }

    @Override
    public String receipt() {
        return "card ending " + this.lastDigits + ", " + this.cents + " cents";
    }
}
