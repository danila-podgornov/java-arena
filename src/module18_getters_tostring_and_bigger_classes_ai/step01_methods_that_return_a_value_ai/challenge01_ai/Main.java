// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step01_methods_that_return_a_value_ai.challenge01_ai;

public class Main {
    /**
     * The {@code Scoreboard} keeps the points of a home team and an away team. Add a method {@code totalPoints()} that returns the points of both teams together. The check gives the home team 3 and 1 points and the away team 2, and prints what {@code totalPoints()} returns: see the expected output below.
     * Expected output
     * {@code 6}
     * Hints
     * 1. The method returns an {@code int} and has no parameters: <code>public int totalPoints() {</code>. It goes inside the class, next to the other methods.
     * 2. Its only line: {@code return this.home + this.away;}
     */
    public static void main(String[] args) {
        Scoreboard game = new Scoreboard();
        game.homeScores(3);
        game.awayScores(2);
        game.homeScores(1);
        System.out.println("Points so far: " + game.totalPoints());
    }
}
