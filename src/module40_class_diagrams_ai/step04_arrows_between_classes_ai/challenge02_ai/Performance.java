// AI-Generated
package module40_class_diagrams_ai.step04_arrows_between_classes_ai.challenge02_ai;

public class Performance {
    private Play play;
    private String date;
    private int seatsSold;

    public Performance(Play play, String date) {
        this.play = play;
        this.date = date;
        this.seatsSold = 0;
    }

    public void sell(int seats) {
        this.seatsSold += seats;
    }

    @Override
    public String toString() {
        return this.play.getTitle() + " (" + this.play.getMinutes() + " min), " + this.date + ": " + this.seatsSold + " seats sold";
    }
}
