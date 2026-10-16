// AI-Generated
package module40_class_diagrams_ai.step07_interfaces_and_a_whole_program_ai.challenge02_ai;

public class Tires ___ DropOff ___ Weighable {
    private int count;

    public Tires(int kilos, int count) {
        super(kilos);
        this.count = count;
    }

    @Override
    public int fee() {
        return 4 * this.count;
    }

    @Override
    public int weight() {
        return this.getKilos();
    }
}
