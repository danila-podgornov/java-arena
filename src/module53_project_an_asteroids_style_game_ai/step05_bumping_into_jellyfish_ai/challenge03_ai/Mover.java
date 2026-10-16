// AI-Generated
package module53_project_an_asteroids_style_game_ai.step05_bumping_into_jellyfish_ai.challenge03_ai;

import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;

public abstract class Mover {
    private Shape shape;
    private Point2D velocity;

    public Mover(Shape shape, double x, double y) {
        this.shape = shape;
        this.shape.setTranslateX(x);
        this.shape.setTranslateY(y);
        this.velocity = new Point2D(0, 0);
    }

    public Shape getShape() {
        return shape;
    }

    public void turn(double degrees) {
        shape.setRotate(shape.getRotate() + degrees);
    }

    public void accelerate(double amount) {
        double angle = Math.toRadians(shape.getRotate());
        velocity = velocity.add(Math.cos(angle) * amount, Math.sin(angle) * amount);
    }

    public void move() {
        shape.setTranslateX(shape.getTranslateX() + velocity.getX());
        shape.setTranslateY(shape.getTranslateY() + velocity.getY());
    }

    public boolean collides(Mover other) {
        Shape overlap = Shape.intersect(shape, other.getShape());
        return overlap.getBoundsInLocal().getWidth() != -1;
    }
}
