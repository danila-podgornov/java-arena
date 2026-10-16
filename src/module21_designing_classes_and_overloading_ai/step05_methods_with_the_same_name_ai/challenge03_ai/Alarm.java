// AI-Generated
package module21_designing_classes_and_overloading_ai.step05_methods_with_the_same_name_ai.challenge03_ai;

public class Alarm {
    private int hours;
    private int minutes;

    public Alarm() {
        this.hours = 7;
        this.minutes = 0;
    }

    public void set(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    // Write the set(String time) method here.

    public String toString() {
        if (this.minutes < 10) {
            return "Alarm at " + this.hours + ":0" + this.minutes;
        }
        return "Alarm at " + this.hours + ":" + this.minutes;
    }
}
