// AI-Generated
package module35_interfaces_ai.step09_collection_and_choosing_between_an_interface_and_an_abstract_class_ai.challenge03_ai;

public class Main {
    /**
     * The app's devices now share an abstract class, {@code Appliance}: every appliance has a name, and an abstract method {@code watts()} for the power it uses. Some appliances also run on a battery, and that's what the interface Chargeable is for. {@code Appliance.java}, {@code Chargeable.java} and {@code Toaster.java} are ready. In {@code CordlessVacuum.java}, write the class {@code CordlessVacuum}, which extends Appliance and implements Chargeable, with:
     * <ul>
     * <li>a constructor {@code CordlessVacuum(int battery)}; the appliance's name is always {@code Cordless vacuum}
     * <li>{@code watts()}, which returns 150
     * <li>{@code batteryPercent()}, which returns the battery's percentage
     * <li>{@code charge(int minutes)}, which adds 3 percent for every minute, but never goes above 100
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * CordlessVacuum vacuum = new CordlessVacuum(40);
     * System.out.println(vacuum);
     * vacuum.charge(10);
     * Appliance appliance = vacuum;
     * Chargeable chargeable = vacuum;
     * System.out.println(appliance.getName() + ": " + chargeable.batteryPercent() + "%");
     * System.out.println(new Toaster());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Cordless vacuum, 150 W
     * Cordless vacuum: 70%
     * Toaster, 800 W
     * }</pre>
     * Hints
     * 1. The header is <code>public class CordlessVacuum extends Appliance implements Chargeable {</code>: {@code extends} first. The constructor's first line hands the name to Appliance: {@code super("Cordless vacuum");}.
     * 2. The class keeps the battery in an instance variable of its own. It writes {@code watts()} for Appliance, and {@code batteryPercent()} and {@code charge(int minutes)} for Chargeable, each with {@code @Override}. Appliance's {@code toString} already prints the name and the watts.
     */
    public static void main(String[] args) {
        CordlessVacuum vacuum = new CordlessVacuum(40);
        System.out.println(vacuum);
        vacuum.charge(10);
        Appliance appliance = vacuum;
        Chargeable chargeable = vacuum;
        System.out.println(appliance.getName() + ": " + chargeable.batteryPercent() + "%");
        System.out.println(new Toaster());
    }
}
