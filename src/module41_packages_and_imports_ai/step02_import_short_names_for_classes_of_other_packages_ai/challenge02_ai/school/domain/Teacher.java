// AI-Generated
package module41_packages_and_imports_ai.step02_import_short_names_for_classes_of_other_packages_ai.challenge02_ai.school.domain;

import java.util.ArrayList;

public class Teacher {
    private String name;
    private ArrayList<Period> periods;

    public Teacher(String name) {
        this.name = name;
        this.periods = new ArrayList<>();
    }

    public void teach(Period period) {
        this.periods.add(period);
    }

    public ArrayList<String> subjects() {
        ArrayList<String> subjects = new ArrayList<>();
        for (Period period : this.periods) {
            subjects.add(period.getSubject());
        }
        return subjects;
    }

    @Override
    public String toString() {
        return this.name + " teaches " + this.periods.size() + " periods";
    }
}
