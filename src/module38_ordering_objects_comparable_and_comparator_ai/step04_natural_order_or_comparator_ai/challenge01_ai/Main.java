// AI-Generated
package module38_ordering_objects_comparable_and_comparator_ai.step04_natural_order_or_comparator_ai.challenge01_ai;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    /**
     * A student's planner lists exams by date. {@code Exam.java} has a course, a month and a day. Make Exam implement {@code Comparable<Exam>}, with a {@code compareTo} that puts exams in date order: by month, and exams in the same month by day. Exams on the same day are a tie, so {@code compareTo} gives 0 and the sort keeps them in the list's order. Put {@code @Override} above {@code compareTo}. The check runs:
     * <pre>{@code
     * ArrayList<Exam> exams = new ArrayList<>();
     * exams.add(new Exam("Statistics", 6, 12));
     * exams.add(new Exam("Algebra", 5, 28));
     * exams.add(new Exam("Biology", 6, 3));
     * exams.add(new Exam("History", 5, 30));
     * Collections.sort(exams);
     * System.out.println(exams);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code [Algebra 5/28, History 5/30, Biology 6/3, Statistics 6/12]}
     * Hints
     * 1. The header becomes <code>public class Exam implements Comparable&lt;Exam&gt; {</code>, and the class gets {@code public int compareTo(Exam other)} with {@code @Override} above it.
     * 2. Compare the months first: {@code int byMonth = Integer.compare(this.month, other.month);}. If {@code byMonth} isn't 0, return it. Otherwise the months are the same, so return {@code Integer.compare(this.day, other.day)}.
     */
    public static void main(String[] args) {
        ArrayList<Exam> exams = new ArrayList<>();
        exams.add(new Exam("Statistics", 6, 12));
        exams.add(new Exam("Algebra", 5, 28));
        exams.add(new Exam("Biology", 6, 3));
        exams.add(new Exam("History", 5, 30));
        Collections.sort(exams);
        System.out.println(exams);
    }
}
