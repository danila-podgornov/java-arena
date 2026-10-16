// AI-Generated
package module35_interfaces_ai.step04_an_interface_as_a_parameters_type_ai.challenge03_ai;

public class Main {
    /**
     * The shop starts engraving watches: 3 dollars a letter, but never more than 30 dollars for one engraving. In {@code Engraving.java}, write the class {@code Engraving}, which implements Priced, with:
     * <ul>
     * <li>a constructor {@code Engraving(String text)}, where the text is one word, such as a name, so its {@code length()} is its number of letters
     * <li>{@code label()}, which returns {@code Engraving, Anna}, with the engraving's own text
     * <li>{@code price()}, which returns the price in dollars
     * </ul>
     * <p>{@code Main.java} has this step's {@code printLine}, and it doesn't change: it takes engravings as soon as Engraving implements Priced. The check runs:
     * <pre>{@code
     * printLine(new Engraving("Anna"));
     * printLine(new Engraving("Christopher"));
     * printLine(new Product("Alarm clock", 45));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Engraving, Anna: 12 dollars
     * Engraving, Christopher: 30 dollars
     * Alarm clock: 45 dollars
     * }</pre>
     * Hints
     * 1. Start with <code>public class Engraving implements Priced {</code>, with one instance variable, the text. Both methods have {@code @Override} above them.
     * 2. {@code price()} works out {@code 3 * this.text.length()}, and returns 30 instead when that's more than 30.
     */
    public static void main(String[] args) {
        printLine(new Engraving("Anna"));
        printLine(new Engraving("Christopher"));
        printLine(new Product("Alarm clock", 45));
    }

    public static void printLine(Priced item) {
        System.out.println(item.label() + ": " + item.price() + " dollars");
    }
}
