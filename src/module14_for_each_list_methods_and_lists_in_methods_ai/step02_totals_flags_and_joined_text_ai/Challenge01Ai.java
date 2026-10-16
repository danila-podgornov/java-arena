// AI-Generated
package module14_for_each_list_methods_and_lists_in_methods_ai.step02_totals_flags_and_joined_text_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Challenge01Ai {
    /**
     * A delivery van takes parcels of at most 25 kg each, and at most 100 kg in all. The program reads parcel weights until {@code 0}, into the list {@code parcels}. Add one for-each loop that adds up the weights and keeps a flag that says whether every parcel is 25 kg or less. Print the total, and then {@code Ready to go} when both rules hold, or {@code Repack the van} when either one is broken. For the input 20, 18, 25 and 9 the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Total: 72 kg
     * Ready to go
     * }</pre>
     * Hints
     * 1. Before the loop: {@code int total = 0;} and {@code boolean allLight = true;}. Inside it, add the weight, and set the flag to {@code false} when the weight is over 25.
     * 2. After the loop, both rules at once: {@code if (allLight && total <= 100)}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> parcels = new ArrayList<>();
        while (true) {
            int weight = Integer.valueOf(scanner.nextLine());
            if (weight == 0) {
                break;
            }
            parcels.add(weight);
        }

        // Add up the weights and check every parcel here.
    }
}
