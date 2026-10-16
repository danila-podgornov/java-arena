// AI-Generated
package module38_ordering_objects_comparable_and_comparator_ai.step01_comparable_a_natural_order_for_your_class_ai.challenge03_ai;

public class Spice {
    private String name;
    private int grams;

    public Spice(String name, int grams) {
        this.name = name;
        this.grams = grams;
    }

    public String getName() {
        return this.name;
    }

    public int getGrams() {
        return this.grams;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.grams + " g)";
    }
}
