// AI-Generated
package module17_classes_and_objects_ai.step05_changing_an_object_ai.challenge03_ai;

public class Main {
    /**
     * What does this program print? The elevator remembers its floor between the calls.
     * Hints
     * 1. The elevator starts at floor 0, and its top floor is 4. {@code ride(3)} takes it to floor 3.
     * 2. {@code ride(5)} would go to 8, but the first {@code if} stops it at the top floor. From there, {@code ride(-6)} would go below 0, and the second {@code if} stops it at 0.
     */
    public static void main(String[] args) {
        Elevator lift = new Elevator(4);
        lift.ride(3);
        lift.printFloor();
        lift.ride(5);
        lift.printFloor();
        lift.ride(-6);
        lift.printFloor();
    }
}
