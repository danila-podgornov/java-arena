// AI-Generated
package module50_gui_multiple_views_ai.step05_logic_apart_from_the_views_ai.challenge01_ai;

public class Main {
    /**
     * A travel agency books seats on its excursions. Write the logic, the class {@code Excursion} in {@code Excursion.java} (no JavaFX in it):
     * <ul>
     * <li>a constructor {@code Excursion(String name, int seats)}: at first every seat is free
     * <li>{@code book(int count)}: when {@code count} is at least 1 and at most the number of free seats, books that many seats and returns {@code true}; otherwise books nothing and returns {@code false}
     * <li>{@code free()}: returns the number of free seats
     * <li>{@code toString()}: returns {@code Island tour: 37 of 40 seats free} (with the name, the free seats and all seats), or {@code Island tour: sold out} when no seat is free
     * </ul>
     * <p>{@code Main.java} is a test drive in the console. The check runs:
     * <pre>{@code
     * Excursion trip = new Excursion("Island tour", 40);
     * System.out.println(trip.book(3));
     * System.out.println(trip.book(0));
     * System.out.println(trip);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * false
     * Island tour: 37 of 40 seats free
     * }</pre>
     * Hints
     * 1. Keep the name, the number of seats and the number booked in instance variables. {@code free()} is then {@code this.seats - this.booked}.
     * 2. {@code book} first checks {@code count < 1 || count > this.free()} and returns {@code false} for those; otherwise it adds {@code count} to the booked seats and returns {@code true}. {@code toString} checks {@code this.free() == 0} for the sold-out text.
     */
    public static void main(String[] args) {
        Excursion trip = new Excursion("Island tour", 40);
        System.out.println(trip.book(3));
        System.out.println(trip.book(0));
        System.out.println(trip);
    }
}
