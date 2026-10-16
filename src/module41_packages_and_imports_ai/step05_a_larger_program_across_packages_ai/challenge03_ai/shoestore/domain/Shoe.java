// AI-Generated
package module41_packages_and_imports_ai.step05_a_larger_program_across_packages_ai.challenge03_ai.shoestore.domain;

public class Shoe {
    private String model;
    private int size;

    public Shoe(String model, int size) {
        this.model = model;
        this.size = size;
    }

    public String getModel() {
        return this.model;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return this.model + ", size " + this.size;
    }
}
