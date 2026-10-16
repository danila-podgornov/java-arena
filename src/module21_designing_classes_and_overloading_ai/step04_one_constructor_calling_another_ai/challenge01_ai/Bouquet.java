// AI-Generated
package module21_designing_classes_and_overloading_ai.step04_one_constructor_calling_another_ai.challenge01_ai;

public class Bouquet {
    private String flower;
    private int stems;

    public Bouquet(String flower, int stems) {
        this.flower = flower;
        this.stems = stems;
        if (this.stems < 1) {
            this.stems = 1;
        }
    }

    // Write the second constructor here.

    public String toString() {
        return this.stems + " " + this.flower;
    }
}
