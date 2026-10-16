// AI-Generated
package module56_records_ai.step01_declaring_a_record_ai.challenge03_ai;

public class Main {
    /**
     * A record can have another record as a component. A map app's {@code Cafe} holds its name, its {@code Pin} and its rating. What does this program print?
     * Hints
     * 1. A record's {@code toString} writes the record's name, then each component as {@code name=value} in square brackets. A component that is itself a record is written with its own {@code toString}.
     * 2. A String component is written without quotes. {@code "Blue Door".length()} is 9 (the space counts), and the pin's {@code y()} is 7, two ints that add up.
     */
    public static void main(String[] args) {
        Cafe corner = new Cafe("Blue Door", new Pin(2, 7), 4.5);
        System.out.println(corner);
        System.out.println(corner.pin());
        System.out.println(corner.name().length() + corner.pin().y());
    }
}
