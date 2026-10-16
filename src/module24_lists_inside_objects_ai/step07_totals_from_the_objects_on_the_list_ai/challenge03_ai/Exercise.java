// AI-Generated
package module24_lists_inside_objects_ai.step07_totals_from_the_objects_on_the_list_ai.challenge03_ai;

public class Exercise {
    private String name;
    private int minutes;
    private int caloriesPerMinute;

    public Exercise(String name, int minutes, int caloriesPerMinute) {
        this.name = name;
        this.minutes = minutes;
        this.caloriesPerMinute = caloriesPerMinute;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getCaloriesPerMinute() {
        return this.caloriesPerMinute;
    }

    public String toString() {
        return this.name + ", " + this.minutes + " min";
    }
}
