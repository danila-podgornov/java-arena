// AI-Generated
package module58_pattern_matching_and_sealed_types_ai.step04_record_patterns_ai.challenge02_ai;

public class Main {
    /**
     * Each wall of the floor plan goes from one corner to another: {@code Wall(Corner from, Corner to)}. Write {@code describe(Wall wall)}, which returns:
     * <ul>
     * <li>{@code horizontal, } and the length and {@code  cm}, when both corners have the same {@code y};
     * <li>{@code vertical, } and the length and {@code  cm}, when both corners have the same {@code x} (and different {@code y}s);
     * <li>{@code slanted} otherwise.
     * </ul>
     * <p>The length is the difference of the coordinates that change, as a positive number ({@code Math.abs}). Take the wall and both its corners apart with one nested record pattern, {@code Wall(Corner(...), Corner(...))}, in a switch or after {@code instanceof}, without calling the accessors. The check runs:
     * <pre>{@code
     * System.out.println(describe(new Wall(new Corner(0, 0), new Corner(400, 0))));
     * System.out.println(describe(new Wall(new Corner(400, 350), new Corner(400, 0))));
     * System.out.println(describe(new Wall(new Corner(0, 0), new Corner(300, 200))));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * horizontal, 400 cm
     * vertical, 350 cm
     * slanted
     * }</pre>
     * Hints
     * 1. {@code Wall(Corner(int x1, int y1), Corner(int x2, int y2))} gives all four coordinates at once. It can be a case of {@code switch (wall)}, with {@code when y1 == y2} for horizontal walls.
     * 2. In a switch, end with a case that matches every wall, such as {@code case Wall other -> "slanted";}. With {@code instanceof}, use the four variables in ifs inside it.
     */
    public static void main(String[] args) {
        System.out.println(describe(new Wall(new Corner(0, 0), new Corner(400, 0))));
        System.out.println(describe(new Wall(new Corner(400, 350), new Corner(400, 0))));
        System.out.println(describe(new Wall(new Corner(0, 0), new Corner(300, 200))));
    }

    public static String describe(Wall wall) {
        return "";
    }
}
