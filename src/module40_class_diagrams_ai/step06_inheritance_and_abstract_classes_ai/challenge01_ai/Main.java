// AI-Generated
package module40_class_diagrams_ai.step06_inheritance_and_abstract_classes_ai.challenge01_ai;

public class Main {
    /**
     * Old tires are a drop-off too. {@code DropOff.java} is ready. Write the class {@code Tires} in {@code Tires.java}, as the diagram shows. Tires cost 4 dollars each.
     * <pre>{@code
     * abstract class DropOff
     * - kilos: int
     * + DropOff(kilos: int)
     * + getKilos(): int
     * + fee(): int {abstract}
     * + toString(): String
     *
     * class Tires extends DropOff
     * - count: int
     * + Tires(kilos: int, count: int)
     * + fee(): int
     * }</pre>
     * <p>The check runs:
     * <pre>{@code
     * DropOff tires = new Tires(36, 4);
     * System.out.println(tires);
     * System.out.println(tires.getKilos() + " " + tires.fee());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 36 kg, fee 16
     * 36 16
     * }</pre>
     * Hints
     * 1. The triangle means {@code public class Tires extends DropOff}. Tires's own field is {@code count}. The kilos belong to DropOff, so the constructor passes them on with {@code super(kilos);}.
     * 2. {@code fee()} is abstract in DropOff, so Tires must write it: {@code public int fee()}, returning 4 times the count. {@code toString} and {@code getKilos} are inherited.
     */
    public static void main(String[] args) {
        DropOff tires = new Tires(36, 4);
        System.out.println(tires);
        System.out.println(tires.getKilos() + " " + tires.fee());
    }
}
