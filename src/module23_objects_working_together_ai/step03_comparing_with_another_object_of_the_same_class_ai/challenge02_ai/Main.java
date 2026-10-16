// AI-Generated
package module23_objects_working_together_ai.step03_comparing_with_another_object_of_the_same_class_ai.challenge02_ai;

public class Main {
    /**
     * Packing to move house: a box fits inside another box when it's smaller in all three measures, so that its width, its height and its depth are each less than the other box's. (The boxes aren't turned around.) In {@code Box.java}, write the method {@code fitsInside(Box other)}. The check runs:
     * <pre>{@code
     * Box shoebox = new Box(30, 12, 18);
     * Box crate = new Box(50, 40, 40);
     * System.out.println(shoebox.fitsInside(crate));
     * System.out.println(crate.fitsInside(shoebox));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * false
     * }</pre>
     * Hints
     * 1. Three comparisons, one for each measure, and all three must be true: join them with {@code &&}.
     * 2. {@code return this.width < other.width && this.height < other.height && this.depth < other.depth;}
     */
    public static void main(String[] args) {
        Box shoebox = new Box(30, 12, 18);
        Box crate = new Box(50, 40, 40);
        System.out.println(shoebox.fitsInside(crate));
        System.out.println(crate.fitsInside(shoebox));
    }
}
