// AI-Generated
package module36_polymorphism_ai.step04_choosing_a_design_and_the_end_of_part_9_ai.challenge03_ai;

public class Main {
    /**
     * To end part 9: the toll booth's records, which bring together a class hierarchy, an interface, {@code instanceof}, and a hash map from part 8. {@code Vehicle.java}, {@code Truck.java} and {@code Commercial.java} are step 1's. Write:
     * <ul>
     * <li>In {@code Van.java}, the class {@code Van}. A delivery van is a Vehicle, and it works for a company. Its constructor is {@code Van(String plate, String company)}, it pays a toll of 7, and it's Commercial.
     * <li>In {@code TollBooth.java}:
     * <li>the constructor,
     * <li>{@code pass(Vehicle vehicle)}, which records a vehicle going through the booth,
     * <li>{@code total()}, which returns all the tolls paid so far, added up,
     * <li>{@code billFor(String company)}, which returns the tolls of that company's vehicles added up, or 0 for a company with none,
     * <li>{@code companies()}, which returns a new list of the companies that have a bill, each once, in alphabetical order.
     * </ul>
     * <p>A {@code HashMap<String, Integer>} from a company to its bill is one good way to keep the bills. {@code Main.java} is a test drive, and it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * 49
     * 21
     * 0
     * [Birch Haulage, Nordic Freight, Swift Parcels]
     * }</pre>
     * Hints
     * 1. Van is step 1's Truck without the axles: {@code public class Van extends Vehicle implements Commercial}, a constructor that hands the plate on with {@code super(plate)}, and {@code toll()} and {@code company()} with {@code @Override}.
     * 2. In TollBooth, keep the total in an {@code int} and the bills in a {@code HashMap<String, Integer>}, both set in the constructor. {@code pass} adds the vehicle's {@code toll()} to the total and, when {@code vehicle instanceof Commercial}, casts it, and adds the toll to its company's bill with {@code getOrDefault(company, 0)}. {@code companies()} sorts a copy of the keys, as in module 33.
     */
    public static void main(String[] args) {
        TollBooth booth = new TollBooth();
        booth.pass(new Van("VN-7", "Swift Parcels"));
        booth.pass(new Vehicle("MC-40"));
        booth.pass(new Truck("TR-88", "Nordic Freight", 3));
        booth.pass(new Van("VN-9", "Swift Parcels"));
        booth.pass(new Truck("TR-21", "Birch Haulage", 2));
        booth.pass(new Van("VN-7", "Swift Parcels"));
        System.out.println(booth.total());
        System.out.println(booth.billFor("Swift Parcels"));
        System.out.println(booth.billFor("Metro Cabs"));
        System.out.println(booth.companies());
    }
}
