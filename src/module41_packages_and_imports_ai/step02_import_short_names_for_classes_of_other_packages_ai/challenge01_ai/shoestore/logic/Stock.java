// AI-Generated
package module41_packages_and_imports_ai.step02_import_short_names_for_classes_of_other_packages_ai.challenge01_ai.shoestore.logic;

import java.util.ArrayList;
import module41_packages_and_imports_ai.step02_import_short_names_for_classes_of_other_packages_ai.challenge01_ai.shoestore.domain.Shoe;

public class Stock {
    private ArrayList<Shoe> shoes;

    public Stock() {
        this.shoes = new ArrayList<>();
    }

    public void add(Shoe shoe) {
        this.shoes.add(shoe);
    }

    public int count() {
        return this.shoes.size();
    }

    public int countSize(int size) {
        int count = 0;
        for (Shoe shoe : this.shoes) {
            if (shoe.getSize() == size) {
                count++;
            }
        }
        return count;
    }
}
