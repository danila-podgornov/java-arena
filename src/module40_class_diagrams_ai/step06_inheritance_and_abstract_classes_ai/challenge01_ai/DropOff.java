// AI-Generated
package module40_class_diagrams_ai.step06_inheritance_and_abstract_classes_ai.challenge01_ai;

public abstract class DropOff {
    private int kilos;

    public DropOff(int kilos) {
        this.kilos = kilos;
    }

    public int getKilos() {
        return this.kilos;
    }

    public abstract int fee();

    @Override
    public String toString() {
        return this.kilos + " kg, fee " + this.fee();
    }
}
