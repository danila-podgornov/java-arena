// AI-Generated
package module23_objects_working_together_ai.step04_equal_objects_ai.challenge01_ai;

public class Main {
    /**
     * Two playing cards are equal when they have the same suit and the same rank. In {@code PlayingCard.java}, write the method {@code equals}, in the way shown above. The check runs:
     * <pre>{@code
     * PlayingCard first = new PlayingCard("hearts", 7);
     * PlayingCard second = new PlayingCard("hearts", 7);
     * PlayingCard third = new PlayingCard("spades", 7);
     * System.out.println(first.equals(second));
     * System.out.println(first.equals(third));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * false
     * }</pre>
     * Hints
     * 1. Follow the Seat's {@code equals} from the lesson, with PlayingCard in place of Seat: the same header, the same two checks and the cast, and at the end a comparison of the suit and the rank. The suit is a String, so it's compared with {@code equals}.
     * 2. <code>public boolean equals(Object compared) {</code>, then {@code if (this == compared) { return true; }}, {@code if (!(compared instanceof PlayingCard)) { return false; }}, {@code PlayingCard other = (PlayingCard) compared;} and last {@code return this.suit.equals(other.suit) && this.rank == other.rank;}.
     */
    public static void main(String[] args) {
        PlayingCard first = new PlayingCard("hearts", 7);
        PlayingCard second = new PlayingCard("hearts", 7);
        PlayingCard third = new PlayingCard("spades", 7);
        System.out.println(first.equals(second));
        System.out.println(first.equals(third));
    }
}
