// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step07_when_to_inherit_is_a_or_has_a_ai.challenge03_ai;

public class Main {
    /**
     * Now the courier's classes, done right. {@code Shipment} has a tracking code and a base {@code price()} of 2 dollars, and {@code Address} is the lesson's. In {@code Parcel.java}, write the class {@code Parcel}: a parcel is a shipment, and it has an address to go to. It needs:
     * <ul>
     * <li>a constructor {@code Parcel(String code, Address to, int grams)}
     * <li>{@code price()} overridden: Shipment's price plus 1 dollar for every full 500 grams. Use {@code super.price()}.
     * <li>{@code getTo()}, which returns the address
     * <li>{@code toString()} overridden to return the code, {@code to} and the city of the address
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Parcel parcel = new Parcel("P-310", new Address("9 Dock Road", "Hull"), 1800);
     * System.out.println(parcel);
     * System.out.println(parcel.price());
     * System.out.println(parcel.getTo());
     * Shipment shipment = parcel;
     * System.out.println(shipment.price());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * P-310 to Hull
     * 5
     * 9 Dock Road, Hull
     * 5
     * }</pre>
     * Hints
     * 1. {@code public class Parcel extends Shipment}, with {@code private Address to;} and {@code private int grams;}. The constructor hands the code to Shipment with {@code super(code);}.
     * 2. {@code price()} returns {@code super.price() + this.grams / 500}: int division counts the full 500 grams. {@code toString()} returns {@code this.getCode() + " to " + this.to.getCity()}, since the code is private to Shipment.
     */
    public static void main(String[] args) {
        Parcel parcel = new Parcel("P-310", new Address("9 Dock Road", "Hull"), 1800);
        System.out.println(parcel);
        System.out.println(parcel.price());
        System.out.println(parcel.getTo());
        Shipment shipment = parcel;
        System.out.println(shipment.price());
    }
}
