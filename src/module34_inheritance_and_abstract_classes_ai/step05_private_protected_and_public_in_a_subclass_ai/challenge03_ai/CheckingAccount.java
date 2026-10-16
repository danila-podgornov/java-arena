// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step05_private_protected_and_public_in_a_subclass_ai.challenge03_ai;

public class CheckingAccount extends BankAccount {
    private int overdraftLimit;

    public CheckingAccount(String owner, int balance, int overdraftLimit) {
        super(owner, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(int amount) {
        if (amount > 0 && amount <= this.balance + this.overdraftLimit) {
            this.balance -= amount;
        }
    }
}
