// AI-Generated
package module40_class_diagrams_ai.step03_from_code_to_a_box_ai.challenge03_ai;

import java.util.ArrayList;

public class Main {
    /**
     * The recycling center's truck driver wants to know how many kilos are still to be collected on a route. {@code Pickup.java} is ready, and you don't need to read it: its box says all you need.
     * <pre>{@code
     * class Pickup
     * - address: String
     * - kilos: double
     * - done: boolean
     * + Pickup(address: String, kilos: double)
     * + getAddress(): String
     * + getKilos(): double
     * + isDone(): boolean
     * + markDone(): void
     * + toString(): String
     * }</pre>
     * <p>In {@code Main.java}, write the method {@code public static double kilosLeft(ArrayList<Pickup> pickups)}, which returns the kilos of the pickups that aren't done yet, added up. The check runs:
     * <pre>{@code
     * ArrayList<Pickup> route = new ArrayList<>();
     * route.add(new Pickup("12 Mill Road", 35.5));
     * route.add(new Pickup("4 Elm Street", 20.0));
     * route.add(new Pickup("9 Quay Lane", 12.25));
     * route.get(1).markDone();
     * System.out.println(kilosLeft(route));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code 47.75}
     * Hints
     * 1. The box tells you what to call: {@code isDone()} gives a boolean and {@code getKilos()} a double. Start from {@code double total = 0;} and go through the list with a for-each loop.
     * 2. Add a pickup's {@code getKilos()} to the total only {@code if (!pickup.isDone())}, and return the total after the loop.
     */
    public static void main(String[] args) {
        ArrayList<Pickup> route = new ArrayList<>();
        route.add(new Pickup("12 Mill Road", 35.5));
        route.add(new Pickup("4 Elm Street", 20.0));
        route.add(new Pickup("9 Quay Lane", 12.25));
        route.get(1).markDone();
        System.out.println(kilosLeft(route));
    }

    // Write the method kilosLeft here.
}
