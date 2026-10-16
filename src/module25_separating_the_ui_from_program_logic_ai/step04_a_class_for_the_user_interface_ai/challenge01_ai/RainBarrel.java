// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step04_a_class_for_the_user_interface_ai.challenge01_ai;

public class RainBarrel {
    private int capacity;
    private int liters;

    public RainBarrel(int capacity) {
        this.capacity = capacity;
        this.liters = 0;
    }

    public void rain(int liters) {
        this.liters = this.liters + liters;
        if (this.liters > this.capacity) {
            this.liters = this.capacity;
        }
    }

    public boolean take(int liters) {
        if (liters > this.liters) {
            return false;
        }
        this.liters = this.liters - liters;
        return true;
    }

    public int getLiters() {
        return this.liters;
    }
}
