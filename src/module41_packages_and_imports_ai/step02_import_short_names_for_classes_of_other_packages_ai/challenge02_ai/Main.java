// AI-Generated
package module41_packages_and_imports_ai.step02_import_short_names_for_classes_of_other_packages_ai.challenge02_ai;

import module41_packages_and_imports_ai.step02_import_short_names_for_classes_of_other_packages_ai.challenge02_ai.school.domain.*;

public class Main {
    /**
     * A school's timetable program has two classes in the package {@code school.domain}: {@code Period}, a lesson of the day with its subject and its number, and {@code Teacher}. Main imports the whole package. What does this program print?
     * Hints
     * 1. {@code import school.domain.*;} lets Main use both Teacher and Period by their simple names. Teacher uses Period without an import, since they're in the same package.
     * 2. {@code subjects()} builds a new list each time it's called, so adding Music to that list doesn't give the teacher a third period. {@code java.util.ArrayList} is the list's full name, and Teacher's full name starts with its package.
     */
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Ms. Ito");
        teacher.teach(new Period("Math", 1));
        teacher.teach(new Period("Art", 3));
        java.util.ArrayList<String> subjects = teacher.subjects();
        subjects.add("Music");
        System.out.println(teacher + " " + subjects);
        System.out.println(subjects.getClass().getName());
        System.out.println(teacher.getClass().getName());
    }
}
