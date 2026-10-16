// AI-Generated
package module38_ordering_objects_comparable_and_comparator_ai.step03_several_criteria_and_sorted_streams_ai.challenge03_ai;

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
