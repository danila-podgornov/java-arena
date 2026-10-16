// AI-Generated
package module17_classes_and_objects_ai.step06_several_objects_ai.challenge02_ai;

public class Candle {
    private String scent;
    private int minutes;

    public Candle(String scent, int minutes) {
        this.scent = scent;
        this.minutes = minutes;
    }

    public void burn(int time) {
        this.minutes = this.minutes - time;
        if (this.minutes < 0) {
            this.minutes = 0;
        }
    }

    public void printInfo() {
        System.out.println(this.scent + ": " + this.minutes + " minutes left");
    }
}
