// AI-Generated
package module41_packages_and_imports_ai.step03_access_across_packages_ai.challenge03_ai.laundromat.domain;

public class Machine {
    int number;
    int minutesLeft;

    Machine(int number) {
        this.number = number;
        this.minutesLeft = 0;
    }

    void start(int minutes) {
        this.minutesLeft = minutes;
    }

    void pass(int minutes) {
        this.minutesLeft -= minutes;
        if (this.minutesLeft < 0) {
            this.minutesLeft = 0;
        }
    }

    void stopNow() {
        this.minutesLeft = 0;
    }

    @Override
    public String toString() {
        if (this.minutesLeft == 0) {
            return "Machine " + this.number + ": free";
        }
        return "Machine " + this.number + ": " + this.minutesLeft + " minutes left";
    }
}
