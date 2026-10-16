// AI-Generated
package module41_packages_and_imports_ai.step01_packages_classes_in_folders_ai.challenge03_ai.apiary.domain;

import java.util.ArrayList;

public class Hive {
    private String name;
    private ArrayList<Harvest> harvests;

    public Hive(String name) {
        this.name = name;
        this.harvests = new ArrayList<>();
    }

    public void add(Harvest harvest) {
        this.harvests.add(harvest);
    }

    public int totalGrams() {
        int total = 0;
        for (Harvest harvest : this.harvests) {
            total += harvest.getGrams();
        }
        return total;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.harvests.size() + " harvests, " + this.totalGrams() + " grams";
    }
}
