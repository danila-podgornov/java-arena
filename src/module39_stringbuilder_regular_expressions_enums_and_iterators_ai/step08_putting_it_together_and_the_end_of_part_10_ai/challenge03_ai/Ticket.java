// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step08_putting_it_together_and_the_end_of_part_10_ai.challenge03_ai;

public class Ticket {
    private String holder;
    private Pass pass;

    public Ticket(String holder, Pass pass) {
        this.holder = holder;
        this.pass = pass;
    }

    public String getHolder() {
        return this.holder;
    }

    public Pass getPass() {
        return this.pass;
    }

    @Override
    public String toString() {
        return this.holder + " (" + this.pass + ")";
    }
}
