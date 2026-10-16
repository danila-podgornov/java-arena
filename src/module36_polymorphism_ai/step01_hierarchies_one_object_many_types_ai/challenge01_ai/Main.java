// AI-Generated
package module36_polymorphism_ai.step01_hierarchies_one_object_many_types_ai.challenge01_ai;

import java.util.ArrayList;

public class Main {
    /**
     * At the end of the day, the booth adds up the tolls of every vehicle that went through, and lists the companies to bill. Fill in the type of each list. {@code passed} holds all three vehicles, and its loop calls {@code toll()} on each. {@code customers} holds the taxi and the truck, and its loop calls {@code company()}. Each list's type must be one that every object on it has, and that has the method its loop calls. The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Tolls today: 25
     * Bill to Metro Cabs
     * Bill to Nordic Freight
     * }</pre>
     * Hints
     * 1. Go up the tree from each object on the list until you reach a type they all share. The taxi, the car and the truck meet at Vehicle, and Vehicle has {@code toll()}.
     * 2. The taxi and the truck share Vehicle too, but Vehicle has no {@code company()}. The type they share that has it is the interface they both implement.
     */
    public static void main(String[] args) {
        Taxi taxi = new Taxi("TX-12", "Metro Cabs");
        Car car = new Car("CR-55");
        Truck truck = new Truck("TR-88", "Nordic Freight", 3);

        ArrayList<___> passed = new ArrayList<>();
        passed.add(taxi);
        passed.add(car);
        passed.add(truck);
        int total = 0;
        for (int i = 0; i < passed.size(); i++) {
            total += passed.get(i).toll();
        }
        System.out.println("Tolls today: " + total);

        ArrayList<___> customers = new ArrayList<>();
        customers.add(taxi);
        customers.add(truck);
        for (int i = 0; i < customers.size(); i++) {
            System.out.println("Bill to " + customers.get(i).company());
        }
    }
}
