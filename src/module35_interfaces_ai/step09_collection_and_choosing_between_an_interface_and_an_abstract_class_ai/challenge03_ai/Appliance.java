// AI-Generated
package module35_interfaces_ai.step09_collection_and_choosing_between_an_interface_and_an_abstract_class_ai.challenge03_ai;

public abstract class Appliance {
    private String name;

    public Appliance(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract int watts();

    @Override
    public String toString() {
        return this.name + ", " + this.watts() + " W";
    }
}
