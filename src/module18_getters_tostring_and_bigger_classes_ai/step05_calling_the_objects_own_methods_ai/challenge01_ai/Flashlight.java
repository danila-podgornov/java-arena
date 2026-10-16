// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step05_calling_the_objects_own_methods_ai.challenge01_ai;

public class Flashlight {
    private int charge;

    public Flashlight(int charge) {
        this.charge = charge;
    }

    public void use(int amount) {
        this.charge = this.charge - amount;
    }

    public boolean isLow() {
        return this.charge < 20;
    }

    // Write the toString method here.
}
