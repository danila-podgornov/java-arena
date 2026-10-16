// AI-Generated
package module21_designing_classes_and_overloading_ai.step04_one_constructor_calling_another_ai.challenge01_ai;

public class Main {
    /**
     * {@code Bouquet.java} has a constructor that takes a kind of flower and a number of stems. Add a second constructor, {@code Bouquet(String flower)}, for the florist's usual bouquet of 12 stems. Don't store the values in it: call the other constructor with {@code this(...)}. The check runs:
     * <pre>{@code
     * Bouquet usual = new Bouquet("tulips");
     * Bouquet small = new Bouquet("roses", 5);
     * System.out.println(usual);
     * System.out.println(small);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 12 tulips
     * 5 roses
     * }</pre>
     * Hints
     * 1. The new constructor's header is <code>public Bouquet(String flower) {</code>.
     * 2. Its only line runs the other constructor, with the flower and the default number of stems: {@code this(flower, 12);}.
     */
    public static void main(String[] args) {
        Bouquet usual = new Bouquet("tulips");
        Bouquet small = new Bouquet("roses", 5);
        System.out.println(usual);
        System.out.println(small);
    }
}
