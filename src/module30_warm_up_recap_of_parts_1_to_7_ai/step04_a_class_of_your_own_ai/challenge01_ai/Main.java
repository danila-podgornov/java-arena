// AI-Generated
package module30_warm_up_recap_of_parts_1_to_7_ai.step04_a_class_of_your_own_ai.challenge01_ai;

public class Main {
    /**
     * A woodworking class keeps its planks in a rack. In {@code Plank.java}, write the class {@code Plank}, with private instance variables for the wood and the length:
     * <ul>
     * <li>a constructor {@code Plank(String wood, int length)}: the kind of wood, such as {@code oak}, and the length in centimeters,
     * <li>the getters {@code getWood()} and {@code getLength()},
     * <li>a method {@code cut(int piece)} that saws a piece of that many centimeters off the plank, so the plank gets shorter by that much. If the piece is longer than the plank, nothing happens.
     * <li>{@code toString()}, which returns the wood and the length, like {@code oak, 120 cm}.
     * </ul>
     * <p>{@code Main.java} is a test drive. Until Plank has the constructor, {@code cut} and both getters, Main.java doesn't compile: each error names a part that's still missing. When it's done, the test drive prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * oak, 120 cm
     * oak, 75 cm
     * oak, 75 cm
     * 75 oak
     * }</pre>
     * Hints
     * 1. Two private instance variables, {@code private String wood;} and {@code private int length;}, set in the constructor with {@code this.wood = wood;} and {@code this.length = length;}. The getters return them.
     * 2. {@code cut} changes the length only {@code if (piece <= this.length)}, with {@code this.length -= piece;}. {@code toString} returns {@code this.wood + ", " + this.length + " cm"}.
     */
    public static void main(String[] args) {
        Plank plank = new Plank("oak", 120);
        System.out.println(plank);
        plank.cut(45);
        System.out.println(plank);
        plank.cut(80);
        System.out.println(plank);
        System.out.println(plank.getLength() + " " + plank.getWood());
    }
}
