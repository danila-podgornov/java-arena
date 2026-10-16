// AI-Generated
package module24_lists_inside_objects_ai.step06_clearing_and_removing_ai.challenge02_ai;

import java.util.ArrayList;

public class Toybox {
    private ArrayList<Toy> toys;

    public Toybox() {
        this.toys = new ArrayList<>();
    }

    public void add(Toy toy) {
        this.toys.add(toy);
    }

    public void remove(Toy toy) {
        this.toys.remove(toy);
    }

    public void empty() {
        this.toys.clear();
    }

    public int count() {
        return this.toys.size();
    }

    public String toString() {
        return "Toys: " + this.toys;
    }
}
