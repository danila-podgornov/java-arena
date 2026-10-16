// AI-Generated
package module53_project_an_asteroids_style_game_ai.step03_engines_on_moving_with_vectors_ai;

import javafx.geometry.Point2D;

public class Challenge03Ai {
    /**
     * What does this program print?
     * Hints
     * 1. A Point2D never changes: {@code speed.add(1, 1)} returns a new point, and nobody keeps it. So {@code speed} is still (2, 0).
     * 2. {@code faster} is (6, 0). Adding (0, 8) gives (6, 8), and its length is the square root of 36 + 64.
     */
    public static void main(String[] args) {
        Point2D speed = new Point2D(2, 0);
        speed.add(1, 1);
        Point2D faster = speed.multiply(3);
        System.out.println(speed.getX() + " " + faster.getX());
        System.out.println(faster.add(0, 8).magnitude());
    }
}
