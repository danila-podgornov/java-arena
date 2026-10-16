// AI-Generated
package module40_class_diagrams_ai.step01_a_class_as_a_box_ai.challenge03_ai;

public class Shrub {
    public String species;
    private int height;
    private int potLiters;

    public Shrub(String species, int potLiters) {
        this.species = species;
        this.height = 0;
        this.potLiters = potLiters;
    }

    public void grow(double centimeters) {
        this.height += centimeters;
    }

    @Override
    public String toString() {
        return this.species + ": " + this.height + " cm, pot " + this.potLiters + " liters";
    }
}
