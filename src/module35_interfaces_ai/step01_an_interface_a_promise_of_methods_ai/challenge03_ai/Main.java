// AI-Generated
package module35_interfaces_ai.step01_an_interface_a_promise_of_methods_ai.challenge03_ai;

public class Main {
    /**
     * The garage door opener implements Switchable too, but {@code GarageDoor.java} doesn't compile. Read javac's messages and fix the class: {@code turnOn} opens the door, {@code turnOff} closes it, and {@code isOn} should say whether the door is open. Keep {@code isOpen} as it is, since other code uses it. Put {@code @Override} above each of the three methods that Switchable asks for. The program should print: see the expected output below.
     * Expected output
     * <pre>{@code
     * true true
     * false false
     * }</pre>
     * Hints
     * 1. javac finds two problems: {@code turnOn} isn't public, and the class has no {@code isOn()} at all. {@code isOpen} has another name, so it doesn't count as Switchable's {@code isOn}.
     * 2. Write {@code public void turnOn()}, and add a method {@code public boolean isOn()} that returns {@code this.open}. Then put {@code @Override} above {@code turnOn}, {@code turnOff} and {@code isOn}, but not above {@code isOpen}, which Switchable doesn't have.
     */
    public static void main(String[] args) {
        GarageDoor door = new GarageDoor();
        door.turnOn();
        System.out.println(door.isOn() + " " + door.isOpen());
        door.turnOff();
        System.out.println(door.isOn() + " " + door.isOpen());
    }
}
