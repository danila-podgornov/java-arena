// AI-Generated
package module23_objects_working_together_ai.step02_an_object_inside_an_object_ai.challenge02_ai;

public class Engine {
    private int power;

    public Engine(int power) {
        this.power = power;
    }

    public void tune(int extra) {
        this.power = this.power + extra;
    }

    public String toString() {
        return this.power + " hp";
    }
}
