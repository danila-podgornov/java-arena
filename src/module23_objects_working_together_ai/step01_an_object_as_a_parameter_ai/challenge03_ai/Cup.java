// AI-Generated
package module23_objects_working_together_ai.step01_an_object_as_a_parameter_ai.challenge03_ai;

public class Cup {
    private int capacity;
    private int water;

    public Cup(int capacity) {
        this.capacity = capacity;
        this.water = 0;
    }

    public int space() {
        return this.capacity - this.water;
    }

    public void fill(int ml) {
        this.water = this.water + ml;
    }

    public String toString() {
        return this.water + "/" + this.capacity + " ml";
    }
}
