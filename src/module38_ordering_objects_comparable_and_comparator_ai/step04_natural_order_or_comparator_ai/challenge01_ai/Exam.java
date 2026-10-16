// AI-Generated
package module38_ordering_objects_comparable_and_comparator_ai.step04_natural_order_or_comparator_ai.challenge01_ai;

public class Exam {
    private String course;
    private int month;
    private int day;

    public Exam(String course, int month, int day) {
        this.course = course;
        this.month = month;
        this.day = day;
    }

    public String getCourse() {
        return this.course;
    }

    @Override
    public String toString() {
        return this.course + " " + this.month + "/" + this.day;
    }
}
