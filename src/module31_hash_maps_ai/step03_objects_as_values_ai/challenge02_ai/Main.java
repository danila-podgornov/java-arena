// AI-Generated
package module31_hash_maps_ai.step03_objects_as_values_ai.challenge02_ai;

import java.util.HashMap;

public class Main {
    /**
     * A radio station finds the tracks it plays by a key, and one track got two keys: its title, and a short name. What does this program print?
     * Hints
     * 1. {@code new Track} runs only once for Night Bus, so both keys lead to the same object, and so does the variable {@code bus}. All three {@code addPlay} calls change that one object.
     * 2. The second {@code put} for {@code nb} links the key to a new Track, Neon Bridges, which replaces the old value of {@code nb}. The Night Bus object doesn't change, and it's still in the map under {@code night bus}.
     */
    public static void main(String[] args) {
        HashMap<String, Track> tracks = new HashMap<>();
        Track bus = new Track("Night Bus");
        tracks.put("night bus", bus);
        tracks.put("nb", bus);
        tracks.get("night bus").addPlay();
        tracks.get("nb").addPlay();
        bus.addPlay();
        System.out.println(tracks.get("night bus").getPlays());

        tracks.put("nb", new Track("Neon Bridges"));
        tracks.get("nb").addPlay();
        System.out.println(bus.getPlays() + " " + tracks.get("nb").getPlays());
        System.out.println(tracks.size() + " " + tracks.get("nb").getTitle());
    }
}
