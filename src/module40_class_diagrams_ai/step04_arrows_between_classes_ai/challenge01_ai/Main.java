// AI-Generated
package module40_class_diagrams_ai.step04_arrows_between_classes_ai.challenge01_ai;

public class Main {
    /**
     * The theater's costume department sews each costume for one actor, who wears it as one character. {@code Actor.java} is ready. Write the class {@code Costume} in {@code Costume.java}, as the diagram shows:
     * <pre>{@code
     * class Actor
     * - name: String
     * - height: int
     * + Actor(name: String, height: int)
     * + getName(): String
     * + getHeight(): int
     *
     * class Costume
     * - character: String
     * + Costume(character: String, actor: Actor)
     * + getActor(): Actor
     * + toString(): String
     *
     * Costume --> 1 Actor : actor
     * }</pre>
     * <p>{@code getActor} returns the costume's actor, and {@code toString} returns {@code Puck, for Noor Haddad (172 cm)}, with the costume's own character and its actor's name and height. The check runs:
     * <pre>{@code
     * Actor noor = new Actor("Noor Haddad", 172);
     * Costume puck = new Costume("Puck", noor);
     * Costume moth = new Costume("Moth", noor);
     * System.out.println(puck);
     * System.out.println(moth.getActor().getName());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Puck, for Noor Haddad (172 cm)
     * Noor Haddad
     * }</pre>
     * Hints
     * 1. Costume has two instance variables: {@code character} from its box, and {@code actor} from the arrow, of type Actor. The constructor stores both.
     * 2. {@code getActor} returns the actor. {@code toString} asks the actor for its name and height: {@code this.actor.getName()} and {@code this.actor.getHeight()}.
     */
    public static void main(String[] args) {
        Actor noor = new Actor("Noor Haddad", 172);
        Costume puck = new Costume("Puck", noor);
        Costume moth = new Costume("Moth", noor);
        System.out.println(puck);
        System.out.println(moth.getActor().getName());
    }
}
