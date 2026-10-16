// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step05_any_type_a_generic_list_ai.challenge03_ai;

public class Main {
    /**
     * A card game keeps a discard pile: each card goes on top, and a player can take the top card, the one put there last. In {@code Pile.java}, write the generic class {@code Pile<T>}, on top of an array of its own, with:
     * <ul>
     * <li>a constructor with no parameters, which creates the array with room for 4 values, as {@code (T[]) new Object[4]}
     * <li>{@code put(T value)}, which puts a value on top; when the array is full, it first moves the values into an array twice as long
     * <li>{@code take()}, which removes the top value from the pile and returns it. On an empty pile, it throws an IllegalStateException with the message {@code The pile is empty}.
     * <li>{@code size()}, which returns the number of values in the pile
     * </ul>
     * <p>No ArrayList: the top of the pile is simply the last used place of the array. The check runs:
     * <pre>{@code
     * Pile<String> discards = new Pile<>();
     * discards.put("7 of hearts");
     * discards.put("queen of spades");
     * discards.put("2 of clubs");
     * System.out.println(discards.take());
     * System.out.println(discards.take() + ", " + discards.size() + " left");
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 2 of clubs
     * queen of spades, 1 left
     * }</pre>
     * Hints
     * 1. Two instance variables, as in SimpleList: {@code private T[] values;} and {@code private int size;}. The constructor sets {@code this.values = (T[]) new Object[4];}, with {@code @SuppressWarnings("unchecked")} above it if you want javac to stay quiet.
     * 2. {@code put} works like SimpleList's {@code add}. {@code take} checks {@code this.size == 0} first and throws; otherwise it keeps {@code this.values[this.size - 1]} in a variable, sets that place to {@code null}, lowers the size, and returns the value. Nothing has to move: the top is at the end.
     */
    public static void main(String[] args) {
        Pile<String> discards = new Pile<>();
        discards.put("7 of hearts");
        discards.put("queen of spades");
        discards.put("2 of clubs");
        System.out.println(discards.take());
        System.out.println(discards.take() + ", " + discards.size() + " left");
    }
}
