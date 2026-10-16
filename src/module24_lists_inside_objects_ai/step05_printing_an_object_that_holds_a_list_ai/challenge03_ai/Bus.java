// AI-Generated
package module24_lists_inside_objects_ai.step05_printing_an_object_that_holds_a_list_ai.challenge03_ai;

import java.util.ArrayList;

public class Bus {
    private int line;
    private ArrayList<String> passengers;

    public Bus(int line) {
        this.line = line;
        this.passengers = new ArrayList<>();
    }

    public void board(String name) {
        this.passengers.add(name);
    }

    // Write toString here.
}
