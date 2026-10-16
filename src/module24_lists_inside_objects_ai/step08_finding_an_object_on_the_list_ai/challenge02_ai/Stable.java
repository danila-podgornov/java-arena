// AI-Generated
package module24_lists_inside_objects_ai.step08_finding_an_object_on_the_list_ai.challenge02_ai;

import java.util.ArrayList;

public class Stable {
    private ArrayList<Horse> horses;

    public Stable() {
        this.horses = new ArrayList<>();
    }

    public void add(Horse horse) {
        this.horses.add(horse);
    }

    public Horse find(String name) {
        for (Horse horse : this.horses) {
            if (horse.getName().equals(name)) {
                return horse;
            }
        }
        return null;
    }

    public Horse oldest() {
        if (this.horses.isEmpty()) {
            return null;
        }
        Horse oldest = this.horses.get(0);
        for (Horse horse : this.horses) {
            if (horse.getAge() > oldest.getAge()) {
                oldest = horse;
            }
        }
        return oldest;
    }
}
