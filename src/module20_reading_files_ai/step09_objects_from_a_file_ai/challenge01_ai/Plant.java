// AI-Generated
package module20_reading_files_ai.step09_objects_from_a_file_ai.challenge01_ai;

public class Plant {
    private String name;
    private int days;

    public Plant(String name, int days) {
        this.name = name;
        this.days = days;
    }

    public String getName() {
        return this.name;
    }

    public int getDays() {
        return this.days;
    }

    public String toString() {
        return this.name + ": water every " + this.days + " days";
    }
}
