// AI-Generated
package module30_warm_up_recap_of_parts_1_to_7_ai.step02_methods_lists_and_arrays_ai;

import java.util.ArrayList;

public class Challenge01Ai {
    /**
     * A cheese stall cuts pieces from big wheels of cheese, and weighs each piece in grams. The pieces from 200 to 300 grams go in the basket labeled "about 250 g". Write the method {@code between(ArrayList<Integer> weights, int low, int high)}. It returns a new list of the weights from {@code low} to {@code high}, both included, in the order they're in. The list it gets must stay as it was. The check runs:
     * <pre>{@code
     * ArrayList<Integer> pieces = new ArrayList<>();
     * pieces.add(240);
     * pieces.add(310);
     * pieces.add(195);
     * pieces.add(300);
     * pieces.add(200);
     * System.out.println(between(pieces, 200, 300));
     * System.out.println(pieces);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * [240, 300, 200]
     * [240, 310, 195, 300, 200]
     * }</pre>
     * Hints
     * 1. The method starts <code>public static ArrayList&lt;Integer&gt; between(ArrayList&lt;Integer&gt; weights, int low, int high) {</code>. Make a new, empty list first, and return it at the end.
     * 2. Go through {@code weights} with a for-each loop, and add a weight to the new list when {@code weight >= low && weight <= high}. Don't remove anything from {@code weights}: it's the caller's own list.
     */
    public static void main(String[] args) {
        ArrayList<Integer> pieces = new ArrayList<>();
        pieces.add(240);
        pieces.add(310);
        pieces.add(195);
        pieces.add(300);
        pieces.add(200);
        System.out.println(between(pieces, 200, 300));
        System.out.println(pieces);
    }

    // Write the method between here.
}
