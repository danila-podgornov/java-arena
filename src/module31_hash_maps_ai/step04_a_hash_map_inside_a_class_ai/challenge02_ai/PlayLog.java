// AI-Generated
package module31_hash_maps_ai.step04_a_hash_map_inside_a_class_ai.challenge02_ai;

import java.util.HashMap;

public class PlayLog {
    private HashMap<String, Integer> plays;

    public PlayLog() {
        this.plays = new HashMap<>();
    }

    public void record(String title) {
        int before = this.plays.getOrDefault(title, 0);
        this.plays.put(title, before + 1);
    }

    public int timesPlayed(String title) {
        return this.plays.getOrDefault(title, 0);
    }

    public int songs() {
        return this.plays.size();
    }
}
