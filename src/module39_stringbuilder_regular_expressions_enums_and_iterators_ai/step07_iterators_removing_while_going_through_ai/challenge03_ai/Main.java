// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step07_iterators_removing_while_going_through_ai.challenge03_ai;

public class Main {
    /**
     * A shopping app keeps its coupons in a wallet. {@code Coupon.java} is ready: a coupon has a code, a discount in percent, and the last day of the month on which it's valid. In {@code Wallet.java}, write the two missing methods, each with an iterator:
     * <ul>
     * <li>{@code removeExpired(int today)}, which removes every coupon whose last day is before {@code today} (a coupon is still valid on its last day)
     * <li>{@code use(String code)}, which removes the first coupon with that code (a wallet can hold two with the same code, and capitals count) and returns its discount, or returns 0 if the wallet has no such coupon
     * </ul>
     * <p>{@code Main.java} is a test drive, and it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * [BREAD10 (10%), BOOKS15 (15%)]
     * 15 0
     * [BREAD10 (10%)]
     * }</pre>
     * Hints
     * 1. Both methods start with {@code Iterator<Coupon> iterator = this.coupons.iterator();} and a {@code while (iterator.hasNext())} loop. In {@code removeExpired}, remove the coupon when its {@code getLastDay()} is smaller than {@code today}.
     * 2. In {@code use}, keep the coupon from {@code next()} in a variable. When its code {@code equals} the one asked for, call {@code iterator.remove()} and return the coupon's percent right away. After the loop, nothing matched: return 0.
     */
    public static void main(String[] args) {
        Wallet wallet = new Wallet();
        wallet.add(new Coupon("BREAD10", 10, 14));
        wallet.add(new Coupon("SHOES25", 25, 3));
        wallet.add(new Coupon("BOOKS15", 15, 20));
        wallet.add(new Coupon("TEA5", 5, 9));
        wallet.removeExpired(10);
        System.out.println(wallet);
        System.out.println(wallet.use("BOOKS15") + " " + wallet.use("TEA5"));
        System.out.println(wallet);
    }
}
