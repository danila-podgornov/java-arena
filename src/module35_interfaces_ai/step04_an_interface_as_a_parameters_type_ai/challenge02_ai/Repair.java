// AI-Generated
package module35_interfaces_ai.step04_an_interface_as_a_parameters_type_ai.challenge02_ai;

public class Repair implements Priced {
    private int minutes;

    public Repair(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public String label() {
        return "Repair, " + this.minutes + " minutes";
    }

    @Override
    public int price() {
        return 2 * this.minutes;
    }
}
