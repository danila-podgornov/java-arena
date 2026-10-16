// AI-Generated
package module35_interfaces_ai.step01_an_interface_a_promise_of_methods_ai.challenge02_ai;

public class Main {
    /**
     * A ceiling fan has three speeds, and speed 0 means that it's off. The fan keeps no boolean: {@code isOn} works the answer out from the speed. What does this program print?
     * Hints
     * 1. A new fan's speed is 0, and {@code faster} changes nothing while the fan is off. {@code turnOn} starts the fan at speed 1, but only if it's off.
     * 2. After {@code turnOn}, three calls to {@code faster} stop at speed 3. The second {@code turnOn} finds the fan already running, so it keeps speed 3. {@code turnOff} sets the speed back to 0, and {@code isOn} is worked out from the speed.
     */
    public static void main(String[] args) {
        CeilingFan fan = new CeilingFan();
        fan.faster();
        System.out.println(fan.isOn() + " " + fan.getSpeed());
        fan.turnOn();
        fan.faster();
        fan.faster();
        fan.faster();
        fan.turnOn();
        System.out.println(fan.isOn() + " " + fan.getSpeed());
        fan.turnOff();
        System.out.println(fan.isOn() + " " + fan.getSpeed());
    }
}
