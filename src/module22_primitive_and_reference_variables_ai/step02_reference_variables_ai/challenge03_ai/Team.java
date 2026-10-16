// AI-Generated
package module22_primitive_and_reference_variables_ai.step02_reference_variables_ai.challenge03_ai;

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

    public String toString() {
        return this.name + ": " + this.points + " points";
    }
}
