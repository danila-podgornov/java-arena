// AI-Generated
package module32_comparing_objects_equals_and_hashcode_ai.step03_writing_hashcode_ai.challenge03_ai;

import java.util.Objects;

public class Stamp {
    private String country;
    private int year;
    private String condition;

    public Stamp(String country, int year, String condition) {
        this.country = country;
        this.year = year;
        this.condition = condition;
    }

    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof Stamp)) {
            return false;
        }
        Stamp other = (Stamp) compared;
        return this.country.equals(other.country) && this.year == other.year;
    }

    public int hashCode() {
        return Objects.hash(this.country, this.year, this.condition);
    }
}
