// AI-Generated
package module41_packages_and_imports_ai.step01_packages_classes_in_folders_ai.challenge03_ai.apiary.domain;

public class Harvest {
    private String month;
    private int grams;

    public Harvest(String month, int grams) {
        this.month = month;
        this.grams = grams;
    }

    public int getGrams() {
        return this.grams;
    }

    @Override
    public String toString() {
        return this.month + ": " + this.grams + " grams";
    }
}
