// AI-Generated
package module23_objects_working_together_ai.step07_several_objects_working_together_ai.challenge03_ai;

public class Auction {
    private String item;
    private Bid best;

    public Auction(String item) {
        this.item = item;
        this.best = null;
    }

    // Write the offer method here.

    public String toString() {
        if (this.best == null) {
            return this.item + ": no bids yet";
        }
        return this.item + ": " + this.best;
    }
}
