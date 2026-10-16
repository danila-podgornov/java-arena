// AI-Generated
package module24_lists_inside_objects_ai.step02_a_list_as_an_instance_variable_ai.challenge03_ai;

import java.util.ArrayList;

public class Choir {
    private String name;
    private ArrayList<String> singers;

    public Choir(String name) {
        this.name = name;
    }

    public void join(String singer) {
        this.singers.add(singer);
    }

    public int size() {
        return this.singers.size();
    }

    // Write the isEmpty method here.
}
