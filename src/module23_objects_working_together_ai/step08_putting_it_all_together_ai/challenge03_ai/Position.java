// AI-Generated
package module23_objects_working_together_ai.step08_putting_it_all_together_ai.challenge03_ai;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position moved(int dx, int dy) {
        return new Position(this.x + dx, this.y + dy);
    }

    public int stepsTo(Position other) {
        return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
    }

    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof Position)) {
            return false;
        }
        Position other = (Position) compared;
        return this.x == other.x && this.y == other.y;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
