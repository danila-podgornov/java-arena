// AI-Generated
package module40_class_diagrams_ai.step07_interfaces_and_a_whole_program_ai.challenge02_ai;

public class Main {
    /**
     * Here are the tires of step 6 in the weighing station's diagram. Fill in the three blanks, words from class headers, so that the code matches the diagram.
     * <pre>{@code
     * interface Weighable
     * + weight(): int
     *
     * abstract class DropOff
     * - kilos: int
     * + DropOff(kilos: int)
     * + getKilos(): int
     * + fee(): int {abstract}
     *
     * class Tires extends DropOff implements Weighable
     * - count: int
     * + Tires(kilos: int, count: int)
     * + fee(): int
     * + weight(): int
     * }</pre>
     * Hints
     * 1. Look above DropOff's name, and at the two lines from Tires: which one is solid, which dashed?
     * 2. «abstract» goes into DropOff's header as {@code abstract}. A solid line with a triangle is {@code extends}, a dashed one is {@code implements}, and {@code extends} comes first: {@code public class Tires extends DropOff implements Weighable}.
     */
    public static void main(String[] args) {
        Tires tires = new Tires(36, 4);
        Weighable item = tires;
        DropOff dropOff = tires;
        System.out.println(item.weight() + " " + dropOff.fee());
    }
}
