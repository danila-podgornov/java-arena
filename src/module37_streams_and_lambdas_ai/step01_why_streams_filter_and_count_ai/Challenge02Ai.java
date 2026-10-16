// AI-Generated
package module37_streams_and_lambdas_ai.step01_why_streams_filter_and_count_ai;

import java.util.ArrayList;

public class Challenge02Ai {
    /**
     * What does this program print?
     * Hints
     * 1. The first stream keeps the rides of at least 25 km, and of those, the ones under 60 km. The second keeps the rides of exactly 60 km.
     * 2. 25, 33 and 48 pass both filters of the first stream, and 60 is in the list twice. The streams don't change the list: it still has 6 rides, and index 2 is still 12.
     */
    public static void main(String[] args) {
        ArrayList<Integer> rides = new ArrayList<>();
        rides.add(25);
        rides.add(60);
        rides.add(12);
        rides.add(60);
        rides.add(33);
        rides.add(48);

        long first = rides.stream()
                .filter(km -> km >= 25)
                .filter(km -> km < 60)
                .count();
        long second = rides.stream()
                .filter(km -> km == 60)
                .count();
        System.out.println(first + " " + second);
        System.out.println(rides.size() + " " + rides.get(2));
    }
}
