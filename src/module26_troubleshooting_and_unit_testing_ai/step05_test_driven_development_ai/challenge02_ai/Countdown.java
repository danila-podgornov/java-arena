// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step05_test_driven_development_ai.challenge02_ai;

public class Countdown {
    private int seconds;

    public Countdown(int seconds) {
        this.seconds = seconds;
    }

    public void tick() {
        if (this.seconds > 0) {
            this.seconds--;
        }
    }

    public void reset() {
    }

    public int secondsLeft() {
        return this.seconds;
    }
}
