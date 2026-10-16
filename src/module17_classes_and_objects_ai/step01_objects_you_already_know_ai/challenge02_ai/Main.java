// AI-Generated
package module17_classes_and_objects_ai.step01_objects_you_already_know_ai.challenge02_ai;

public class Main {
    /**
     * What does this program print? Keep track of each lamp separately.
     * Hints
     * 1. {@code hall} and {@code garage} are two separate lamps. Both are turned on, and then only the hall lamp is turned off again.
     * 2. {@code spare} is a third lamp. Its place is also {@code hall}, but it's a different object, so turning it on doesn't change the lamp in {@code hall}.
     */
    public static void main(String[] args) {
        Lamp hall = new Lamp("hall");
        Lamp garage = new Lamp("garage");
        hall.turnOn();
        garage.turnOn();
        hall.turnOff();
        hall.printState();
        garage.printState();
        Lamp spare = new Lamp("hall");
        spare.turnOn();
        hall.printState();
    }
}
