// AI-Generated
package module53_project_an_asteroids_style_game_ai.step07_firing_bubbles_ai.challenge01_ai;

import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;

public abstract class Mover {
    private Shape shape;
    private Point2D velocity;
    private boolean alive;

    public Mover(Shape shape, double x, double y) {
        this.shape = shape;
        this.shape.setTranslateX(x);
        this.shape.setTranslateY(y);
        this.velocity = new Point2D(0, 0);
        this.alive = true;
    }

    public Shape getShape() {
        return shape;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void turn(double degrees) {
        shape.setRotate(shape.getRotate() + degrees);
    }

    public void accelerate(double amount) {
        double angle = Math.toRadians(shape.getRotate());
        velocity = velocity.add(Math.cos(angle) * amount, Math.sin(angle) * amount);
    }

    public void move() {
        shape.setTranslateX(Main.wrap(shape.getTranslateX() + velocity.getX(), Main.WIDTH));
        shape.setTranslateY(Main.wrap(shape.getTranslateY() + velocity.getY(), Main.HEIGHT));
    }

    public boolean collides(Mover other) {
        Shape overlap = Shape.intersect(shape, other.getShape());
        return overlap.getBoundsInLocal().getWidth() != -1;
    }
}
