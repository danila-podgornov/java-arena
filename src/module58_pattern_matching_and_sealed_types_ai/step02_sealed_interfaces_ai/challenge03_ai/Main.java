// AI-Generated
package module58_pattern_matching_and_sealed_types_ai.step02_sealed_interfaces_ai.challenge03_ai;

public class Main {
    /**
     * A web shop has two kinds of discount: a percentage off the price, and a fixed amount off. {@code Discount.java} holds the sealed interface; write its two permitted types in their files as records:
     * <ul>
     * <li>{@code PercentOff(int percent)}: {@code apply(price)} computes the discount {@code price * percent / 100} first (whole cents, so the division drops any fraction), then returns the price minus that discount;
     * <li>{@code AmountOff(int cents)}: {@code apply(price)} returns the price minus {@code cents}, but never less than 0.
     * </ul>
     * <p>Prices are in cents. The check runs:
     * <pre>{@code
     * Discount sale = new PercentOff(15);
     * Discount coupon = new AmountOff(500);
     * System.out.println(sale + ": " + sale.apply(2000));
     * System.out.println(coupon + ": " + coupon.apply(2000));
     * System.out.println(coupon + ": " + coupon.apply(300));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * PercentOff[percent=15]: 1700
     * AmountOff[cents=500]: 1500
     * AmountOff[cents=500]: 0
     * }</pre>
     * Hints
     * 1. A record implements an interface after its components: {@code public record PercentOff(int percent) implements Discount { ... }}. It needs no {@code final}: records are final already.
     * 2. In each record, write {@code public int apply(int price)} with {@code @Override}. {@code Math.max(0, price - this.cents)} keeps AmountOff's result from going below 0.
     * 3. Compute the discount first, {@code price * this.percent / 100}, and subtract it from the price: the order of the integer division matters. {@code price * (100 - percent) / 100} can come out one cent lower.
     */
    public static void main(String[] args) {
        Discount sale = new PercentOff(15);
        Discount coupon = new AmountOff(500);
        System.out.println(sale + ": " + sale.apply(2000));
        System.out.println(coupon + ": " + coupon.apply(2000));
        System.out.println(coupon + ": " + coupon.apply(300));
    }
}
