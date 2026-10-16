// AI-Generated
package module35_interfaces_ai.step03_an_interface_as_a_variables_type_ai.challenge03_ai;

public class CeilingFan implements Switchable {
    private int speed;

    @Override
    public void turnOn() {
        if (this.speed == 0) {
            this.speed = 1;
        }
    }

    @Override
    public void turnOff() {
        this.speed = 0;
    }

    @Override
    public boolean isOn() {
        return this.speed > 0;
    }

    @Override
    public String toString() {
        return "Ceiling fan: speed " + this.speed;
    }
}
