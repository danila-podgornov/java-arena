// AI-Generated
package module36_polymorphism_ai.step02_instanceof_and_casts_ai.challenge03_ai;

import java.util.ArrayList;

public class Main {
    /**
     * At the end of each round, every troll regenerates. But {@code endRound} in {@code Main.java} crashes with a ClassCastException as soon as the list holds anything other than a troll. Fix it, so that the trolls regenerate and the other enemies are left as they are. {@code Main} is a test drive, and it prints: see the expected output below.
     * Expected output
     * {@code [Grak (35), Snip (20), Mossback (55)]}
     * Hints
     * 1. The cast crashes on Snip: a goblin is not a troll, and a cast can't make it one. Only cast an enemy that {@code instanceof} says is a Troll.
     * 2. Put the two lines inside {@code if (enemy instanceof Troll) { ... }}. The other enemies then skip the cast, and are left as they are.
     */
    public static void main(String[] args) {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new Troll("Grak", 30));
        enemies.add(new Goblin("Snip", 20));
        enemies.add(new Troll("Mossback", 50));
        endRound(enemies);
        System.out.println(enemies);
    }

    public static void endRound(ArrayList<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            Troll troll = (Troll) enemy;
            troll.regenerate();
        }
    }
}
