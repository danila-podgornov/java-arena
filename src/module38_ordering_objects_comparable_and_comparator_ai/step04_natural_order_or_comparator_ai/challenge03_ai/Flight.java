// AI-Generated
package module38_ordering_objects_comparable_and_comparator_ai.step04_natural_order_or_comparator_ai.challenge03_ai;

public class Flight {
    private String destination;
    private String departs;
    private int gate;

    public Flight(String destination, String departs, int gate) {
        this.destination = destination;
        this.departs = departs;
        this.gate = gate;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getDeparts() {
        return this.departs;
    }

    public int getGate() {
        return this.gate;
    }

    @Override
    public String toString() {
        return this.departs + " " + this.destination + " (gate " + this.gate + ")";
    }
}
