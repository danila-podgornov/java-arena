// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step03_unit_tests_with_junit_ai.challenge03_ai;

public class Treadmill {
    private int speed;

    public Treadmill(int speed) {
        this.speed = speed;
    }

    public void faster() {
        if (this.speed < 12) {
            this.speed++;
        }
    }

    public void slower() {
        if (this.speed > 1) {
            this.speed--;
        }
    }

    public int getSpeed() {
        return this.speed;
    }
}
