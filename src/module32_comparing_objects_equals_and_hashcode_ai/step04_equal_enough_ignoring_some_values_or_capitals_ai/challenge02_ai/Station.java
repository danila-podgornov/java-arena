// AI-Generated
package module32_comparing_objects_equals_and_hashcode_ai.step04_equal_enough_ignoring_some_values_or_capitals_ai.challenge02_ai;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof Station)) {
            return false;
        }
        Station other = (Station) compared;
        return this.name.equalsIgnoreCase(other.name);
    }

    public int hashCode() {
        return this.name.hashCode();
    }
}
