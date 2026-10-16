// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step05_enums_a_fixed_set_of_values_ai.challenge03_ai;

public class Main {
    /**
     * On a parade ground, a marching band faces north, east, south or west, and at the command "right face", everyone makes a quarter turn clockwise. Write:
     * <ul>
     * <li>in {@code Direction.java}, the enum {@code Direction}, with the constants {@code NORTH}, {@code EAST}, {@code SOUTH} and {@code WEST}, in that order (clockwise)
     * <li>in {@code Main.java}, the method {@code turnRight(Direction facing)}, which returns the direction after a quarter turn clockwise: north to east, east to south, south to west, and west back to north
     * </ul>
     * <p>{@code main} is a test drive, and it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * NORTH
     * EAST
     * SOUTH
     * WEST
     * NORTH
     * }</pre>
     * Hints
     * 1. The enum is one line inside its braces: the four constants, separated by commas. The method's header is {@code public static Direction turnRight(Direction facing)}.
     * 2. Since the constants are in clockwise order, the next direction is the next constant: {@code Direction.values()[facing.ordinal() + 1]}, except that after WEST comes NORTH again. {@code % 4} (or {@code % values().length}) takes care of that. Three {@code if}s with {@code ==} work too.
     */
    public static void main(String[] args) {
        Direction facing = Direction.NORTH;
        for (int i = 0; i < 5; i++) {
            System.out.println(facing);
            facing = turnRight(facing);
        }
    }

    // Write the method turnRight here.
}
