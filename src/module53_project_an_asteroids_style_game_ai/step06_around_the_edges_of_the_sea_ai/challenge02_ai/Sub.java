// AI-Generated
package module53_project_an_asteroids_style_game_ai.step06_around_the_edges_of_the_sea_ai.challenge02_ai;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Sub extends Mover {

    public Sub(double x, double y) {
        super(new Polygon(-15, -6, 9, -6, 15, 0, 9, 6, -15, 6), x, y);
        getShape().setFill(Color.GOLD);
    }
}
