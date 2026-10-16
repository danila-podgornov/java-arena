// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step08_abstract_classes_and_abstract_methods_ai.challenge01_ai;

public abstract class Shipment {
    private String code;

    public Shipment(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public abstract int price();

    public String label() {
        return this.code + ": " + this.price() + " dollars";
    }
}
