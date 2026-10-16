// AI-Generated
package module21_designing_classes_and_overloading_ai.step04_one_constructor_calling_another_ai.challenge03_ai;

public class Main {
    /**
     * What does this program print? Each constructor of {@code Lantern} prints a line, so you can see when it runs. (Constructors don't usually print anything.)
     * Hints
     * 1. {@code new Lantern()} starts with {@code this("paper")}, which starts with {@code this("paper", 1)}. The innermost constructor finishes first and prints first.
     * 2. Each constructor prints its line after the constructor it called has finished. {@code new Lantern("glass", 3)} runs only the two-parameter constructor.
     */
    public static void main(String[] args) {
        Lantern first = new Lantern();
        Lantern second = new Lantern("glass", 3);
    }
}
