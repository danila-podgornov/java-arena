// AI-Generated
package module35_interfaces_ai.step02_many_classes_many_interfaces_ai.challenge01_ai;

public class Main {
    /**
     * The family's electric scooter shows up in the app too. {@code Switchable.java} and {@code Chargeable.java} are ready. In {@code ElectricScooter.java}, write the class {@code ElectricScooter}, which implements both interfaces, with:
     * <ul>
     * <li>a constructor {@code ElectricScooter(int battery)}, which takes the battery's percentage; a new scooter is off
     * <li>{@code turnOn()}, {@code turnOff()} and {@code isOn()}, as for any Switchable
     * <li>{@code batteryPercent()}, which returns the battery's percentage
     * <li>{@code charge(int minutes)}, which adds 2 percent for every minute, but never goes above 100
     * <li>{@code ride(int km)}, which uses 5 percent for every kilometer, but only when the scooter is on, and never goes below 0
     * </ul>
     * <p>Put {@code @Override} above each method that an interface asks for. The check runs:
     * <pre>{@code
     * ElectricScooter scooter = new ElectricScooter(40);
     * scooter.ride(3);
     * System.out.println(scooter.batteryPercent());
     * scooter.turnOn();
     * scooter.ride(3);
     * System.out.println(scooter.isOn() + " " + scooter.batteryPercent());
     * scooter.charge(50);
     * System.out.println(scooter.batteryPercent());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 40
     * true 25
     * 100
     * }</pre>
     * Hints
     * 1. The header is <code>public class ElectricScooter implements Switchable, Chargeable {</code>. The class needs two instance variables: the battery's percentage and whether the scooter is on.
     * 2. {@code charge} adds {@code 2 * minutes}, and then sets the battery back to 100 if it went above. {@code ride} does nothing unless the scooter is on; otherwise it takes away {@code 5 * km}, and sets the battery back to 0 if it went below. {@code ride} is the scooter's own, so it has no {@code @Override}.
     */
    public static void main(String[] args) {
        ElectricScooter scooter = new ElectricScooter(40);
        scooter.ride(3);
        System.out.println(scooter.batteryPercent());
        scooter.turnOn();
        scooter.ride(3);
        System.out.println(scooter.isOn() + " " + scooter.batteryPercent());
        scooter.charge(50);
        System.out.println(scooter.batteryPercent());
    }
}
