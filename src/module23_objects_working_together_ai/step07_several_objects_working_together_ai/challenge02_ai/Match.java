// AI-Generated
package module23_objects_working_together_ai.step07_several_objects_working_together_ai.challenge02_ai;

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

    public void givePoints() {
        if (this.homeGoals > this.awayGoals) {
            this.home.addPoints(3);
        } else if (this.awayGoals > this.homeGoals) {
            this.away.addPoints(3);
        } else {
            this.home.addPoints(1);
            this.away.addPoints(1);
        }
    }
}
