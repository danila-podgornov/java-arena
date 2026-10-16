// AI-Generated
package module23_objects_working_together_ai.step07_several_objects_working_together_ai.challenge01_ai;

public class Team {
    private String name;
    private int points;

    public Team(String name) {
        this.name = name;
        this.points = 0;
    }

    public void addPoints(int points) {
        this.points = this.points + points;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name + ", points: " + this.points;
    }
}
