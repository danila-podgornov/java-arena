// AI-Generated
package module17_classes_and_objects_ai.step06_several_objects_ai.challenge03_ai;

import java.util.Scanner;

public class Main {
    /**
     * Now write the class yourself. {@code Main.java} is ready: it reads the names of two players and then dice rolls, one per line, until the line {@code end}. The rolls go to the players in turns, first player first, and at the end both positions are printed. Write the class {@code Player} in {@code Player.java}:
     * <ul>
     * <li>{@code Player(String name)} builds a player, who starts on square 1.
     * <li>{@code move(int squares)} moves the player on. The board has 30 squares, and a move that would go past square 30 stops at square 30.
     * <li>{@code printPosition()} prints where the player is, as in the output below.
     * </ul>
     * <p>For the input {@code Ada}, {@code Ben}, {@code 6}, {@code 3}, {@code 5}, {@code 4} and {@code end}, one per line, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Ada is on square 12
     * Ben is on square 8
     * }</pre>
     * Hints
     * 1. Two private instance variables: the name and the square. The constructor stores the name and sets the square to 1.
     * 2. {@code move} adds to the square, and then an {@code if} sets it back to 30 when it went past 30. {@code printPosition} prints {@code this.name + " is on square " + this.square}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player first = new Player(scanner.nextLine());
        Player second = new Player(scanner.nextLine());
        boolean firstPlayersTurn = true;
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("end")) {
                break;
            }
            int roll = Integer.valueOf(line);
            if (firstPlayersTurn) {
                first.move(roll);
            } else {
                second.move(roll);
            }
            firstPlayersTurn = !firstPlayersTurn;
        }
        first.printPosition();
        second.printPosition();
    }
}
