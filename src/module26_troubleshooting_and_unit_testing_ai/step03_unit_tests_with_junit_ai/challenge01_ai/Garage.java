// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step03_unit_tests_with_junit_ai.challenge01_ai;

public class Garage {
    private int spots;
    private int parked;

    public Garage(int spots) {
        this.spots = spots;
        this.parked = 0;
    }

    public boolean park() {
        if (this.parked < this.spots) {
            this.parked++;
            return true;
        }
        return false;
    }

    public void leave() {
        if (this.parked > 0) {
            this.parked--;
        }
    }

    public int freeSpots() {
        return this.spots - this.parked;
    }
}
