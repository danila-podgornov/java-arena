// AI-Generated
package module01_printing_ai.step04_comments_ai;

public class Challenge03Ai {
    /**
     * This program should greet the player and then give an instruction, but the greeting never appears: a comment ends in the wrong place and hides it. Fix the comments so the notes stay comments and the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Welcome, player one!
     * Press Check to begin.
     * }</pre>
     * Hints
     * 1. The block comment starts at {@code /*} on the first line and only ends at the <code>*&#47;</code> two lines further down, so the greeting is inside it.
     * 2. End the first comment right after {@code Say hello to the player.}, and make {@code Then give the first instruction.} a comment of its own.
     */
    public static void main(String[] args) {
        /* Say hello to the player.
        System.out.println("Welcome, player one!");
        Then give the first instruction. */
        System.out.println("Press Check to begin.");
    }
}
