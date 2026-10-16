// AI-Generated
package module56_records_ai.step01_declaring_a_record_ai.challenge01_ai;

public class Main {
    /**
     * A city map app marks places with pins, each at a column {@code x} and a row {@code y} of the map. Fill in the blanks: the word that makes {@code Pin} a record, its second component, the record's name after {@code new}, and the accessor that reads the bakery's column. The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Bakery at 3, 5
     * Library at 8, 1
     * }</pre>
     * Hints
     * 1. A record is declared like a class, with {@code record} in place of {@code class}, and its components in parentheses after the name: {@code public record Pin(int x, int y)}.
     * 2. The accessor of the component {@code x} is {@code x()}, with no {@code get} in front. A record is created with {@code new} and its name, like any object.
     */
    public static void main(String[] args) {
        Pin bakery = new ___(3, 5);
        Pin library = new Pin(8, 1);
        System.out.println("Bakery at " + bakery.___() + ", " + bakery.y());
        System.out.println("Library at " + library.x() + ", " + library.y());
    }
}
