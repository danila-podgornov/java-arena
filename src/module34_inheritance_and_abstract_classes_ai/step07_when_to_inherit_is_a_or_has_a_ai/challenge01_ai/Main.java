// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step07_when_to_inherit_is_a_or_has_a_ai.challenge01_ai;

public class Main {
    /**
     * Someone wrote {@code Archer extends Bow}, to give archers a bow's {@code shoot()} and arrows. But an archer isn't a bow: an archer is an adventurer who has a bow, and can switch to a new one. In {@code Archer.java}, rewrite Archer so that it extends {@code Adventurer} and has a {@code Bow} in a private instance variable:
     * <ul>
     * <li>a constructor {@code Archer(String name, Bow bow)}
     * <li>{@code attack()} overridden: the archer shoots the bow, and it returns 6 if an arrow was shot, or 1 if the bow was out of arrows
     * <li>{@code switchBow(Bow bow)}, which gives the archer another bow
     * </ul>
     * <p>{@code Bow.java} and {@code Adventurer.java} are ready, and {@code Main.java} already uses the new Archer, so the program won't compile until Archer is rewritten. The check runs:
     * <pre>{@code
     * Archer lyra = new Archer("Lyra", new Bow(1));
     * System.out.println(lyra.describe());
     * System.out.println(lyra.describe());
     * lyra.switchBow(new Bow(5));
     * System.out.println(lyra.describe());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Lyra attacks for 6
     * Lyra attacks for 1
     * Lyra attacks for 6
     * }</pre>
     * Hints
     * 1. The header becomes {@code public class Archer extends Adventurer}, with one instance variable, {@code private Bow bow;}. The name belongs to Adventurer now, so the constructor starts with {@code super(name);} and then keeps the bow.
     * 2. {@code attack()} asks the bow: {@code if (this.bow.shoot()) { return 6; }}, and otherwise returns 1. {@code switchBow} sets {@code this.bow} to the new bow. {@code getName} and {@code describe} come from Adventurer.
     */
    public static void main(String[] args) {
        Archer lyra = new Archer("Lyra", new Bow(1));
        System.out.println(lyra.describe());
        System.out.println(lyra.describe());
        lyra.switchBow(new Bow(5));
        System.out.println(lyra.describe());
    }
}
