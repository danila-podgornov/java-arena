// AI-Generated
package module38_ordering_objects_comparable_and_comparator_ai.step01_comparable_a_natural_order_for_your_class_ai.challenge02_ai;

public class Entry implements Comparable<Entry> {
    private String team;
    private int score;

    public Entry(String team, int score) {
        this.team = team;
        this.score = score;
    }

    @Override
    public int compareTo(Entry other) {
        return Integer.compare(other.score, this.score);
    }

    @Override
    public String toString() {
        return this.team + " " + this.score;
    }
}
