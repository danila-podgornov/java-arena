// AI-Generated
package module36_polymorphism_ai.step02_instanceof_and_casts_ai.challenge01_ai;

import java.util.ArrayList;

public class Main {
    /**
     * The hero's spear reaches enemies on the ground, and flying enemies up to a given height. In {@code Main.java}, write the method {@code inReach(ArrayList<Enemy> enemies, int reach)}. It returns a new list of the names of the enemies the spear can hit, in the order of the list: every enemy that doesn't fly, and every flying enemy whose altitude is at most {@code reach}. Ask whether an enemy flies with {@code instanceof Flying}, not whether it's a Bat, so that flying enemies added to the game later count too. The check runs:
     * <pre>{@code
     * ArrayList<Enemy> enemies = new ArrayList<>();
     * enemies.add(new Bat("Squeak", 3));
     * enemies.add(new Goblin("Snip", 20));
     * enemies.add(new Bat("Flit", 12));
     * enemies.add(new Goblin("Nab", 15));
     * System.out.println(inReach(enemies, 5));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code [Squeak, Snip, Nab]}
     * Hints
     * 1. Go through the enemies with a for-each loop. An enemy for which {@code enemy instanceof Flying} is {@code false} is on the ground: add its {@code getName()} to the list.
     * 2. For a flying one, cast first: {@code Flying flyer = (Flying) enemy;}. Then add its name only when {@code flyer.altitude() <= reach}. Return the list after the loop.
     */
    public static void main(String[] args) {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new Bat("Squeak", 3));
        enemies.add(new Goblin("Snip", 20));
        enemies.add(new Bat("Flit", 12));
        enemies.add(new Goblin("Nab", 15));
        System.out.println(inReach(enemies, 5));
    }

    // Write the method inReach here.
}
