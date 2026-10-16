// AI-Generated
package module21_designing_classes_and_overloading_ai.step01_turning_a_program_into_objects_ai.challenge02_ai;

public class Gate {
    private String name;
    private int visitors;

    public Gate(String name) {
        this.name = name;
        this.visitors = 0;
    }

    public void pass() {
        this.visitors = this.visitors + 1;
    }

    public String toString() {
        return this.name + " gate: " + this.visitors;
    }
}
