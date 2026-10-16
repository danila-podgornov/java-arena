// AI-Generated
package module53_project_an_asteroids_style_game_ai.step07_firing_bubbles_ai.challenge03_ai;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Bubble extends Mover {

    public Bubble(double x, double y, double heading) {
        super(new Circle(3, Color.LIGHTCYAN), x, y);
        turn(heading);
        accelerate(2.5);
    }
}
