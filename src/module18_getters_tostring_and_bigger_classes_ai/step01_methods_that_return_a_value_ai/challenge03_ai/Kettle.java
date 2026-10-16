// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step01_methods_that_return_a_value_ai.challenge03_ai;

public class Kettle {
    private int water;

    public Kettle(int water) {
        this.water = water;
    }

    public void pour(int amount) {
        this.water = this.water - amount;
    }

    public int cupsLeft() {
        return this.water / 250;
    }

    public boolean isEmpty() {
        return this.water == 0;
    }
}
