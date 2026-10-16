// AI-Generated
package module53_project_an_asteroids_style_game_ai.step06_around_the_edges_of_the_sea_ai;

public class Challenge01Ai {
    /**
     * Write {@code wrap(value, size)} in this program without a window. It returns {@code value} wrapped into the range from 0 up to {@code size}, for positive and negative values: {@code wrap(370, 360)} is 10, {@code wrap(-10, 360)} is 350, and a value already inside stays exactly as it is ({@code wrap(100, 360)} is 100). The first test runs {@code main}: see the expected output below.
     * Expected output
     * <pre>{@code
     * 10.0
     * 350.0
     * 100.0
     * }</pre>
     * Hints
     * 1. Start from the remainder {@code value % size}. It is already right for positive values; for a negative value it is negative too: -10 % 360 is -10.
     * 2. Keep the remainder in a variable, and only when it is below 0, add {@code size} to it: -10 + 360 is 350. Then return it.
     */
    public static void main(String[] args) {
        System.out.println(wrap(370, 360));
        System.out.println(wrap(-10, 360));
        System.out.println(wrap(100, 360));
    }

    public static double wrap(double value, double size) {
        return value;
    }
}
