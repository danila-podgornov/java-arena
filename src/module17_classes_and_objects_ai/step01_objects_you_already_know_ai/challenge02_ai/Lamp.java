// AI-Generated
package module17_classes_and_objects_ai.step01_objects_you_already_know_ai.challenge02_ai;

public class Lamp {
    private String place;
    private boolean on;

    public Lamp(String place) {
        this.place = place;
        this.on = false;
    }

    public void turnOn() {
        this.on = true;
    }

    public void turnOff() {
        this.on = false;
    }

    public void printState() {
        if (this.on) {
            System.out.println("The " + this.place + " lamp is on");
        } else {
            System.out.println("The " + this.place + " lamp is off");
        }
    }
}
