// AI-Generated
package module24_lists_inside_objects_ai.step07_totals_from_the_objects_on_the_list_ai.challenge01_ai;

public class Leg {
    private String from;
    private String to;
    private int km;

    public Leg(String from, String to, int km) {
        this.from = from;
        this.to = to;
        this.km = km;
    }

    public int getKm() {
        return this.km;
    }

    public String toString() {
        return this.from + " to " + this.to + ", " + this.km + " km";
    }
}
