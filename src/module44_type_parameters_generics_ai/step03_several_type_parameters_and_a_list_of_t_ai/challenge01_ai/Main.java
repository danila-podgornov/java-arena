// AI-Generated
package module44_type_parameters_generics_ai.step03_several_type_parameters_and_a_list_of_t_ai.challenge01_ai;

public class Main {
    /**
     * A language app's flashcards have a front and a back, and the two may be of different types: a word and its translation, or a question and a number. In {@code Flashcard.java}, write the class {@code Flashcard<F, B>} with:
     * <ul>
     * <li>a constructor {@code Flashcard(F front, B back)}
     * <li>{@code getFront()} and {@code getBack()}
     * <li>{@code flipped()}, which returns a new Flashcard with the back as its front and the front as its back. The card it's called on stays as it was.
     * <li>{@code toString()}, which returns the front and the back with {@code /} between them, like {@code perro / dog}
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Flashcard<String, String> word = new Flashcard<>("perro", "dog");
     * System.out.println(word);
     * System.out.println(word.flipped());
     * Flashcard<String, Integer> fact = new Flashcard<>("Days in a week", 7);
     * Flashcard<Integer, String> asked = fact.flipped();
     * System.out.println(asked);
     * int days = asked.getFront();
     * System.out.println(days * 2 + " days in two weeks");
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * perro / dog
     * dog / perro
     * 7 / Days in a week
     * 14 days in two weeks
     * }</pre>
     * Hints
     * 1. The header is {@code public class Flashcard<F, B>}. The front is an F and the back a B: {@code private F front;} and {@code private B back;}, and {@code getFront()} returns an F, {@code getBack()} a B.
     * 2. A flipped card has a B in front and an F at the back, so the return type of {@code flipped} is {@code Flashcard<B, F>}, and its body is {@code return new Flashcard<>(this.back, this.front);}. It makes a new card and leaves this one as it was.
     */
    public static void main(String[] args) {
        Flashcard<String, String> word = new Flashcard<>("perro", "dog");
        System.out.println(word);
        System.out.println(word.flipped());
        Flashcard<String, Integer> fact = new Flashcard<>("Days in a week", 7);
        Flashcard<Integer, String> asked = fact.flipped();
        System.out.println(asked);
        int days = asked.getFront();
        System.out.println(days * 2 + " days in two weeks");
    }
}
