// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step01_every_class_inherits_from_object_ai.challenge02_ai;

import java.util.ArrayList;

public class Main {
    /**
     * A museum's {@code Painting} has a title, an artist and a year. Printing one now shows Object's {@code toString}: {@code Painting@} and a hash code. In {@code Painting.java}, write Painting's own {@code toString}, so that a painting shows as {@code Harbor at Dawn by Mina Park (1911)}. The check prints a painting, a list of paintings, and a painting after other text:
     * <pre>{@code
     * Painting dawn = new Painting("Harbor at Dawn", "Mina Park", 1911);
     * System.out.println(dawn);
     * ArrayList<Painting> wall = new ArrayList<>();
     * wall.add(dawn);
     * wall.add(new Painting("Red Kite", "Tomas Ek", 1958));
     * System.out.println(wall);
     * System.out.println("On loan: " + wall.get(1));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Harbor at Dawn by Mina Park (1911)
     * [Harbor at Dawn by Mina Park (1911), Red Kite by Tomas Ek (1958)]
     * On loan: Red Kite by Tomas Ek (1958)
     * }</pre>
     * Hints
     * 1. The header must be exactly Object's: <code>public String toString() {</code>. The method returns the text instead of printing it.
     * 2. {@code return this.title + " by " + this.artist + " (" + this.year + ")";}. The list and the {@code +} both call the same method.
     */
    public static void main(String[] args) {
        Painting dawn = new Painting("Harbor at Dawn", "Mina Park", 1911);
        System.out.println(dawn);
        ArrayList<Painting> wall = new ArrayList<>();
        wall.add(dawn);
        wall.add(new Painting("Red Kite", "Tomas Ek", 1958));
        System.out.println(wall);
        System.out.println("On loan: " + wall.get(1));
    }
}
