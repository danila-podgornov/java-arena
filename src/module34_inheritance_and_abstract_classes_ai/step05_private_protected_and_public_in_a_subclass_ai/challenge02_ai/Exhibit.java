// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step05_private_protected_and_public_in_a_subclass_ai.challenge02_ai;

public class Exhibit {
    private String name;
    private int condition;

    public Exhibit(String name, int condition) {
        this.name = name;
        this.condition = condition;
    }

    public int getCondition() {
        return this.condition;
    }

    public void age(int years) {
        this.condition -= years;
        if (this.condition < 0) {
            this.condition = 0;
        }
    }

    @Override
    public String toString() {
        return this.name + ", condition " + this.condition;
    }
}
