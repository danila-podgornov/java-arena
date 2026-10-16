// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step01_methods_that_return_a_value_ai.challenge02_ai;

public class Scoreboard {
    private int home;
    private int away;

    public Scoreboard() {
        this.home = 0;
        this.away = 0;
    }

    public void homeScores(int points) {
        this.home = this.home + points;
    }

    public void awayScores(int points) {
        this.away = this.away + points;
    }

    public int totalPoints() {
        return this.home + this.away;
    }

    // Write the leader method here.
}
