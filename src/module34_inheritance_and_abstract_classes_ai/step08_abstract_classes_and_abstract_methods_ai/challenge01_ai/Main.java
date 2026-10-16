// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step08_abstract_classes_and_abstract_methods_ai.challenge01_ai;

public class Main {
    /**
     * The courier makes {@code Shipment} abstract: every shipment has a price, but there's no price for "a shipment" in general. {@code Shipment.java} and {@code Letter.java} are ready. In {@code Pallet.java}, write the class {@code Pallet}, which extends Shipment:
     * <ul>
     * <li>a constructor {@code Pallet(String code, int boxes)}
     * <li>{@code price()}, with {@code @Override} above it, which returns 20 dollars plus 5 for every box
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Shipment pallet = new Pallet("T-40", 6);
     * System.out.println(pallet.label());
     * System.out.println(new Letter("L-3").label());
     * System.out.println(new Pallet("T-41", 0).price());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * T-40: 50 dollars
     * L-3: 2 dollars
     * 20
     * }</pre>
     * Hints
     * 1. Letter shows the pattern: {@code extends Shipment}, a constructor that starts with {@code super(code);}, and {@code price()} with {@code @Override}. Pallet also keeps its number of boxes.
     * 2. {@code price()} returns {@code 20 + 5 * this.boxes}. {@code label()} is Shipment's, and it calls the pallet's own {@code price()}.
     */
    public static void main(String[] args) {
        Shipment pallet = new Pallet("T-40", 6);
        System.out.println(pallet.label());
        System.out.println(new Letter("L-3").label());
        System.out.println(new Pallet("T-41", 0).price());
    }
}
