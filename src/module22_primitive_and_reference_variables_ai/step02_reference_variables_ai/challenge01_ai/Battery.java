// AI-Generated
package module22_primitive_and_reference_variables_ai.step02_reference_variables_ai.challenge01_ai;

public class Battery {
    private int percent;

    public Battery(int percent) {
        this.percent = percent;
    }

    public void use(int amount) {
        this.percent = this.percent - amount;
    }

    public String toString() {
        return this.percent + "%";
    }
}
