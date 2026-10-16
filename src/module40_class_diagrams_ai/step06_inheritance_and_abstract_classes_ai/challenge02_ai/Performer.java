// AI-Generated
package module40_class_diagrams_ai.step06_inheritance_and_abstract_classes_ai.challenge02_ai;

public class Performer {
    private String name;

    public Performer(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int slotMinutes() {
        return 0;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.slotMinutes() + " min";
    }
}
