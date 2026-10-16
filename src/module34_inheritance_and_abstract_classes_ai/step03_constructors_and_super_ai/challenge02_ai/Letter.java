// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step03_constructors_and_super_ai.challenge02_ai;

public class Letter extends Shipment {
    private boolean express;

    public Letter(int number, boolean express) {
        super("L-" + number);
        this.express = express;
        System.out.println("Letter, express: " + express);
    }
}
