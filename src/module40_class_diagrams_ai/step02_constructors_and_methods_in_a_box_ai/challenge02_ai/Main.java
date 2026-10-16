// AI-Generated
package module40_class_diagrams_ai.step02_constructors_and_methods_in_a_box_ai.challenge02_ai;

public class Main {
    /**
     * A garden center's greenhouses open their vents when it gets warm. The team drew this box, and {@code Main.java} was written from it:
     * <pre>{@code
     * class Greenhouse
     * - name: String
     * - degrees: double
     * - open: boolean
     * + Greenhouse(name: String, degrees: double)
     * + getName(): String
     * + getDegrees(): double
     * + isOpen(): boolean
     * + warm(by: double): void
     * + openVents(): void
     * }</pre>
     * <p>In {@code Greenhouse.java}, three method headers don't match the box, so the program doesn't compile. Fix them (and anything inside those methods that has to change with them), so that the class matches the box. Leave {@code Main.java} as it is. The program should print: see the expected output below.
     * Expected output
     * {@code Palm house: true, 26.0 degrees}
     * Hints
     * 1. Read javac's messages, then compare each method's header with its line in the box: the sign in front, the parameter's type, and the return type after the colon.
     * 2. {@code getDegrees(): double} returns a {@code double}, {@code warm(by: double)} takes a {@code double}, and the {@code +} in front of {@code openVents} makes it public.
     */
    public static void main(String[] args) {
        Greenhouse palm = new Greenhouse("Palm house", 24.5);
        palm.warm(1.5);
        if (palm.getDegrees() > 25) {
            palm.openVents();
        }
        System.out.println(palm.getName() + ": " + palm.isOpen() + ", " + palm.getDegrees() + " degrees");
    }
}
