// AI-Generated
package module49_gui_event_handling_ai.step04_logic_in_a_class_of_its_own_ai.challenge02_ai;

import java.util.ArrayList;

public class UsernameChecker {
    private ArrayList<String> taken;

    public UsernameChecker() {
        this.taken = new ArrayList<>();
    }

    public void addTaken(String name) {
        this.taken.add(name.toLowerCase());
    }

    public boolean isFree(String name) {
        return name.length() >= 3 && !this.taken.contains(name.toLowerCase());
    }

    public String message(String name) {
        if (name.length() < 3) {
            return "At least 3 characters";
        }
        if (this.taken.contains(name.toLowerCase())) {
            return name + " is taken";
        }
        return name + " is free";
    }
}
