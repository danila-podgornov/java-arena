// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step08_putting_it_together_and_the_end_of_part_10_ai.challenge03_ai;

import java.util.ArrayList;
import java.util.Iterator;

public class BoxOffice {
    private ArrayList<Ticket> tickets;

    public BoxOffice() {
        this.tickets = new ArrayList<>();
    }

    public void sell(String holder, Pass pass) {
        this.tickets.add(new Ticket(holder, pass));
    }

    public int refund(String holder) {
        return 0;
    }

    public String report() {
        return "";
    }
}
