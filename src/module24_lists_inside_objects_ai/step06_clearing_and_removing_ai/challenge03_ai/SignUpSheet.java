// AI-Generated
package module24_lists_inside_objects_ai.step06_clearing_and_removing_ai.challenge03_ai;

import java.util.ArrayList;

public class SignUpSheet {
    private ArrayList<String> names;

    public SignUpSheet() {
        this.names = new ArrayList<>();
    }

    public void signUp(String name) {
        this.names.add(name);
    }

    // Write the methods cancel and reset here.

    public String toString() {
        return "Signed up: " + this.names;
    }
}
