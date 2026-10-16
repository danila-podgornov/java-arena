// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step05_private_protected_and_public_in_a_subclass_ai.challenge01_ai;

public class Main {
    /**
     * The bank's bonus account adds 5 dollars to every deposit of 100 or more. {@code BonusAccount}'s {@code deposit} doesn't compile, since the balance is private in BankAccount. Rewrite it with BankAccount's public methods, and don't change {@code BankAccount.java}: call BankAccount's own {@code deposit} with {@code super.deposit(...)}, once for the amount and once more for a bonus. A deposit of 0 or less adds nothing, and gets no bonus. The check runs:
     * <pre>{@code
     * BonusAccount account = new BonusAccount("Ada", 50);
     * account.deposit(120);
     * System.out.println(account.getBalance());
     * account.deposit(40);
     * System.out.println(account.getBalance());
     * account.deposit(-100);
     * System.out.println(account.getBalance());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 175
     * 215
     * 215
     * }</pre>
     * Hints
     * 1. BonusAccount overrides {@code deposit}, so a plain {@code deposit(...)} inside it would call BonusAccount's own method again. {@code super.deposit(amount)} calls BankAccount's version, which already ignores amounts of 0 or less.
     * 2. After {@code super.deposit(amount);}, add the bonus with {@code if (amount >= 100) { super.deposit(5); }}.
     */
    public static void main(String[] args) {
        BonusAccount account = new BonusAccount("Ada", 50);
        account.deposit(120);
        System.out.println(account.getBalance());
        account.deposit(40);
        System.out.println(account.getBalance());
        account.deposit(-100);
        System.out.println(account.getBalance());
    }
}
