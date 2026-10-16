// AI-Generated
package module56_records_ai.step05_class_or_record_ai.challenge01_ai;

import java.util.Objects;

public class Quilt {
    private final String name;
    private final int squares;

    public Quilt(String name, int squares) {
        this.name = name;
        this.squares = squares;
    }

    public String getName() {
        return this.name;
    }

    public int getSquares() {
        return this.squares;
    }

    @Override
    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof Quilt)) {
            return false;
        }
        Quilt other = (Quilt) compared;
        return this.name.equals(other.name) && this.squares == other.squares;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.squares);
    }

    @Override
    public String toString() {
        return "Quilt[name=" + this.name + ", squares=" + this.squares + "]";
    }
}
