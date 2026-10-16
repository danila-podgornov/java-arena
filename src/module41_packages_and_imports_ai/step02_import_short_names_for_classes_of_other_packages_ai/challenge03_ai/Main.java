// AI-Generated
package module41_packages_and_imports_ai.step02_import_short_names_for_classes_of_other_packages_ai.challenge03_ai;

import module41_packages_and_imports_ai.step02_import_short_names_for_classes_of_other_packages_ai.challenge03_ai.school.domain.Period;
import module41_packages_and_imports_ai.step02_import_short_names_for_classes_of_other_packages_ai.challenge03_ai.school.logic.SchoolDay;

public class Main {
    /**
     * {@code Period.java} from the previous task is ready in {@code school/domain/}. In {@code school/logic/SchoolDay.java}, write the class {@code SchoolDay} in the package {@code school.logic}, with the import lines it needs, and:
     * <ul>
     * <li>a constructor {@code SchoolDay()}, which makes a day with no periods yet
     * <li>{@code add(Period period)}, which adds a period to the day
     * <li>{@code subjectAt(int number)}, which returns the subject of the period with that number, or {@code free} if the day has no period with that number
     * <li>{@code count(String subject)}, which returns how many periods of that subject the day has
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * SchoolDay monday = new SchoolDay();
     * monday.add(new Period("Math", 1));
     * monday.add(new Period("Biology", 2));
     * monday.add(new Period("Math", 4));
     * System.out.println(monday.subjectAt(2));
     * System.out.println(monday.subjectAt(3));
     * System.out.println(monday.count("Math"));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Biology
     * free
     * 2
     * }</pre>
     * Hints
     * 1. The file starts with {@code package school.logic;}, then two imports: {@code java.util.ArrayList} for the list, and {@code school.domain.Period}, which is in another package. Then comes <code>public class SchoolDay {</code>.
     * 2. Keep the periods in an {@code ArrayList<Period>}. {@code subjectAt} goes through them and returns the subject of the one whose {@code getNumber()} is the number; after the loop, it returns {@code "free"}. {@code count} compares subjects with {@code equals}.
     */
    public static void main(String[] args) {
        SchoolDay monday = new SchoolDay();
        monday.add(new Period("Math", 1));
        monday.add(new Period("Biology", 2));
        monday.add(new Period("Math", 4));
        System.out.println(monday.subjectAt(2));
        System.out.println(monday.subjectAt(3));
        System.out.println(monday.count("Math"));
    }
}
