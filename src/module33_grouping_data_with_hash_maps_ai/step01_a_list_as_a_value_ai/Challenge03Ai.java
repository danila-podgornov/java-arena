// AI-Generated
package module33_grouping_data_with_hash_maps_ai.step01_a_list_as_a_value_ai;

import java.util.ArrayList;
import java.util.HashMap;

public class Challenge03Ai {
    /**
     * A music app keeps the songs of each album. Write two methods:
     * <ul>
     * <li>{@code addSong(HashMap<String, ArrayList<String>> albums, String album, String song)} adds the song to the album's list, and creates the list for the album's first song.
     * <li>{@code songsOn(HashMap<String, ArrayList<String>> albums, String album)} returns the album's list of songs, or an empty list for an album that has none.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * HashMap<String, ArrayList<String>> albums = new HashMap<>();
     * addSong(albums, "Long Weekend", "Porch Swing");
     * addSong(albums, "Green Signal", "Crosswalk");
     * addSong(albums, "Long Weekend", "Cloud Shapes");
     * System.out.println(songsOn(albums, "Long Weekend"));
     * System.out.println(songsOn(albums, "Winter Tapes").size());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * [Porch Swing, Cloud Shapes]
     * 0
     * }</pre>
     * Hints
     * 1. {@code addSong} is the {@code join} of this step with new names: create the album's list when {@code containsKey} says it isn't there, and then add the song to {@code albums.get(album)}.
     * 2. {@code songsOn} can be one line: {@code return albums.getOrDefault(album, new ArrayList<>());}. For an album with no songs, {@code get} would return {@code null}, and the check's {@code size()} would crash.
     */
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> albums = new HashMap<>();
        addSong(albums, "Long Weekend", "Porch Swing");
        addSong(albums, "Green Signal", "Crosswalk");
        addSong(albums, "Long Weekend", "Cloud Shapes");
        System.out.println(songsOn(albums, "Long Weekend"));
        System.out.println(songsOn(albums, "Winter Tapes").size());
    }

    // Write the methods addSong and songsOn here.
}
