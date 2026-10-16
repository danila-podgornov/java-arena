// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step01_methods_that_return_a_value_ai.challenge02_ai;

public class Main {
    /**
     * Add a method {@code leader()} to the {@code Scoreboard}. It returns the String {@code home} when the home team has more points, {@code away} when the away team has more, and {@code tie} when they have the same. The check asks at the start, after 2 points for the away team, and after 3 more for the home team: see the expected output below.
     * Expected output
     * <pre>{@code
     * tie
     * away
     * home
     * }</pre>
     * Hints
     * 1. The method returns a String: <code>public String leader() {</code>.
     * 2. Returning from branches, as in module 11: {@code if (this.home > this.away) { return "home"; }}, the same for the away team, and {@code return "tie";} last.
     */
    public static void main(String[] args) {
        Scoreboard game = new Scoreboard();
        game.awayScores(2);
        System.out.println("Leading: " + game.leader());
    }
}
