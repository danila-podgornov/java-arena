// AI-Generated
package module53_project_an_asteroids_style_game_ai.step04_submarine_and_jellyfish_share_a_class_ai.challenge02_ai;

public class Drifter {
    private String name;
    private int x;

    public Drifter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void move() {
        x += 2;
        System.out.println(name + " at " + x);
    }
}
