package module03_variables_and_types.step02_changing_a_value;

public class Challenge03 {
    /**
     * A price with cents doesn't fit in an int, so this program doesn't compile. Choose the right type for price so it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Price: 4.99
     * Sale price: 3.99
     * }</pre>
     */
    public static void main(String[] args) {
        double price = 4.99;
        System.out.println("Price: " + price);
        price = 3.99;
        System.out.println("Sale price: " + price);
    }
}
