// AI-Generated
package module35_interfaces_ai.step01_an_interface_a_promise_of_methods_ai.challenge02_ai;

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

    public void faster() {
        if (this.speed > 0 && this.speed < 3) {
            this.speed++;
        }
    }

    public int getSpeed() {
        return this.speed;
    }
}
