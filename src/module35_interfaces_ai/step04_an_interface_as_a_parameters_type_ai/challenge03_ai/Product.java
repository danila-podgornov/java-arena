// AI-Generated
package module35_interfaces_ai.step04_an_interface_as_a_parameters_type_ai.challenge03_ai;

public class Product implements Priced {
    private String name;
    private int dollars;

    public Product(String name, int dollars) {
        this.name = name;
        this.dollars = dollars;
    }

    @Override
    public String label() {
        return this.name;
    }

    @Override
    public int price() {
        return this.dollars;
    }
}
