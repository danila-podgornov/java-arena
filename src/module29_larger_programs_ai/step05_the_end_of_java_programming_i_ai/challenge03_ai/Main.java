// AI-Generated
package module29_larger_programs_ai.step05_the_end_of_java_programming_i_ai.challenge03_ai;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    /**
     * One last trace through the tools of Java Programming I: a class of your own, a list of objects, {@code split}, loops inside loops, references and sorting. What does this program print? Look closely at what {@code tallies} holds.
     * Hints
     * 1. There are only two Tally objects, but the list holds three references: the {@code yes} tally is in it twice (module 22). So every {@code yes} vote finds it twice.
     * 2. Two {@code yes} votes, each counted twice, make 4. {@code maybe} matches nothing. The list of counts gets one number for each of the three references, before it's sorted.
     */
    public static void main(String[] args) {
        ArrayList<Tally> tallies = new ArrayList<>();
        Tally yes = new Tally("yes");
        tallies.add(yes);
        tallies.add(new Tally("no"));
        tallies.add(yes);
        String[] votes = "yes,no,yes,maybe".split(",");
        for (String vote : votes) {
            for (Tally tally : tallies) {
                if (tally.getLabel().equals(vote)) {
                    tally.add();
                }
            }
        }
        ArrayList<Integer> counts = new ArrayList<>();
        for (Tally tally : tallies) {
            counts.add(tally.getCount());
        }
        Collections.sort(counts);
        System.out.println(tallies.size());
        System.out.println(yes);
        System.out.println(counts);
    }
}
