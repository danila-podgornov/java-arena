// AI-Generated
package module23_objects_working_together_ai.step02_an_object_inside_an_object_ai.challenge02_ai;

public class Main {
    /**
     * What does this program print? Follow the Engine object: which variables refer to it?
     * Hints
     * 1. {@code boat.getEngine()} returns the boat's Engine object, and {@code .tune(10)} is called on it. The boat's engine now has 100 hp.
     * 2. The constructor stored the same Engine that {@code engine} in {@code main} refers to. So {@code engine.tune(5)} tunes the boat's engine as well, and printing it calls the engine's {@code toString}.
     */
    public static void main(String[] args) {
        Engine engine = new Engine(90);
        Boat boat = new Boat("Gull", engine);
        System.out.println(boat);
        boat.getEngine().tune(10);
        System.out.println(boat);
        engine.tune(5);
        System.out.println(boat.getEngine());
    }
}
