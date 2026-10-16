// AI-Generated
package module17_classes_and_objects_ai.step04_methods_of_an_object_ai.challenge01_ai;

public class Main {
    /**
     * {@code Tram.java} has a constructor for a tram's line number and destination. Add a method {@code printSign()} that prints them on one line, like the sign on the front of the tram. The check runs:
     * <pre>{@code
     * Tram tram = new Tram(4, "Harbor");
     * tram.printSign();
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code Line 4 to Harbor}
     * Hints
     * 1. The method goes after the constructor, inside the class, and without {@code static}: <code>public void printSign() {</code>.
     * 2. Print with the object's own variables: {@code System.out.println("Line " + this.line + " to " + this.destination);}.
     */
    public static void main(String[] args) {
        Tram tram = new Tram(4, "Harbor");
        tram.printSign();
    }
}
