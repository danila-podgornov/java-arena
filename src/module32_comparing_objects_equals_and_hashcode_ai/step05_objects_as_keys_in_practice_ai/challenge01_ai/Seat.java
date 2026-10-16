// AI-Generated
package module32_comparing_objects_equals_and_hashcode_ai.step05_objects_as_keys_in_practice_ai.challenge01_ai;

import java.util.Objects;

public class Seat {
    private String row;
    private int number;

    public Seat(String row, int number) {
        this.row = row;
        this.number = number;
    }

    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof Seat)) {
            return false;
        }
        Seat other = (Seat) compared;
        return this.row.equals(other.row) && this.number == other.number;
    }

    public int hashCode() {
        return Objects.hash(this.row, this.number);
    }

    public String toString() {
        return this.row + this.number;
    }
}
