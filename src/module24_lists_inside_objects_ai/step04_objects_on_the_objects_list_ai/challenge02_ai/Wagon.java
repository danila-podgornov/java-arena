// AI-Generated
package module24_lists_inside_objects_ai.step04_objects_on_the_objects_list_ai.challenge02_ai;

public class Wagon {
    private int number;
    private int passengers;

    public Wagon(int number) {
        this.number = number;
        this.passengers = 0;
    }

    public void board(int people) {
        this.passengers = this.passengers + people;
    }

    public String toString() {
        return "Wagon " + this.number + ": " + this.passengers + " passengers";
    }
}
