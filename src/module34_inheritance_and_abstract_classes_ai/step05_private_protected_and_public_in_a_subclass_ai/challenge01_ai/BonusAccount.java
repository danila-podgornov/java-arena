// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step05_private_protected_and_public_in_a_subclass_ai.challenge01_ai;

public class BonusAccount extends BankAccount {

    public BonusAccount(String owner, int balance) {
        super(owner, balance);
    }

    @Override
    public void deposit(int amount) {
        if (amount > 0) {
            this.balance += amount;
        }
        if (amount >= 100) {
            this.balance += 5;
        }
    }
}
