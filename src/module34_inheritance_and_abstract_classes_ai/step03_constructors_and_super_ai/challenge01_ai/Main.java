// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step03_constructors_and_super_ai.challenge01_ai;

public class Main {
    /**
     * The bank also has checking accounts, which may go below zero, down to an overdraft limit. {@code BankAccount.java} is ready. In {@code CheckingAccount.java}, write the class {@code CheckingAccount}, which extends BankAccount, with:
     * <ul>
     * <li>a constructor {@code CheckingAccount(String owner, int balance, int overdraftLimit)}, which hands the owner and the balance to BankAccount's constructor, and keeps the limit itself
     * <li>{@code getOverdraftLimit()}, which returns the limit
     * <li>{@code availableToSpend()}, which returns the balance plus the limit
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * CheckingAccount account = new CheckingAccount("Ada", 120, 200);
     * System.out.println(account.getOwner() + " " + account.getBalance());
     * System.out.println(account.availableToSpend());
     * account.deposit(30);
     * System.out.println(account.availableToSpend());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Ada 120
     * 320
     * 350
     * }</pre>
     * Hints
     * 1. The class starts <code>public class CheckingAccount extends BankAccount {</code> and has one variable of its own, the overdraft limit. The constructor's first line is {@code super(owner, balance);}.
     * 2. The balance is private to BankAccount, so {@code availableToSpend()} gets it with the inherited {@code this.getBalance()}, and returns that plus {@code this.overdraftLimit}.
     */
    public static void main(String[] args) {
        CheckingAccount account = new CheckingAccount("Ada", 120, 200);
        System.out.println(account.getOwner() + " " + account.getBalance());
        System.out.println(account.availableToSpend());
        account.deposit(30);
        System.out.println(account.availableToSpend());
    }
}
