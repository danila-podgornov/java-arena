// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step03_the_programs_logic_in_a_class_ai.challenge02_ai;

public class Thermostat {
    private int target;

    public Thermostat(int target) {
        this.target = target;
    }

    public boolean warmer() {
        if (this.target >= 28) {
            return false;
        }
        this.target++;
        return true;
    }

    public boolean cooler() {
        if (this.target <= 15) {
            return false;
        }
        this.target--;
        return true;
    }

    public int getTarget() {
        return this.target;
    }
}
