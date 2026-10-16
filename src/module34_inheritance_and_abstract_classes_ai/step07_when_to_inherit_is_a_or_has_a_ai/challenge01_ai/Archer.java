// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step07_when_to_inherit_is_a_or_has_a_ai.challenge01_ai;

public class Archer extends Bow {
    private String name;

    public Archer(String name, int arrows) {
        super(arrows);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int attack() {
        if (this.shoot()) {
            return 6;
        }
        return 1;
    }
}
