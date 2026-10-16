// AI-Generated
package module44_type_parameters_generics_ai.step05_putting_it_together_what_the_compiler_checks_ai.challenge01_ai;

public class Main {
    /**
     * A drawing app lets you undo changes to the brush. The brush color is a String and its size an Integer, and one class handles both. In {@code Undoable.java}, write the class {@code Undoable<T>} with:
     * <ul>
     * <li>a constructor {@code Undoable(T start)}, which takes the first value
     * <li>{@code get()}, which returns the current value
     * <li>{@code set(T value)}, which changes the value and remembers the old one
     * <li>{@code undo()}, which goes back to the value before the last {@code set}. Each {@code undo} goes one step further back. When only the first value is left, {@code undo} throws an IllegalStateException with the message {@code Nothing to undo}, and the value stays as it is.
     * </ul>
     * <p>Keep the values in an {@code ArrayList<T>}, the current one last. The check runs:
     * <pre>{@code
     * Undoable<String> color = new Undoable<>("black");
     * color.set("red");
     * color.set("blue");
     * color.undo();
     * System.out.println(color.get());
     * color.undo();
     * System.out.println(color.get());
     * try {
     *     color.undo();
     * } catch (IllegalStateException e) {
     *     System.out.println(e.getMessage());
     * }
     * System.out.println(color.get());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * red
     * black
     * Nothing to undo
     * black
     * }</pre>
     * Hints
     * 1. The header is {@code public class Undoable<T>}, with one instance variable, {@code private ArrayList<T> values;}. The constructor makes the list and adds {@code start} to it, so the list is never empty.
     * 2. {@code get} returns the last value, {@code this.values.get(this.values.size() - 1)}, and {@code set} adds to the end. {@code undo} first checks whether only one value is left, and throws {@code new IllegalStateException("Nothing to undo")} if so; otherwise it removes the last value.
     */
    public static void main(String[] args) {
        Undoable<String> color = new Undoable<>("black");
        color.set("red");
        color.set("blue");
        color.undo();
        System.out.println(color.get());
        color.undo();
        System.out.println(color.get());
        try {
            color.undo();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(color.get());
    }
}
