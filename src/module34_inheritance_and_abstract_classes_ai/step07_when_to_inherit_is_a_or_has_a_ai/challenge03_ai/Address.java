// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step07_when_to_inherit_is_a_or_has_a_ai.challenge03_ai;

public class Address {
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    @Override
    public String toString() {
        return this.street + ", " + this.city;
    }
}
