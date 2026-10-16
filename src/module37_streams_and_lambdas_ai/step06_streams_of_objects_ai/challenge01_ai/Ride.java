// AI-Generated
package module37_streams_and_lambdas_ai.step06_streams_of_objects_ai.challenge01_ai;

public class Ride {
    private String rider;
    private int km;

    public Ride(String rider, int km) {
        this.rider = rider;
        this.km = km;
    }

    public String getRider() {
        return this.rider;
    }

    public int getKm() {
        return this.km;
    }

    @Override
    public String toString() {
        return this.rider + ": " + this.km + " km";
    }
}
