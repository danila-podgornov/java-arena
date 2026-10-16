// AI-Generated
package module17_classes_and_objects_ai.step05_changing_an_object_ai.challenge03_ai;

public class Elevator {
    private int floor;
    private int topFloor;

    public Elevator(int topFloor) {
        this.floor = 0;
        this.topFloor = topFloor;
    }

    public void ride(int floors) {
        this.floor = this.floor + floors;
        if (this.floor > this.topFloor) {
            this.floor = this.topFloor;
        }
        if (this.floor < 0) {
            this.floor = 0;
        }
    }

    public void printFloor() {
        System.out.println("Floor " + this.floor);
    }
}
