// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step04_overriding_methods_override_and_super_ai.challenge02_ai;

public class NightTour extends Tour {
    @Override
    public void start() {
        System.out.println("Hand out flashlights");
        super.start();
    }

    @Override
    public void end() {
        super.end();
        System.out.println("Lock the side door");
    }
}
