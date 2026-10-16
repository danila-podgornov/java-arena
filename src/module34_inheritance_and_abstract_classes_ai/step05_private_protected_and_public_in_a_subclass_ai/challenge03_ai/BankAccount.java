// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step05_private_protected_and_public_in_a_subclass_ai.challenge03_ai;

public class BankAccount {
    private String owner;
    protected int balance;

    public BankAccount(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
        }
    }
}
