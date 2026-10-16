// AI-Generated
package module32_comparing_objects_equals_and_hashcode_ai.step04_equal_enough_ignoring_some_values_or_capitals_ai.challenge03_ai;

public class Stamp {
    private String country;
    private int year;
    private String condition;

    public Stamp(String country, int year, String condition) {
        this.country = country;
        this.year = year;
        this.condition = condition;
    }

    // Write the equals and hashCode methods here.

    public String toString() {
        return this.country + " " + this.year + " (" + this.condition + ")";
    }
}
