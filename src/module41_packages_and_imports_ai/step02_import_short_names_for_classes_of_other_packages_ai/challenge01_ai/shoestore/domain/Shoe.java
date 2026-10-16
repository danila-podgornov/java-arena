// AI-Generated
package module41_packages_and_imports_ai.step02_import_short_names_for_classes_of_other_packages_ai.challenge01_ai.shoestore.domain;

public class Shoe {
    private String model;
    private int size;

    public Shoe(String model, int size) {
        this.model = model;
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return this.model + ", size " + this.size;
    }
}
