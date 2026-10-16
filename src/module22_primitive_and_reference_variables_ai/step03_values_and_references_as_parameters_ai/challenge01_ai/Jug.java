// AI-Generated
package module22_primitive_and_reference_variables_ai.step03_values_and_references_as_parameters_ai.challenge01_ai;

public class Jug {
    private int milliliters;

    public Jug(int milliliters) {
        this.milliliters = milliliters;
    }

    public int getMilliliters() {
        return this.milliliters;
    }

    public void add(int milliliters) {
        this.milliliters = this.milliliters + milliliters;
    }

    public void empty() {
        this.milliliters = 0;
    }

    public String toString() {
        return this.milliliters + " ml";
    }
}
