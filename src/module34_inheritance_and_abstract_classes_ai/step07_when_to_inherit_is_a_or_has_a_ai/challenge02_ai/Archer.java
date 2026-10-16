// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step07_when_to_inherit_is_a_or_has_a_ai.challenge02_ai;

public class Archer extends Adventurer {
    private Bow bow;

    public Archer(String name, Bow bow) {
        super(name);
        this.bow = bow;
    }

    @Override
    public int attack() {
        if (this.bow.shoot()) {
            return 6;
        }
        return 1;
    }

    public void switchBow(Bow bow) {
        this.bow = bow;
    }
}
