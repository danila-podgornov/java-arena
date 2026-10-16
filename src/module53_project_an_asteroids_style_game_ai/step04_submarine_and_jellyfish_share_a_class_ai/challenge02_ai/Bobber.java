// AI-Generated
package module53_project_an_asteroids_style_game_ai.step04_submarine_and_jellyfish_share_a_class_ai.challenge02_ai;

public class Bobber extends Drifter {
    private int bobs;

    public Bobber(String name) {
        super(name);
    }

    @Override
    public void move() {
        super.move();
        bobs++;
        System.out.println(getName() + " bobbed " + bobs + " times");
    }
}
