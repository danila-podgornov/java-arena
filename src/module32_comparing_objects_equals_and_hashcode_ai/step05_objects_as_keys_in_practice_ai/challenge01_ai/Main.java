// AI-Generated
package module32_comparing_objects_equals_and_hashcode_ai.step05_objects_as_keys_in_practice_ai.challenge01_ai;

public class Main {
    /**
     * A theater keeps its bookings in a {@code HashMap<Seat, String>}, from a seat to the name it's booked for, and the box office wants to see one row at a time. {@code Seat.java} is ready, with {@code equals}, {@code hashCode} and {@code toString}. Write the class {@code Bookings}, with:
     * <ul>
     * <li>a constructor without parameters, which creates the map
     * <li>{@code book(Seat seat, String name)}, which books the seat for the name (booking a seat again replaces the name)
     * <li>{@code printRow(String row, int seats)}, which prints the seats of one row, from number 1 up to {@code seats}, one per line: the seat, a colon, and the name it's booked for, or {@code free}
     * </ul>
     * <p>{@code printRow} can't go through the map's keys: they come in the map's own order, and a free seat isn't a key at all. Go through the seat numbers in order instead, make each seat with {@code new Seat(row, number)}, and look it up. The check runs:
     * <pre>{@code
     * Bookings bookings = new Bookings();
     * bookings.book(new Seat("B", 2), "Ada");
     * bookings.book(new Seat("B", 3), "Ben");
     * bookings.book(new Seat("C", 1), "Cy");
     * bookings.printRow("B", 4);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * B1: free
     * B2: Ada
     * B3: Ben
     * B4: free
     * }</pre>
     * Hints
     * 1. Bookings has one instance variable, {@code private HashMap<Seat, String> holders;}, and the constructor creates it with {@code new HashMap<>()}. {@code book} is one {@code put}: Seat has {@code equals} and {@code hashCode}, so booking an equal seat again replaces the name.
     * 2. In {@code printRow}, loop {@code for (int number = 1; number <= seats; number++)}, make {@code Seat seat = new Seat(row, number);}, and print {@code seat + ": " + this.holders.getOrDefault(seat, "free")}.
     */
    public static void main(String[] args) {
        Bookings bookings = new Bookings();
        bookings.book(new Seat("B", 2), "Ada");
        bookings.book(new Seat("B", 3), "Ben");
        bookings.book(new Seat("C", 1), "Cy");
        bookings.printRow("B", 4);
    }
}
