// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step06_the_objects_class_decides_which_method_runs_ai.challenge03_ai;

public class Main {
    /**
     * Here the game's Adventurer has a role, and {@code describe} uses both {@code role()} and {@code attack()}. In {@code Healer.java}, write the class {@code Healer}, which extends Adventurer:
     * <ul>
     * <li>a constructor {@code Healer(String name)}
     * <li>{@code role()} overridden to return {@code healer}, with {@code @Override} above it
     * <li>{@code attack()} overridden to return 1, with {@code @Override} above it
     * <li>a method of its own, {@code heal()}, which returns 8
     * </ul>
     * <p>Don't write a {@code describe} in Healer: Adventurer's already works for it, since it calls the object's own {@code role()} and {@code attack()}. The check runs:
     * <pre>{@code
     * Adventurer mo = new Healer("Mo");
     * System.out.println(mo.describe());
     * Healer ash = new Healer("Ash");
     * System.out.println(ash.heal() + " " + ash.attack());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Mo the healer attacks for 1
     * 8 1
     * }</pre>
     * Hints
     * 1. Start with <code>public class Healer extends Adventurer {</code> and a constructor whose first line is {@code super(name);}.
     * 2. Override {@code public String role()} and {@code public int attack()}, each with {@code @Override} above it, and add {@code public int heal()}. Adventurer's {@code describe} calls {@code this.role()} and {@code this.attack()}, and for a Healer object those are Healer's.
     */
    public static void main(String[] args) {
        Adventurer mo = new Healer("Mo");
        System.out.println(mo.describe());
        Healer ash = new Healer("Ash");
        System.out.println(ash.heal() + " " + ash.attack());
    }
}
