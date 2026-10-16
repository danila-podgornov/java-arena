// AI-Generated
package module53_project_an_asteroids_style_game_ai.step08_points_new_jellyfish_and_the_end_of_the_dive_ai.challenge01_ai;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Bubble extends Mover {
    private int age;

    public Bubble(double x, double y, double heading) {
        super(new Circle(3, Color.LIGHTCYAN), x, y);
        turn(heading);
        accelerate(2.5);
        age = 0;
    }

    @Override
    public void move() {
        super.move();
        age++;
        if (age == 50) {
            setAlive(false);
        }
    }
}
