// AI-Generated
package module35_interfaces_ai.step04_an_interface_as_a_parameters_type_ai.challenge01_ai;

public class Main {
    /**
     * In {@code Checkout.java}, write the class {@code Checkout} for the watch shop's till. {@code Priced.java}, {@code Product.java} and {@code Repair.java} are ready. A checkout has:
     * <ul>
     * <li>a constructor without parameters; a new checkout has a total of 0 and no items
     * <li>{@code scan(Priced item)}, which prints the item's line, such as {@code Watch strap: 12 dollars}, adds its price to the total, and counts it
     * <li>{@code total()}, which returns the total in dollars
     * <li>{@code itemCount()}, which returns how many items have been scanned
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Checkout checkout = new Checkout();
     * checkout.scan(new Product("Watch strap", 12));
     * checkout.scan(new Repair(25));
     * System.out.println("Total: " + checkout.total() + " dollars for " + checkout.itemCount() + " items");
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Watch strap: 12 dollars
     * Repair, 25 minutes: 50 dollars
     * Total: 62 dollars for 2 items
     * }</pre>
     * Hints
     * 1. Checkout needs two instance variables: the total and the number of items. Neither of them cares whether an item is a product or a repair.
     * 2. The method is {@code public void scan(Priced item)}. It prints {@code item.label() + ": " + item.price() + " dollars"}, adds {@code item.price()} to the total, and adds one to the count.
     */
    public static void main(String[] args) {
        Checkout checkout = new Checkout();
        checkout.scan(new Product("Watch strap", 12));
        checkout.scan(new Repair(25));
        System.out.println("Total: " + checkout.total() + " dollars for " + checkout.itemCount() + " items");
    }
}
