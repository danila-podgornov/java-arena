// AI-Generated
package module58_pattern_matching_and_sealed_types_ai.step02_sealed_interfaces_ai.challenge02_ai;

public final class Cash implements Payment {
    private final int cents;

    public Cash(int cents) {
        this.cents = cents;
    }

    @Override
    public String receipt() {
        return "cash, " + this.cents + " cents";
    }
}
