// AI-Generated
package module50_gui_multiple_views_ai.step05_logic_apart_from_the_views_ai.challenge03_ai;

public class Excursion {
    private String name;
    private int seats;
    private int booked;

    public Excursion(String name, int seats) {
        this.name = name;
        this.seats = seats;
    }

    public boolean book(int count) {
        if (count < 1 || count > this.free()) {
            return false;
        }
        this.booked += count;
        return true;
    }

    public int free() {
        return this.seats - this.booked;
    }

    @Override
    public String toString() {
        if (this.free() == 0) {
            return this.name + ": sold out";
        }
        return this.name + ": " + this.free() + " of " + this.seats + " seats free";
    }
}
