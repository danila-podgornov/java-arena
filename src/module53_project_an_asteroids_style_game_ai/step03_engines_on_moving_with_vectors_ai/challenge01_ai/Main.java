// AI-Generated
package module53_project_an_asteroids_style_game_ai.step03_engines_on_moving_with_vectors_ai.challenge01_ai;

public class Main {
    /**
     * The movement without a window. The class {@code Motion} keeps a position (x, y) and a velocity (vx, vy), all doubles that start at the given position and a velocity of (0, 0); its {@code toString} is written for you and rounds to two decimals. Write its two methods:
     * <ul>
     * <li>{@code push(double degrees, double amount)} adds to the velocity a step of length {@code amount} in the direction {@code degrees}: {@code Math.cos} of the angle in radians times {@code amount} to vx, and {@code Math.sin} of it times {@code amount} to vy.
     * <li>{@code step()} adds the velocity to the position: vx to x and vy to y.
     * </ul>
     * <p>The first test runs this:
     * <pre>{@code
     * Motion m = new Motion(10, 20);
     * m.push(0, 2);
     * m.step();
     * m.step();
     * System.out.println(m);
     * m.push(90, 1);
     * m.step();
     * System.out.println(m);
     * }</pre>
     * <pre>{@code
     * at (14.0, 20.0), moving (2.0, 0.0)
     * at (16.0, 21.0), moving (2.0, 1.0)
     * }</pre>
     * Hints
     * 1. {@code push} turns the degrees into radians with {@code Math.toRadians}, then adds cos times the amount to vx and sin times the amount to vy. {@code step} adds the velocity to the position.
     * 2. In {@code push}: {@code double angle = Math.toRadians(degrees);}, then {@code vx = vx + Math.cos(angle) * amount;} and the same for vy with {@code Math.sin}. In {@code step}: {@code x = x + vx;} and {@code y = y + vy;}.
     */
    public static void main(String[] args) {
        Motion m = new Motion(10, 20);
        m.push(0, 2);
        m.step();
        m.step();
        System.out.println(m);
        m.push(90, 1);
        m.step();
        System.out.println(m);
    }
}
