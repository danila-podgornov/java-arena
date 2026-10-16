// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step07_planning_a_whole_program_ai.challenge02_ai;

import java.util.Scanner;

public class Main {
    /**
     * A savings account program. Write the logic class, {@code Account.java}, and the user interface, {@code UserInterface.java}. {@code Main.java} is ready.
     * <p>{@code Account} has a balance, 0 at the start, and a history of the changes to it, in a list: a deposit adds a positive number to the history, a withdrawal a negative one. Its methods:
     * <ul>
     * <li>{@code deposit(int amount)}: adds the amount to the balance, and to the history.
     * <li>{@code withdraw(int amount)}: if the balance is too small, changes nothing and returns {@code false}. Otherwise takes the amount off the balance, adds {@code -amount} to the history, and returns {@code true}.
     * <li>{@code getBalance()}: returns the balance.
     * <li>{@code history()}: returns the history, an {@code ArrayList<Integer>}.
     * </ul>
     * <p>{@code UserInterface} takes a {@code Scanner} and an {@code Account}, and {@code start()} reads commands, with the prompt {@code > } before each one:
     * <ul>
     * <li>{@code deposit}, then a line with the amount: print {@code Balance: } and the new balance.
     * <li>{@code withdraw}, then a line with the amount: print {@code Balance: } and the new balance, or {@code Not enough money}.
     * <li>{@code history}: print {@code History: } and the list, like {@code History: [50, -20]}.
     * <li>{@code quit}: print {@code Goodbye} and return.
     * <li>Anything else: print {@code Unknown command: } and the command.
     * </ul>
     * <p>For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Balance: 50
     * > Balance: 30
     * > Not enough money
     * > Balance: 45
     * > History: [50, -20, 15]
     * > Goodbye
     * }</pre>
     * Hints
     * 1. Write {@code Account} first: {@code private int balance;} and {@code private ArrayList<Integer> history;}, both set in the constructor. {@code withdraw} returns {@code false} first when {@code amount > this.balance}.
     * 2. In {@code withdraw}, {@code this.history.add(-amount);} adds the amount as a negative number. The user interface prints the list itself: {@code "History: " + this.account.history()}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();
        UserInterface ui = new UserInterface(scanner, account);
        ui.start();
    }
}
