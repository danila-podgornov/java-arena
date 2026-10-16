// AI-Generated
package module38_ordering_objects_comparable_and_comparator_ai.step03_several_criteria_and_sorted_streams_ai.challenge02_ai;

public class Crate {
    private String port;
    private int kilos;

    public Crate(String port, int kilos) {
        this.port = port;
        this.kilos = kilos;
    }

    public String getPort() {
        return this.port;
    }

    public int getKilos() {
        return this.kilos;
    }

    @Override
    public String toString() {
        return this.port + " (" + this.kilos + " kg)";
    }
}
