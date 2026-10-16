// AI-Generated
package module40_class_diagrams_ai.step06_inheritance_and_abstract_classes_ai.challenge02_ai;

public class Band extends Performer {
    private int members;

    public Band(String name, int members) {
        super(name);
        this.members = members;
    }

    @Override
    public int slotMinutes() {
        return 30 + 5 * this.members;
    }
}
