// AI-Generated
package module40_class_diagrams_ai.step02_constructors_and_methods_in_a_box_ai.challenge02_ai;

public class Greenhouse {
    private String name;
    private double degrees;
    private boolean open;

    public Greenhouse(String name, double degrees) {
        this.name = name;
        this.degrees = degrees;
        this.open = false;
    }

    public String getName() {
        return this.name;
    }

    public int getDegrees() {
        return this.degrees;
    }

    public boolean isOpen() {
        return this.open;
    }

    public void warm(int by) {
        this.degrees += by;
    }

    private void openVents() {
        this.open = true;
    }
}
