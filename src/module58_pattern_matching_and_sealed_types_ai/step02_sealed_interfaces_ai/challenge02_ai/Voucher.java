// AI-Generated
package module58_pattern_matching_and_sealed_types_ai.step02_sealed_interfaces_ai.challenge02_ai;

public class Voucher implements Payment {
    private final String code;
    private final int cents;

    public Voucher(String code, int cents) {
        this.code = code;
        this.cents = cents;
    }

    @Override
    public String receipt() {
        return "voucher " + this.code + ", " + this.cents + " cents";
    }
}
