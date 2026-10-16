// AI-Generated
package module35_interfaces_ai.step03_an_interface_as_a_variables_type_ai.challenge01_ai;

public class Headphones implements Chargeable {
    private int battery;

    public Headphones(int battery) {
        this.battery = battery;
    }

    @Override
    public int batteryPercent() {
        return this.battery;
    }

    @Override
    public void charge(int minutes) {
        this.battery += 5 * minutes;
        if (this.battery > 100) {
            this.battery = 100;
        }
    }
}
