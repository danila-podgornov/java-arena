// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step03_constructors_and_super_ai.challenge02_ai;

public class Main {
    /**
     * A courier registers every shipment, and a letter is a shipment. Both constructors print a line. What does this program print?
     * Hints
     * 1. {@code new Letter(...)} runs Letter's constructor, whose first line runs Shipment's constructor to the end. Shipment's line is printed first.
     * 2. Letter hands Shipment the code {@code "L-" + number}, which is {@code L-17}, and that's the code {@code getCode()} returns. The plain Shipment runs only Shipment's constructor.
     */
    public static void main(String[] args) {
        Letter letter = new Letter(17, true);
        System.out.println(letter.getCode());
        Shipment box = new Shipment("S-2");
    }
}
