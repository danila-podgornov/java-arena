// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step06_the_objects_class_decides_which_method_runs_ai.challenge02_ai;

public class Adventurer {
    private String name;

    public Adventurer(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int attack() {
        return 2;
    }

    public String describe() {
        return this.name + " attacks for " + this.attack();
    }
}
