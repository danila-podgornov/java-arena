// AI-Generated
package module38_ordering_objects_comparable_and_comparator_ai.step01_comparable_a_natural_order_for_your_class_ai.challenge01_ai;

public class Apartment {
    private String street;
    private int rent;

    public Apartment(String street, int rent) {
        this.street = street;
        this.rent = rent;
    }

    public String getStreet() {
        return this.street;
    }

    public int getRent() {
        return this.rent;
    }

    @Override
    public String toString() {
        return this.street + " (" + this.rent + ")";
    }
}
