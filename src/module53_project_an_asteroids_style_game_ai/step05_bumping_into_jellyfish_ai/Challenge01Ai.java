// AI-Generated
package module53_project_an_asteroids_style_game_ai.step05_bumping_into_jellyfish_ai;

public class Challenge01Ai {
    /**
     * Write the method {@code overlaps(x1, y1, r1, x2, y2, r2)}: it returns {@code true} when the circle with its center at (x1, y1) and the radius r1 overlaps the circle at (x2, y2) with the radius r2, that is, when the distance between the centers is <b>less than</b> r1 + r2. Circles that only touch don't overlap. The first test runs {@code main}: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * false
     * }</pre>
     * Hints
     * 1. {@code double dx = x2 - x1;} and {@code double dy = y2 - y1;} are the differences. The distance is {@code Math.sqrt(dx * dx + dy * dy)}.
     * 2. Return the comparison itself: {@code return Math.sqrt(dx * dx + dy * dy) < r1 + r2;}. With {@code <}, circles that only touch (a distance equal to the sum) give false.
     */
    public static void main(String[] args) {
        System.out.println(overlaps(0, 0, 5, 6, 0, 3));
        System.out.println(overlaps(0, 0, 5, 8, 0, 3));
    }

    public static boolean overlaps(double x1, double y1, double r1, double x2, double y2, double r2) {
        return false;
    }
}
