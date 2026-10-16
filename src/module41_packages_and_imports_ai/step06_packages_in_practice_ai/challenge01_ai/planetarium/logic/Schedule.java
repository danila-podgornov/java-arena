// AI-Generated
package module41_packages_and_imports_ai.step06_packages_in_practice_ai.challenge01_ai.planetarium.logic;

import java.util.ArrayList;
import module41_packages_and_imports_ai.step06_packages_in_practice_ai.challenge01_ai.planetarium.domain.Show;

public class Schedule {
    private ArrayList<Show> shows;

    Schedule() {
        this.shows = new ArrayList<>();
    }

    public void add(Show show) {
        this.shows.add(show);
    }

    public int totalMinutes() {
        int total = 0;
        for (Show show : this.shows) {
            total += show.getMinutes();
        }
        return total;
    }

    public Show longest() {
        Show longest = null;
        for (Show show : this.shows) {
            if (longest == null || show.getMinutes() > longest.getMinutes()) {
                longest = show;
            }
        }
        return longest;
    }
}
