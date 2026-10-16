// AI-Generated
package module24_lists_inside_objects_ai.step09_rules_the_owner_enforces_ai.challenge01_ai;

public class Meeting {
    private String title;
    private int start;
    private int end;

    public Meeting(String title, int start, int end) {
        this.title = title;
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }

    public String toString() {
        return this.title + " (" + this.start + " to " + this.end + ")";
    }
}
