// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step06_adding_a_feature_ai.challenge02_ai;

import java.util.ArrayList;

public class Train {
    private ArrayList<String> cars;

    public Train() {
        this.cars = new ArrayList<>();
    }

    public void attach(String kind) {
        this.cars.add(kind);
    }

    public boolean detach() {
        if (this.cars.isEmpty()) {
            return false;
        }
        this.cars.remove(this.cars.size() - 1);
        return true;
    }

    public String toString() {
        String text = "[engine]";
        for (String car : this.cars) {
            text = text + "-[" + car + "]";
        }
        return text;
    }
}
