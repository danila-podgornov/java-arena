// AI-Generated
package module42_exceptions_ai.step07_the_details_of_an_exception_ai.challenge03_ai;

import java.util.ArrayList;

public class Heating {
    private ArrayList<String> changes;

    public Heating() {
        this.changes = new ArrayList<>();
    }

    public void add(String time, int degrees) {
        if (degrees < 5 || degrees > 30) {
            throw new IllegalArgumentException(degrees + " degrees is not a room temperature");
        }
        this.changes.add(time + " " + degrees);
    }

    public int count() {
        return this.changes.size();
    }
}
