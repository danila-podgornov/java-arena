// AI-Generated
package module27_procedural_and_object_oriented_programs_ai.step01_procedural_programs_ai;

public class Challenge01Ai {
    /**
     * In a board game, the pieces move along the squares 1 to 30. A piece can't go past square 30, and a card like "go back 5" can't take it below square 1. The program is procedural: {@code main} keeps the square in a variable, and {@code move} gets the square and a number of steps, and returns the new square. Fill in the blanks, so that the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Square 6
     * Square 30
     * Square 1
     * }</pre>
     * Hints
     * 1. {@code move} gives back a whole number, so its return type is {@code int}, and its last line hands the square back with {@code return}.
     * 2. {@code move} can't change the variable of {@code main}. {@code main} has to store what it returns, as the first call does: {@code square = move(square, 28);}.
     */
    public static void main(String[] args) {
        int square = 1;
        square = move(square, 5);
        System.out.println("Square " + square);
        ___ = move(square, 28);
        System.out.println("Square " + square);
        square = move(square, -40);
        System.out.println("Square " + square);
    }

    public static ___ move(int square, int steps) {
        square = square + steps;
        if (square > 30) {
            square = 30;
        }
        if (square < 1) {
            square = 1;
        }
        ___ square;
    }
}
