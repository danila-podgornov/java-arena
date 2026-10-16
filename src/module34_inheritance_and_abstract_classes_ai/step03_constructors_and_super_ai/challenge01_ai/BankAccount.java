// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step03_constructors_and_super_ai.challenge01_ai;

public class BankAccount {
    private String owner;
    private int balance;

    public BankAccount(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public String getOwner() {
        return this.owner;
    }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }
}
