// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step05_changing_a_class_without_changing_its_users_ai.challenge03_ai;

public class Thermometer {
    private int count;
    private int lowest;
    private int highest;

    public Thermometer() {
        this.count = 0;
        this.lowest = 0;
        this.highest = 0;
    }

    public void record(int degrees) {
        if (degrees < this.lowest) {
            this.lowest = degrees;
        }
        if (degrees > this.highest) {
            this.highest = degrees;
        }
        this.count++;
    }

    public int count() {
        return this.count;
    }

    public int lowest() {
        return this.lowest;
    }

    public int highest() {
        return this.highest;
    }
}
