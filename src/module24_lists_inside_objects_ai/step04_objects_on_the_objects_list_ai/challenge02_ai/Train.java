// AI-Generated
package module24_lists_inside_objects_ai.step04_objects_on_the_objects_list_ai.challenge02_ai;

import java.util.ArrayList;

public class Train {
    private ArrayList<Wagon> wagons;

    public Train() {
        this.wagons = new ArrayList<>();
    }

    public void attach(Wagon wagon) {
        this.wagons.add(wagon);
    }

    public int count() {
        return this.wagons.size();
    }

    public void print() {
        for (Wagon wagon : this.wagons) {
            System.out.println(wagon);
        }
    }
}
