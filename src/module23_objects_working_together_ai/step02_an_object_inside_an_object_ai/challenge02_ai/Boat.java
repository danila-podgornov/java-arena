// AI-Generated
package module23_objects_working_together_ai.step02_an_object_inside_an_object_ai.challenge02_ai;

public class Boat {
    private String name;
    private Engine engine;

    public Boat(String name, Engine engine) {
        this.name = name;
        this.engine = engine;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public String toString() {
        return this.name + " with a " + this.engine + " engine";
    }
}
