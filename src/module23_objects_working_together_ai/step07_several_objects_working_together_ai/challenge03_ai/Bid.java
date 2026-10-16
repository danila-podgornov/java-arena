// AI-Generated
package module23_objects_working_together_ai.step07_several_objects_working_together_ai.challenge03_ai;

public class Bid {
    private String bidder;
    private int euros;

    public Bid(String bidder, int euros) {
        this.bidder = bidder;
        this.euros = euros;
    }

    public boolean isHigherThan(Bid other) {
        return this.euros > other.euros;
    }

    public String toString() {
        return this.bidder + " (" + this.euros + " euros)";
    }
}
