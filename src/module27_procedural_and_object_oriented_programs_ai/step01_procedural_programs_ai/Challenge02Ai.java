// AI-Generated
package module27_procedural_and_object_oriented_programs_ai.step01_procedural_programs_ai;

public class Challenge02Ai {
    /**
     * A jigsaw puzzle has 500 pieces. {@code main} is ready, and it's procedural: it keeps the number of pieces already in place in a variable. Write the two methods it uses:
     * <ul>
     * <li>{@code place(int placed, int count, int total)} returns how many pieces are in place after {@code count} more are put in: {@code placed + count}, but never more than {@code total}, the number of pieces in the puzzle.
     * <li>{@code piecesLeft(int placed, int total)} returns how many pieces are still to be put in place.
     * </ul>
     * <p>The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Placed 120 pieces, 380 to go
     * Placed 370 pieces, 130 to go
     * Placed 500 pieces, 0 to go
     * }</pre>
     * Hints
     * 1. Both methods are {@code public static int}, with the parameters in the order given. {@code place} works like {@code read} in the book program: add first, then check the limit.
     * 2. In {@code place}, return {@code total} when {@code placed + count} is more than {@code total}, and {@code placed + count} otherwise. {@code piecesLeft} returns {@code total - placed}.
     */
    public static void main(String[] args) {
        int total = 500;
        int placed = 0;
        placed = place(placed, 120, total);
        System.out.println("Placed " + placed + " pieces, " + piecesLeft(placed, total) + " to go");
        placed = place(placed, 250, total);
        System.out.println("Placed " + placed + " pieces, " + piecesLeft(placed, total) + " to go");
        placed = place(placed, 200, total);
        System.out.println("Placed " + placed + " pieces, " + piecesLeft(placed, total) + " to go");
    }

    // Write the methods place and piecesLeft here.
}
