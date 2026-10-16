// AI-Generated
package module31_hash_maps_ai.step04_a_hash_map_inside_a_class_ai.challenge02_ai;

public class Main {
    /**
     * A radio station keeps a separate play log for its morning show and for its evening show, with the {@code PlayLog} class from above and one more method, {@code songs()}, which returns how many different songs the log has. What does this program print?
     * Hints
     * 1. Each {@code new PlayLog()} runs the constructor, which creates a map of its own. So the two logs have two separate maps, and a song recorded in one isn't in the other.
     * 2. The morning log gets Night Bus twice, and the evening log gets Night Bus once and Slow River once. {@code songs()} is the size of the log's own map: the number of different titles, not of plays.
     */
    public static void main(String[] args) {
        PlayLog morning = new PlayLog();
        PlayLog evening = new PlayLog();
        morning.record("Night Bus");
        evening.record("Night Bus");
        morning.record("Night Bus");
        evening.record("Slow River");
        System.out.println(morning.timesPlayed("Night Bus") + " " + evening.timesPlayed("Night Bus"));
        System.out.println(morning.timesPlayed("Slow River") + " " + evening.timesPlayed("Slow River"));
        System.out.println(morning.songs() + " " + evening.songs());
    }
}
