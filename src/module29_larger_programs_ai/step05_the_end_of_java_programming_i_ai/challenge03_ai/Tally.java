// AI-Generated
package module29_larger_programs_ai.step05_the_end_of_java_programming_i_ai.challenge03_ai;

public class Tally {
    private String label;
    private int count;

    public Tally(String label) {
        this.label = label;
        this.count = 0;
    }

    public String getLabel() {
        return this.label;
    }

    public int getCount() {
        return this.count;
    }

    public void add() {
        this.count++;
    }

    public String toString() {
        return this.label + ": " + this.count;
    }
}
