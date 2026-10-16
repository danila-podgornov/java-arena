// AI-Generated
package module53_project_an_asteroids_style_game_ai.step08_points_new_jellyfish_and_the_end_of_the_dive_ai.challenge03_ai;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Jellyfish extends Mover {

    public Jellyfish(double x, double y, double heading) {
        super(new Polygon(-10, 0, -6, -8, 0, -10, 6, -8, 10, 0, 7, 10, 3, 2, 0, 10, -3, 2, -7, 10), x, y);
        getShape().setFill(Color.ORCHID);
        turn(heading);
        accelerate(0.5);
    }

    @Override
    public void move() {
        super.move();
        turn(1);
    }
}
