// AI-Generated
package module53_project_an_asteroids_style_game_ai.step03_engines_on_moving_with_vectors_ai.challenge01_ai;

public class Motion {
    private double x;
    private double y;
    private double vx;
    private double vy;

    public Motion(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void push(double degrees, double amount) {

    }

    public void step() {

    }

    @Override
    public String toString() {
        return "at (" + rounded(x) + ", " + rounded(y) + "), moving (" + rounded(vx) + ", " + rounded(vy) + ")";
    }

    private static double rounded(double value) {
        return Math.round(value * 100) / 100.0;
    }
}
