// AI-Generated
package module35_interfaces_ai.step05_lists_of_an_interface_and_interfaces_as_return_types_ai.challenge02_ai;

import java.util.ArrayList;

public class Main {
    /**
     * The player plays only the long items in the queue: those of at least two minutes. What does this program print?
     * Hints
     * 1. A radio show's length is given in minutes, but {@code seconds()} returns seconds: the Jazz Hour of 2 minutes is 120 seconds, just enough.
     * 2. Each item that's long enough runs its own {@code play}: a show prints {@code On air:}, a memo prints {@code Memo:}. The last item in the list is the birthday song.
     */
    public static void main(String[] args) {
        ArrayList<Playable> queue = new ArrayList<>();
        queue.add(new RadioShow("Jazz Hour", 2));
        queue.add(new VoiceMemo("Parking spot", 30));
        queue.add(new VoiceMemo("Birthday song", 150));
        int count = 0;
        for (Playable item : queue) {
            if (item.seconds() >= 120) {
                item.play();
                count++;
            }
        }
        Playable last = queue.get(queue.size() - 1);
        System.out.println(count + " " + last.title());
    }
}
