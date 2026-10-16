// AI-Generated
package module14_for_each_list_methods_and_lists_in_methods_ai.step07_the_list_toolbox_ai;

import java.util.ArrayList;

public class Challenge02Ai {
    /**
     * A phone keeps a list of recently used apps, the most recent first. Write a method {@code markUsed(ArrayList<String> recent, String app)} that moves {@code app} to the front of the list: if it's already in the list, it's taken out of its old place first, so it's never in the list twice. The check builds a list of {@code maps}, {@code mail} and {@code camera}, calls {@code markUsed} with {@code camera} and then with {@code notes}, and prints the list after each call: see the expected output below.
     * Expected output
     * <pre>{@code
     * [camera, maps, mail]
     * [notes, camera, maps, mail]
     * }</pre>
     * Hints
     * 1. {@code recent.remove(app)} takes out the first copy of the app, and does nothing if it isn't there.
     * 2. Then {@code recent.add(0, app);} puts it at the front. The method is {@code void}: it changes the caller's list.
     */
    public static void main(String[] args) {
        ArrayList<String> recent = new ArrayList<>();
        recent.add("maps");
        recent.add("mail");
        recent.add("camera");
        markUsed(recent, "camera");
        System.out.println(recent);
    }

    // Write the markUsed method here.
}
