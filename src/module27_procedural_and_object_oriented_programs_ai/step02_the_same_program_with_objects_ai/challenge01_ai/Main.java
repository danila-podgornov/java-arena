// AI-Generated
package module27_procedural_and_object_oriented_programs_ai.step02_the_same_program_with_objects_ai.challenge01_ai;

public class Main {
    /**
     * Here's the board game of the previous step, with an object. {@code Main.java} is ready. Write the class in {@code Piece.java}:
     * <ul>
     * <li>{@code Piece(int lastSquare)}: a piece on square 1, on a board whose last square is {@code lastSquare}.
     * <li>{@code move(int steps)}: moves the piece by {@code steps} squares, but never past the last square, and never below square 1.
     * <li>{@code getSquare()}: returns the square the piece is on.
     * </ul>
     * <p>The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Square 6
     * Square 30
     * Square 1
     * }</pre>
     * Hints
     * 1. The piece remembers two numbers, in private instance variables: the last square, given to the constructor, and the square it's on, which starts at 1.
     * 2. {@code move} is the static {@code move} of the previous step, working on the object: add {@code steps} to {@code this.square}, then set it to {@code this.lastSquare} if it's past that, and to 1 if it's below 1.
     */
    public static void main(String[] args) {
        Piece piece = new Piece(30);
        piece.move(5);
        System.out.println("Square " + piece.getSquare());
        piece.move(28);
        System.out.println("Square " + piece.getSquare());
        piece.move(-40);
        System.out.println("Square " + piece.getSquare());
    }
}
