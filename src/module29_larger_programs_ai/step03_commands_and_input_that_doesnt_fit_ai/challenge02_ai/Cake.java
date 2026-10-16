// AI-Generated
package module29_larger_programs_ai.step03_commands_and_input_that_doesnt_fit_ai.challenge02_ai;

public class Cake {
    private String name;
    private int slices;

    public Cake(String name, int slices) {
        this.name = name;
        this.slices = slices;
    }

    public String getName() {
        return this.name;
    }

    public int getSlices() {
        return this.slices;
    }

    public void sell(int slices) {
        this.slices -= slices;
    }

    public String toString() {
        return this.name + ": " + this.slices + " slices";
    }
}
