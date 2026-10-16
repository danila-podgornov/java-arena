// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step06_the_objects_class_decides_which_method_runs_ai.challenge01_ai;

public class Knight extends Adventurer {
    public Knight(String name) {
        super(name);
    }

    @Override
    public int attack() {
        return 9;
    }

    @Override
    public String describe() {
        return super.describe() + " and raises a shield";
    }
}
