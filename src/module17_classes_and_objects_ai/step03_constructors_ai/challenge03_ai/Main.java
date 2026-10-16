// AI-Generated
package module17_classes_and_objects_ai.step03_constructors_ai.challenge03_ai;

public class Main {
    /**
     * This time, write the instance variables and the constructor yourself. A {@code Concert} has a band and a city (both Strings) and a ticket price in euros (an int), in instance variables called {@code band}, {@code city} and {@code price}. The constructor takes them in that order. The method {@code printPoster()} is already there. The check runs:
     * <pre>{@code
     * Concert show = new Concert("The Owls", "Lisbon", 25);
     * show.printPoster();
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * The Owls live in Lisbon!
     * Tickets 25 euros
     * }</pre>
     * Hints
     * 1. Three private instance variables at the top: {@code private String band;}, {@code private String city;} and {@code private int price;}.
     * 2. The parameters come in the same order as in {@code new Concert("The Owls", "Lisbon", 25)}: {@code public Concert(String band, String city, int price)}. Store each one with {@code this.}, as in {@code this.band = band;}.
     */
    public static void main(String[] args) {
        Concert show = new Concert("The Owls", "Lisbon", 25);
        show.printPoster();
    }
}
