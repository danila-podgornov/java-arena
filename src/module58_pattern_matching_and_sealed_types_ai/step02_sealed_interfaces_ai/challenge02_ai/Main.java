// AI-Generated
package module58_pattern_matching_and_sealed_types_ai.step02_sealed_interfaces_ai.challenge02_ai;

import java.util.ArrayList;

public class Main {
    /**
     * The café now sells gift vouchers too, and someone has written the class {@code Voucher} in {@code Voucher.java}. But the program doesn't compile any more. Press Run: javac says
     * {@code Voucher.java:1: error: class is not allowed to extend sealed class: Payment (as it is not listed in its 'permits' clause)}
     * <p>Fix it while keeping Payment sealed: add Voucher to the interface's list. javac then has one more thing to say about Voucher; fix that too, by making it {@code final}. The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * cash, 450 cents
     * card ending 4921, 1250 cents
     * voucher SPRING10, 1000 cents
     * }</pre>
     * Hints
     * 1. In {@code Payment.java}, the list becomes {@code permits Cash, BankCard, Voucher}.
     * 2. javac then says {@code sealed, non-sealed or final modifiers expected} about Voucher: write {@code public final class Voucher implements Payment}.
     */
    public static void main(String[] args) {
        ArrayList<Payment> today = new ArrayList<>();
        today.add(new Cash(450));
        today.add(new BankCard("4921", 1250));
        today.add(new Voucher("SPRING10", 1000));
        for (Payment payment : today) {
            System.out.println(payment.receipt());
        }
    }
}
