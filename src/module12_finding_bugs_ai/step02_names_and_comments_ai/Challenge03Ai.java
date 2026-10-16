// AI-Generated
package module12_finding_bugs_ai.step02_names_and_comments_ai;

public class Challenge03Ai {
    /**
     * What does this program print? Watch for the comments.
     * Hints
     * 1. Java skips everything after {@code //} on a line, and everything between {@code /*} and <code>*&#47;</code>.
     * 2. Only three statements run: the first print, {@code lives--;} and the last print.
     */
    public static void main(String[] args) {
        int lives = 3;
        // lives = lives + 1;
        System.out.println("Lives: " + lives);
        /* lives = 0;
        System.out.println("Game over"); */
        lives--; // one hit
        System.out.println("Lives: " + lives);
    }
}
