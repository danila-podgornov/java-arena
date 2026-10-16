// AI-Generated
package module40_class_diagrams_ai.step06_inheritance_and_abstract_classes_ai.challenge03_ai;

public class Main {
    /**
     * A garden center delivers what its customers buy, by van or by bike. Write the three classes of this diagram, each in its own file:
     * <pre>{@code
     * abstract class Delivery
     * - address: String
     * + Delivery(address: String)
     * + getAddress(): String
     * + cost(): int {abstract}
     * + toString(): String
     *
     * class VanDelivery extends Delivery
     * - pallets: int
     * + VanDelivery(address: String, pallets: int)
     * + cost(): int
     *
     * class BikeDelivery extends Delivery
     * + BikeDelivery(address: String)
     * + cost(): int
     * }</pre>
     * <ul>
     * <li>A van delivery costs 25 dollars, plus 15 for each pallet. A bike delivery costs 8.
     * <li>Every delivery's {@code toString} returns {@code 8 Hill Street: 55 dollars}, with its own address and cost.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Delivery van = new VanDelivery("8 Hill Street", 2);
     * Delivery bike = new BikeDelivery("3 Pond Lane");
     * System.out.println(van);
     * System.out.println(bike);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 8 Hill Street: 55 dollars
     * 3 Pond Lane: 8 dollars
     * }</pre>
     * Hints
     * 1. Start with Delivery: {@code public abstract class Delivery}, with the address, a constructor, {@code getAddress}, {@code public abstract int cost();}, and a {@code toString} that calls {@code cost()}.
     * 2. Each subclass {@code extends Delivery}, passes the address on with {@code super(address);}, and writes {@code cost()}: 25 plus 15 times the pallets for a van, 8 for a bike.
     */
    public static void main(String[] args) {
        Delivery van = new VanDelivery("8 Hill Street", 2);
        Delivery bike = new BikeDelivery("3 Pond Lane");
        System.out.println(van);
        System.out.println(bike);
    }
}
