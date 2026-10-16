// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step03_tostring_ai.challenge03_ai;

public class Oven {
    private int degrees;

    public Oven() {
        this.degrees = 0;
    }

    public void heat(int amount) {
        this.degrees = this.degrees + amount;
    }

    public void turnOff() {
        this.degrees = 0;
    }

    public String toString() {
        if (this.degrees == 0) {
            return "off";
        }
        return this.degrees + " degrees";
    }
}
