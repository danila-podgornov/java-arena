// AI-Generated
package module40_class_diagrams_ai.step01_a_class_as_a_box_ai.challenge02_ai;

public class Nurse {

    public Nurse(String name, boolean nightShift) {
        this.name = name;
        this.nightShift = nightShift;
        this.patients = 0;
    }

    public void takePatient() {
        this.patients++;
    }

    @Override
    public String toString() {
        String shift = "day";
        if (this.nightShift) {
            shift = "night";
        }
        return this.name + " (" + shift + " shift): " + this.patients + " patients";
    }
}
