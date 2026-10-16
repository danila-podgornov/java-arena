// AI-Generated
package module53_project_an_asteroids_style_game_ai.step04_submarine_and_jellyfish_share_a_class_ai.challenge02_ai;

public class Main {
    /**
     * A crate drifts and a buoy bobs. What does this program print?
     * Hints
     * 1. {@code buoy} is a {@code Drifter} variable, but the object is a Bobber, so {@code buoy.move()} runs Bobber's {@code move}.
     * 2. Bobber's {@code move} first runs Drifter's {@code move} with {@code super.move()} (which moves and prints), then counts and prints the bob. Each object has its own {@code x}.
     */
    public static void main(String[] args) {
        Drifter crate = new Drifter("crate");
        Drifter buoy = new Bobber("buoy");
        crate.move();
        buoy.move();
        buoy.move();
    }
}
