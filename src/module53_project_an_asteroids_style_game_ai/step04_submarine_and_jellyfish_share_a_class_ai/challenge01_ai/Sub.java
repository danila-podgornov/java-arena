// AI-Generated
package module53_project_an_asteroids_style_game_ai.step04_submarine_and_jellyfish_share_a_class_ai.challenge01_ai;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Sub extends Mover {

    public Sub(double x, double y) {
        super(new Polygon(-15, -6, 9, -6, 15, 0, 9, 6, -15, 6), x, y);
        getShape().setFill(Color.GOLD);
    }
}
