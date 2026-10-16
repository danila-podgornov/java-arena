// AI-Generated
package module36_polymorphism_ai.step04_choosing_a_design_and_the_end_of_part_9_ai.challenge02_ai;

import java.util.ArrayList;

public class Main {
    /**
     * The toll booth from step 1, with step 1's TankerTruck, which pays 10 more than a Truck. What does this program print?
     * Hints
     * 1. A TankerTruck is a Truck, so {@code instanceof Truck} counts it, and it's Commercial through Truck. The motorbike is neither.
     * 2. Coastal Fuels has the tanker, with 2 axles, 10 + 10, and a truck with 1 axle. Printing an element runs Vehicle's {@code toString} with the object's own {@code toll()}, even through an Object variable.
     */
    public static void main(String[] args) {
        ArrayList<Vehicle> passed = new ArrayList<>();
        passed.add(new Vehicle("MC-40"));
        passed.add(new TankerTruck("TK-4", "Coastal Fuels", 2));
        passed.add(new Truck("TR-88", "Coastal Fuels", 1));
        passed.add(new Truck("TR-21", "Birch Haulage", 3));

        int trucks = 0;
        int coastal = 0;
        for (Vehicle vehicle : passed) {
            if (vehicle instanceof Truck) {
                trucks++;
            }
            if (vehicle instanceof Commercial) {
                Commercial customer = (Commercial) vehicle;
                if (customer.company().equals("Coastal Fuels")) {
                    coastal += vehicle.toll();
                }
            }
        }
        System.out.println(trucks + " " + coastal);
        System.out.println(passed.get(1));
        Object last = passed.get(3);
        System.out.println(last);
    }
}
