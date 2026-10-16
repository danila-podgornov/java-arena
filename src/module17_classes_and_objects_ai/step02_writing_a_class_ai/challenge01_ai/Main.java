// AI-Generated
package module17_classes_and_objects_ai.step02_writing_a_class_ai.challenge01_ai;

public class Main {
    /**
     * {@code Suitcase.java} already has a constructor and a method, and they use two instance variables: {@code owner}, a String, and {@code kilos}, an int. But nobody declared them, so the program doesn't compile. Declare them at the top of the class, as private instance variables. (Constructors and methods are the next steps: here you only add the variables.) The check runs:
     * <pre>{@code
     * Suitcase bag = new Suitcase("Mei", 18);
     * bag.printLabel();
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code Owner: Mei, 18 kg}
     * Hints
     * 1. The constructor stores values in {@code this.owner} and {@code this.kilos}, so the class needs instance variables with exactly those names.
     * 2. At the top of the class, where the comment is, one line each, with {@code private} in front: {@code private String owner;} and {@code private int kilos;}.
     */
    public static void main(String[] args) {
        Suitcase bag = new Suitcase("Mei", 18);
        bag.printLabel();
    }
}
