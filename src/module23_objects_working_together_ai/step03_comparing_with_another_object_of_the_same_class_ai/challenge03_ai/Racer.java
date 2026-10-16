// AI-Generated
package module23_objects_working_together_ai.step03_comparing_with_another_object_of_the_same_class_ai.challenge03_ai;

public class Racer {
    private String name;
    private int seconds;

    public Racer(String name, int seconds) {
        this.name = name;
        this.seconds = seconds;
    }

    public boolean beats(Racer other) {
        return this.seconds < other.seconds;
    }

    public String toString() {
        return this.name + ", " + this.seconds + " s";
    }
}
