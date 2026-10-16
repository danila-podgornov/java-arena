// AI-Generated
package module58_pattern_matching_and_sealed_types_ai.step02_sealed_interfaces_ai.challenge03_ai;

public sealed interface Discount permits PercentOff, AmountOff {
    int apply(int price);
}
