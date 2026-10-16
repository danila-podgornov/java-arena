// AI-Generated
package module41_packages_and_imports_ai.step03_access_across_packages_ai.challenge03_ai.laundromat.dryers;

import module41_packages_and_imports_ai.step03_access_across_packages_ai.challenge03_ai.laundromat.domain.Machine;

public class Dryer extends Machine {
    public Dryer(int number) {
        super(number);
    }

    public void addTime(int minutes) {
        if (this.minutesLeft > 0) {
            this.minutesLeft += minutes;
        }
    }
}
