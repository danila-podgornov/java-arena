// AI-Generated
package module32_comparing_objects_equals_and_hashcode_ai.step01_equals_again_ai.challenge01_ai;

public class Square {
    private String column;
    private int row;

    public Square(String column, int row) {
        this.column = column;
        this.row = row;
    }

    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof Square)) {
            return false;
        }
        Square other = (Square) compared;
        return this.column.equals(other.column) && this.row == other.row;
    }

    public String toString() {
        return this.column + this.row;
    }
}
