// AI-Generated
package module40_class_diagrams_ai.step01_a_class_as_a_box_ai.challenge03_ai;

public class Main {
    /**
     * A garden center planned its shrubs with this box:
     * <pre>{@code
     * class Shrub
     * - species: String
     * - height: double
     * - potLiters: int
     * }</pre>
     * <p>In {@code Shrub.java}, two instance variables don't match the box, and the program prints {@code Lilac: 19 cm, pot 10 liters}: half centimeters get lost along the way. Fix those two lines, and leave the constructor and the methods as they are. The program should print: see the expected output below.
     * Expected output
     * {@code Lilac: 20.0 cm, pot 10 liters}
     * Hints
     * 1. Compare each line of the box with its instance variable: the sign ({@code -} is private), the name and the type.
     * 2. {@code species} should be {@code private}, and {@code height} should be a {@code double}. With an {@code int}, {@code +=} drops the half centimeter of each {@code grow}.
     */
    public static void main(String[] args) {
        Shrub lilac = new Shrub("Lilac", 10);
        lilac.grow(12.5);
        lilac.grow(7.5);
        System.out.println(lilac);
    }
}
