// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step07_when_to_inherit_is_a_or_has_a_ai.challenge02_ai;

public class Main {
    /**
     * Two archers of the Archer class you just wrote share one bow. What does this program print?
     * Hints
     * 1. {@code lyra} and {@code tam} are Archers, so {@code describe} calls Archer's {@code attack}, which shoots the bow. Both archers hold a reference to the same Bow object (module 22), not copies of it.
     * 2. The bow has 3 arrows in all: every shot by either archer takes one. Once they're gone, an attack gives 1.
     */
    public static void main(String[] args) {
        Bow longbow = new Bow(3);
        Adventurer lyra = new Archer("Lyra", longbow);
        Adventurer tam = new Archer("Tam", longbow);
        System.out.println(lyra.describe());
        System.out.println(tam.describe());
        System.out.println(tam.describe());
        System.out.println(lyra.describe() + ", " + longbow.getArrows() + " arrows left");
    }
}
