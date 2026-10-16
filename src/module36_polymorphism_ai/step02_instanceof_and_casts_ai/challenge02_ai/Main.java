// AI-Generated
package module36_polymorphism_ai.step02_instanceof_and_casts_ai.challenge02_ai;

public class Main {
    /**
     * Casts between a class, an interface and Object. What does this program print?
     * Hints
     * 1. No cast makes a new object. {@code a}, {@code b} and {@code c} all refer to the one bat, each with a different type, and the bat is still a Bat whichever variable you ask through.
     * 2. {@code thing} and {@code troll} refer to the same troll as {@code grak}, so regenerating through {@code troll} heals the object that {@code grak} refers to. A troll doesn't fly.
     */
    public static void main(String[] args) {
        Enemy a = new Bat("Squeak", 3);
        Flying b = (Flying) a;
        Enemy c = (Enemy) b;
        System.out.println(b.altitude() + " " + c.getName());
        System.out.println((a == c) + " " + (c instanceof Bat));

        Enemy grak = new Troll("Grak", 30);
        Object thing = grak;
        Troll troll = (Troll) thing;
        troll.regenerate();
        System.out.println(grak.getHealth() + " " + (thing instanceof Flying));
    }
}
