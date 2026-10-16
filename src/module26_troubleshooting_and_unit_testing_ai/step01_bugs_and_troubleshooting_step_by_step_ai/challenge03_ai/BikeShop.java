// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step01_bugs_and_troubleshooting_step_by_step_ai.challenge03_ai;

import java.util.ArrayList;

public class BikeShop {
    private ArrayList<Rental> rentals;

    public BikeShop() {
        this.rentals = new ArrayList<>();
    }

    public void rent(int hours) {
        this.rentals.add(new Rental(hours));
    }

    public int earnings() {
        int total = 0;
        for (Rental rental : this.rentals) {
            total += rental.fee();
        }
        return total;
    }
}
