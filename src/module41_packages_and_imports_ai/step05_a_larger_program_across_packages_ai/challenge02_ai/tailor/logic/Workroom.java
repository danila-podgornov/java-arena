// AI-Generated
package module41_packages_and_imports_ai.step05_a_larger_program_across_packages_ai.challenge02_ai.tailor.logic;

import java.util.ArrayList;
import module41_packages_and_imports_ai.step05_a_larger_program_across_packages_ai.challenge02_ai.tailor.domain.Garment;

public class Workroom {
    private ArrayList<Garment> garments;
    private int nextNumber;

    public Workroom() {
        this.garments = new ArrayList<>();
        this.nextNumber = 1;
    }

    public int drop(String customer, String item) {
        Garment garment = new Garment(customer, item, this.nextNumber);
        this.garments.add(garment);
        this.nextNumber++;
        return garment.getNumber();
    }

    public Garment pickUp(int number) {
        for (Garment garment : this.garments) {
            if (garment.getNumber() == number) {
                this.garments.remove(garment);
                return garment;
            }
        }
        return null;
    }

    public int count() {
        return this.garments.size();
    }
}
