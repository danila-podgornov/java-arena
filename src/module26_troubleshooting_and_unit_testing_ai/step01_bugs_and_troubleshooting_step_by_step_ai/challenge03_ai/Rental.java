// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step01_bugs_and_troubleshooting_step_by_step_ai.challenge03_ai;

public class Rental {
    private int hours;

    public Rental(int hours) {
        this.hours = hours;
    }

    public int fee() {
        if (this.hours <= 1) {
            return 3;
        }
        return 3 + this.hours * 2;
    }
}
