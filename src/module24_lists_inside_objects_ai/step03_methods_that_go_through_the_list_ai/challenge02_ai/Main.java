// AI-Generated
package module24_lists_inside_objects_ai.step03_methods_that_go_through_the_list_ai.challenge02_ai;

public class Main {
    /**
     * What does this program print? Look at which {@code contains} each method uses: the list's, or the String's.
     * Hints
     * 1. {@code has} asks the list, and the list's {@code contains} looks for a value that equals the whole String. No item is exactly {@code coat}, but one is exactly {@code scarf}.
     * 2. {@code count} uses the String's {@code contains}, which looks for the word inside each item: {@code blue coat} and {@code red coat} have {@code coat} in them, and {@code red scarf} and {@code red coat} have {@code red}.
     */
    public static void main(String[] args) {
        Wardrobe wardrobe = new Wardrobe();
        wardrobe.hang("red scarf");
        wardrobe.hang("blue coat");
        wardrobe.hang("red coat");
        wardrobe.hang("scarf");
        System.out.println(wardrobe.has("coat"));
        System.out.println(wardrobe.has("scarf"));
        System.out.println(wardrobe.count("coat"));
        System.out.println(wardrobe.count("red"));
    }
}
