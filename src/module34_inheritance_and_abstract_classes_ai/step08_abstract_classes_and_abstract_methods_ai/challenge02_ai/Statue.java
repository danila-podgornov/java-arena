// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step08_abstract_classes_and_abstract_methods_ai.challenge02_ai;

public class Statue extends Exhibit {
    private int kilograms;

    public Statue(String name, int kilograms) {
        super(name);
        this.kilograms = kilograms;
    }

    @Override
    public String room() {
        if (this.kilograms > 500) {
            return "ground floor hall";
        }
        return "sculpture gallery";
    }
}
