// AI-Generated
package module44_type_parameters_generics_ai.step01_why_type_parameters_ai.challenge01_ai;

public class Main {
    /**
     * A learning app shows a word of the day and a number of the day, with one class for both. Fill in the three blanks so that {@code Featured} works for any type: the type parameter in the class header, the type of the instance variable, and the return type of {@code get}. The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Word of the day: lantern (7 letters)
     * Number of the day: 64, half of it is 32
     * }</pre>
     * Hints
     * 1. The constructor's parameter is already written as {@code T item}. What does that tell you about the type parameter's name?
     * 2. The instance variable holds a T, and {@code get} returns it, so both of the other blanks are {@code T} too. With {@code Object} there, {@code word.get().length()} wouldn't compile.
     */
    public static void main(String[] args) {
        Featured<String> word = new Featured<String>("lantern");
        System.out.println("Word of the day: " + word.get() + " (" + word.get().length() + " letters)");

        Featured<Integer> number = new Featured<Integer>(64);
        System.out.println("Number of the day: " + number.get() + ", half of it is " + number.get() / 2);
    }
}
