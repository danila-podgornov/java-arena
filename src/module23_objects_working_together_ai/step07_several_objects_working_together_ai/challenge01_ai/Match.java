// AI-Generated
package module23_objects_working_together_ai.step07_several_objects_working_together_ai.challenge01_ai;

public class Match {
    private Team home;
    private Team away;
    private int homeGoals;
    private int awayGoals;

    public Match(Team home, Team away, int homeGoals, int awayGoals) {
        this.home = home;
        this.away = away;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }

    // Write the winner method here.

    public String toString() {
        return this.home.getName() + " " + this.homeGoals + "-" + this.awayGoals + " " + this.away.getName();
    }
}
