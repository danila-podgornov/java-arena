// AI-Generated
package module29_larger_programs_ai.step01_from_a_description_to_a_plan_ai.challenge02_ai;

import java.util.ArrayList;

public class Marathon {
    private ArrayList<Film> films;

    public Marathon() {
        this.films = new ArrayList<>();
    }

    public void add(Film film) {
        this.films.add(film);
    }

    public int count() {
        return this.films.size();
    }

    public int totalMinutes() {
        int total = 0;
        for (Film film : this.films) {
            total += film.getMinutes();
        }
        return total;
    }

    public Film shortest() {
        Film shortest = null;
        for (Film film : this.films) {
            if (shortest == null || film.getMinutes() < shortest.getMinutes()) {
                shortest = film;
            }
        }
        return shortest;
    }
}
