// AI-Generated
package module24_lists_inside_objects_ai.step05_printing_an_object_that_holds_a_list_ai.challenge03_ai;

public class Main {
    /**
     * {@code Bus.java} holds the bus's line number and a list of passenger names. Write its toString: the line number, a colon, and the names in the order they boarded, as you'd write them in a sentence. Commas go between the names, except that the last two are joined with {@code and}, like {@code Bus 42: Ada, Ben and Cleo}. With one passenger, it's just {@code Bus 42: Ada}. The check prints only buses with at least one passenger:
     * <pre>{@code
     * Bus bus = new Bus(42);
     * bus.board("Ada");
     * System.out.println(bus);
     * bus.board("Ben");
     * System.out.println(bus);
     * bus.board("Cleo");
     * System.out.println(bus);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Bus 42: Ada
     * Bus 42: Ada and Ben
     * Bus 42: Ada, Ben and Cleo
     * }</pre>
     * Hints
     * 1. Loop over the indexes, as the necklace does, so that you know where each name is. The first name gets nothing in front of it, the last one (when it isn't also the first) gets {@code and} with a space on each side, and every other one gets a comma and a space.
     * 2. In {@code for (int i = 0; i < this.passengers.size(); i++)}: {@code if (i > 0 && i == this.passengers.size() - 1)} adds {@code " and "}, {@code else if (i > 0)} adds {@code ", "}, and then the name {@code this.passengers.get(i)} is added.
     */
    public static void main(String[] args) {
        Bus bus = new Bus(42);
        bus.board("Ada");
        System.out.println(bus);
        bus.board("Ben");
        System.out.println(bus);
        bus.board("Cleo");
        System.out.println(bus);
    }
}
