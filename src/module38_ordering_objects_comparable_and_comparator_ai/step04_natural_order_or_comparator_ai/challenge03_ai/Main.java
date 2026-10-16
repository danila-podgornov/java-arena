// AI-Generated
package module38_ordering_objects_comparable_and_comparator_ai.step04_natural_order_or_comparator_ai.challenge03_ai;

public class Main {
    /**
     * To end the module, the departures board again, now with a natural order. A board lists flights by time: that's the order anyone expects of it, so it becomes Flight's natural order. The gate staff want another order, so that one is a comparator. Write:
     * <ul>
     * <li>In {@code Flight.java}: make Flight implement {@code Comparable<Flight>}. Flights go by departure time, and flights that leave at the same time by destination, alphabetically.
     * <li>In {@code Board.java}, the class {@code Board}, which keeps its flights in a list:
     * <li>the constructor, and {@code add(Flight flight)}, which adds a flight to the board
     * <li>{@code departures()}, which returns a new list of all the flights in their natural order
     * <li>{@code atGate(int gate)}, which returns a new list of the flights from that gate, in their natural order
     * <li>{@code byGate()}, which returns a new list of all the flights sorted by gate number, and the flights of the same gate by departure time
     * </ul>
     * <p>The lists that the methods return are new lists, not the board's own: flights added to the board later don't show up in a list it returned before. {@code Main.java} is a test drive, and it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * [07:45 Oslo (gate 12), 09:05 Riga (gate 12), 09:30 Dublin (gate 4), 13:10 Athens (gate 2), 13:10 Lisbon (gate 4)]
     * [07:45 Oslo (gate 12), 09:05 Riga (gate 12)]
     * [13:10 Athens (gate 2), 09:30 Dublin (gate 4), 13:10 Lisbon (gate 4), 07:45 Oslo (gate 12), 09:05 Riga (gate 12)]
     * }</pre>
     * Hints
     * 1. Flight's {@code compareTo} follows step 3's pattern for two criteria. The times are Strings, so their own {@code compareTo} compares them. In Board, keep a {@code List<Flight>} that the constructor creates, and let {@code add} add to it.
     * 2. Flight's {@code compareTo} starts with {@code int byTime = this.departs.compareTo(other.departs);}, returns {@code byTime} when it isn't 0, and otherwise compares the destinations. In Board, each method can be one stream that ends with {@code collect(Collectors.toList())}, which makes a new list. {@code departures} uses {@code sorted()}, {@code atGate} puts a {@code filter} on the gate before {@code sorted()}, and {@code byGate} uses {@code sorted(Comparator.comparing(Flight::getGate).thenComparing(Flight::getDeparts))}.
     */
    public static void main(String[] args) {
        Board board = new Board();
        board.add(new Flight("Lisbon", "13:10", 4));
        board.add(new Flight("Oslo", "07:45", 12));
        board.add(new Flight("Dublin", "09:30", 4));
        board.add(new Flight("Athens", "13:10", 2));
        board.add(new Flight("Riga", "09:05", 12));
        System.out.println(board.departures());
        System.out.println(board.atGate(12));
        System.out.println(board.byGate());
    }
}
