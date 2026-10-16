// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step05_private_protected_and_public_in_a_subclass_ai.challenge03_ai;

public class Main {
    /**
     * Here are the bank's classes from the lesson: BankAccount with its balance {@code protected}, and CheckingAccount, which overrides {@code withdraw}. What does this program print?
     * Hints
     * 1. The plain account runs BankAccount's {@code withdraw}, which refuses 120 from 100. The checking account runs CheckingAccount's, which allows up to the balance plus 50.
     * 2. After the first withdrawal, the checking balance is -20, so it can pay out at most -20 + 50 = 30, and 40 is refused. {@code deposit} is inherited from BankAccount.
     */
    public static void main(String[] args) {
        BankAccount plain = new BankAccount("Leo", 100);
        CheckingAccount checking = new CheckingAccount("Ada", 100, 50);
        plain.withdraw(120);
        checking.withdraw(120);
        checking.withdraw(40);
        checking.deposit(10);
        System.out.println(plain.getBalance());
        System.out.println(checking.getBalance());
    }
}
