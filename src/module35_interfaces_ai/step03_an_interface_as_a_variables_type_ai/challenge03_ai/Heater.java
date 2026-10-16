// AI-Generated
package module35_interfaces_ai.step03_an_interface_as_a_variables_type_ai.challenge03_ai;

public class Heater implements Switchable {
    private String room;
    private int degrees;
    private boolean on;

    public Heater(String room, int degrees) {
        this.room = room;
        this.degrees = degrees;
        this.on = false;
    }

    @Override
    public void turnOn() {
        this.on = true;
    }

    @Override
    public void turnOff() {
        this.on = false;
    }

    @Override
    public boolean isOn() {
        return this.on;
    }

    @Override
    public String toString() {
        if (this.on) {
            return "Heater in the " + this.room + ": on, " + this.degrees + " degrees";
        }
        return "Heater in the " + this.room + ": off";
    }
}
