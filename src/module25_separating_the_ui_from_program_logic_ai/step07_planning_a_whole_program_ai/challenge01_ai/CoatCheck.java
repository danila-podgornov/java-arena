// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step07_planning_a_whole_program_ai.challenge01_ai;

import java.util.ArrayList;

public class CoatCheck {
    private ArrayList<String> hooks;

    public CoatCheck() {
        this.hooks = new ArrayList<>();
    }

    public int leave(String owner) {
        for (int i = 0; i < this.hooks.size(); i++) {
            if (this.hooks.get(i) == null) {
                this.hooks.set(i, owner);
                return i + 1;
            }
        }
        this.hooks.add(owner);
        return this.hooks.size();
    }

    public String collect(int ticket) {
        if (ticket < 1 || ticket > this.hooks.size()) {
            return null;
        }
        String owner = this.hooks.get(ticket - 1);
        this.hooks.set(ticket - 1, null);
        return owner;
    }

    public int coats() {
        int count = 0;
        for (String owner : this.hooks) {
            if (owner != null) {
                count++;
            }
        }
        return count;
    }
}
