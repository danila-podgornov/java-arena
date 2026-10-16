// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step07_when_to_inherit_is_a_or_has_a_ai.challenge01_ai;

public class Bow {
    private int arrows;

    public Bow(int arrows) {
        this.arrows = arrows;
    }

    public int getArrows() {
        return this.arrows;
    }

    public boolean shoot() {
        if (this.arrows == 0) {
            return false;
        }
        this.arrows--;
        return true;
    }
}
