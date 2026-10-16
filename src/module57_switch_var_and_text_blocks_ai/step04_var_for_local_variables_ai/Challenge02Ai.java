// AI-Generated
package module57_switch_var_and_text_blocks_ai.step04_var_for_local_variables_ai;

import java.util.Scanner;

public class Challenge02Ai {
    /**
     * A dice game reads rolls, one per line as a name and the roll, such as {@code Ada 4}, until the line {@code end}, and prints the winner: the first player with the highest roll. Someone wrote it with {@code var} everywhere, and now it doesn't compile. Press Run to see javac's errors and fix each line it names, then run again: javac names more lines once the first ones are fixed. Keep going until the program works. With this input:
     * <p>Input
     * <pre>{@code
     * Ada 4
     * Bo 6
     * Cy 6
     * end
     * }</pre>
     * <p>the program prints: see the expected output below.
     * Expected output
     * {@code Bo wins with 6}
     * Hints
     * 1. A method's parameters can't be {@code var} at all: give {@code announce} the parameters {@code String name, int roll}.
     * 2. {@code var highest;} has no value to work out a type from: give it one, {@code var highest = 0;}, or write its type, {@code int highest = 0;}. And {@code null} doesn't say which type {@code winner} is: write {@code String winner = null;}.
     */
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var highest;
        var winner = null;
        while (true) {
            var line = scanner.nextLine();
            if (line.equals("end")) {
                break;
            }
            var parts = line.split(" ");
            var roll = Integer.valueOf(parts[1]);
            if (winner == null || roll > highest) {
                highest = roll;
                winner = parts[0];
            }
        }
        announce(winner, highest);
    }

    public static void announce(var name, var roll) {
        System.out.println(name + " wins with " + roll);
    }
}
