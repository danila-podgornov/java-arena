// AI-Generated
package module41_packages_and_imports_ai.step06_packages_in_practice_ai.challenge01_ai.planetarium.domain;

public class Show {
    private String title;
    private int minutes;

    public Show(String title, int minutes) {
        this.title = title;
        this.minutes = minutes;
    }

    int getMinutes() {
        return this.minutes;
    }

    @Override
    public String toString() {
        return this.title + " (" + this.minutes + " minutes)";
    }
}
