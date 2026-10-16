// AI-Generated
package module41_packages_and_imports_ai.step05_a_larger_program_across_packages_ai.challenge01_ai;

import java.util.Scanner;
import module41_packages_and_imports_ai.step05_a_larger_program_across_packages_ai.challenge01_ai.quiz.logic.Quiz;
import module41_packages_and_imports_ai.step05_a_larger_program_across_packages_ai.challenge01_ai.quiz.ui.TextUI;

public class Main {
    /**
     * Add the command {@code players} to the quiz. It prints each player who has played, in the order they played, one per line, like {@code Ada, 5 points}, or {@code No one has played yet} if no one has. Split the work between the packages:
     * <ul>
     * <li>in {@code Quiz.java}, the method {@code getPlayers()}, which returns the list of players
     * <li>in {@code TextUI.java}, the command, which uses {@code getPlayers()} and prints
     * </ul>
     * <p>For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > No one has played yet
     * > Questions: 1
     * > How many legs does a spider have? (2 points)
     * Right!
     * Ada, 2 points
     * > How many legs does a spider have? (2 points)
     * Not quite.
     * Ben, 0 points
     * > Ada, 2 points
     * Ben, 0 points
     * > Bye!
     * }</pre>
     * Hints
     * 1. In Quiz, {@code getPlayers()} returns {@code this.players}, an {@code ArrayList<Player>}, like {@code getQuestions()} returns the questions.
     * 2. In TextUI, add {@code else if (command.equals("players"))} to the chain in {@code start()}, and put the work in a private method like {@code printBest()}. If {@code this.quiz.getPlayers().isEmpty()}, print the message; otherwise print each player with a for-each loop.
     */
    public static void main(String[] args) {
        TextUI ui = new TextUI(new Scanner(System.in), new Quiz());
        ui.start();
    }
}
