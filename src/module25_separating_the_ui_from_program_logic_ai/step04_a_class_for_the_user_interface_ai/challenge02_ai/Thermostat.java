// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step04_a_class_for_the_user_interface_ai.challenge02_ai;

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
