// AI-Generated
package module29_larger_programs_ai.step01_from_a_description_to_a_plan_ai.challenge03_ai;

import java.util.ArrayList;

public class Timetable {
    private ArrayList<Integer> departures;

    public Timetable() {
        this.departures = new ArrayList<>();
    }

    public void add(int time) {
        this.departures.add(time);
    }

    public int nextAfter(int time) {
        for (int departure : this.departures) {
            if (departure > time) {
                return departure;
            }
        }
        return -1;
    }

    public int count() {
        return 0;
    }
}
