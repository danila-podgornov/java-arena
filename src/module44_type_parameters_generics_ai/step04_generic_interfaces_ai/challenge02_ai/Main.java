// AI-Generated
package module44_type_parameters_generics_ai.step04_generic_interfaces_ai.challenge02_ai;

public class Main {
    /**
     * A shoe shop's app checks the sizes in stock and the names on its gift cards. {@code Rule}, {@code MinLength} and {@code OneOf} are this step's. Look at when 42 is added. What does this program print?
     * Hints
     * 1. {@code Rule<Integer> sizes = inStock;} doesn't copy anything: {@code sizes} and {@code inStock} refer to the same OneOf object, so the 42 added afterwards is in it too.
     * 2. MinLength(3) allows Strings of 3 characters or more: Bea and Christopher. Al has 2, and the empty String has 0.
     */
    public static void main(String[] args) {
        OneOf<Integer> inStock = new OneOf<>();
        inStock.add(38);
        inStock.add(40);
        Rule<Integer> sizes = inStock;
        inStock.add(42);
        System.out.println(sizes.allows(42) + " " + sizes.allows(39));

        Rule<String> name = new MinLength(3);
        String[] names = {"Al", "Bea", "Christopher", ""};
        int count = 0;
        for (String n : names) {
            if (name.allows(n)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
