// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step05_any_type_a_generic_list_ai.challenge01_ai;

public class Main {
    /**
     * A market stall keeps its products and their prices in two lists of one generic class. Fill in the three blanks of {@code SimpleList.java}: the type parameter in the class header, the class of the array that's created, and the return type of {@code get}. The program prints: see the expected output below.
     * Expected output
     * {@code pears: 6.5 in all}
     * Hints
     * 1. The rest of the class already says T: {@code private T[] values;} and {@code add(T value)}.
     * 2. The class header is {@code public class SimpleList<T>}, and {@code get} returns a T. {@code new T[4]} isn't allowed, so the array created is an array of {@code Object}, cast to {@code T[]}, as {@code grow} does.
     */
    public static void main(String[] args) {
        SimpleList<String> products = new SimpleList<>();
        products.add("apples");
        products.add("pears");
        SimpleList<Double> prices = new SimpleList<>();
        prices.add(2.5);
        prices.add(4.0);
        System.out.println(products.get(1) + ": " + (prices.get(0) + prices.get(1)) + " in all");
    }
}
