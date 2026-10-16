// AI-Generated
package module36_polymorphism_ai.step01_hierarchies_one_object_many_types_ai.challenge03_ai;

public class Main {
    /**
     * Some trucks carry fuel, and pay 10 more than other trucks with the same number of axles. In {@code TankerTruck.java}, write the class {@code TankerTruck}, which extends Truck, with:
     * <ul>
     * <li>a constructor {@code TankerTruck(String plate, String company, int axles)}
     * <li>{@code toll()} overridden to return Truck's toll plus 10: get Truck's toll with {@code super.toll()}
     * </ul>
     * <p>Don't write {@code implements Commercial} or {@code company()}: a TankerTruck gets both from Truck. The check runs:
     * <pre>{@code
     * TankerTruck tanker = new TankerTruck("TK-4", "Coastal Fuels", 3);
     * Vehicle vehicle = tanker;
     * Commercial customer = tanker;
     * Truck truck = tanker;
     * System.out.println(vehicle);
     * System.out.println(customer.company() + " " + truck.toll());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * TK-4 pays 25
     * Coastal Fuels 25
     * }</pre>
     * Hints
     * 1. Start with <code>public class TankerTruck extends Truck {</code>. The constructor hands all three values to Truck's constructor with {@code super(plate, company, axles);}.
     * 2. Override {@code toll()}, with {@code @Override} above it, and return {@code super.toll() + 10}. Everything else, {@code company()} and being Commercial included, comes from Truck.
     */
    public static void main(String[] args) {
        TankerTruck tanker = new TankerTruck("TK-4", "Coastal Fuels", 3);
        Vehicle vehicle = tanker;
        Commercial customer = tanker;
        Truck truck = tanker;
        System.out.println(vehicle);
        System.out.println(customer.company() + " " + truck.toll());
    }
}
