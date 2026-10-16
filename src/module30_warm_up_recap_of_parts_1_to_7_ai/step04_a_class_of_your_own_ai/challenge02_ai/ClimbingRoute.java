// AI-Generated
package module30_warm_up_recap_of_parts_1_to_7_ai.step04_a_class_of_your_own_ai.challenge02_ai;

public class ClimbingRoute {
    private String wall;
    private String color;
    private int grade;
    private int ascents;

    public ClimbingRoute(String wall, String color, int grade) {
        this.wall = wall;
        this.color = color;
        this.grade = grade;
        this.ascents = 0;
    }

    public int getAscents() {
        return this.ascents;
    }

    public void climb() {
        this.ascents++;
    }

    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof ClimbingRoute)) {
            return false;
        }
        ClimbingRoute other = (ClimbingRoute) compared;
        return this.wall.equals(other.wall) && this.color.equals(other.color);
    }
}
