// AI-Generated
package module35_interfaces_ai.step03_an_interface_as_a_variables_type_ai.challenge01_ai;

public class Laptop implements Chargeable {
    private int battery;

    public Laptop(int battery) {
        this.battery = battery;
    }

    @Override
    public int batteryPercent() {
        return this.battery;
    }

    @Override
    public void charge(int minutes) {
        this.battery += minutes;
        if (this.battery > 100) {
            this.battery = 100;
        }
    }
}
