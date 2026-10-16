// AI-Generated
package module33_grouping_data_with_hash_maps_ai.step02_counting_and_grouping_ai.challenge03_ai;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    /**
     * The music app now keeps its songs as objects. {@code Song.java} is ready: a song has a title, an album and a length in seconds, with the getters {@code getTitle()}, {@code getAlbum()} and {@code getSeconds()}, and its {@code toString} gives the title. In {@code Main.java}, write the method {@code byAlbum(ArrayList<Song> songs)}, which returns a new {@code HashMap<String, ArrayList<Song>>} from each album to the list of its songs, in the order they are in {@code songs}. The check runs:
     * <pre>{@code
     * ArrayList<Song> songs = new ArrayList<>();
     * songs.add(new Song("Crosswalk", "Green Signal", 214));
     * songs.add(new Song("Porch Swing", "Long Weekend", 187));
     * songs.add(new Song("Rush Hour", "Green Signal", 243));
     * songs.add(new Song("Cloud Shapes", "Long Weekend", 205));
     * songs.add(new Song("Detour", "Green Signal", 198));
     * HashMap<String, ArrayList<Song>> albums = byAlbum(songs);
     * System.out.println(albums.get("Green Signal"));
     * System.out.println(albums.get("Long Weekend"));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * [Crosswalk, Rush Hour, Detour]
     * [Porch Swing, Cloud Shapes]
     * }</pre>
     * Hints
     * 1. It's {@code groupByBed} from above, for songs. Create the map, go through the songs with a for-each loop, and use {@code song.getAlbum()} as the key.
     * 2. Put a new list in the map when the album isn't a key yet, and then add the Song object itself to {@code albums.get(album)}. Return the map after the loop.
     */
    public static void main(String[] args) {
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Crosswalk", "Green Signal", 214));
        songs.add(new Song("Porch Swing", "Long Weekend", 187));
        songs.add(new Song("Rush Hour", "Green Signal", 243));
        songs.add(new Song("Cloud Shapes", "Long Weekend", 205));
        songs.add(new Song("Detour", "Green Signal", 198));
        HashMap<String, ArrayList<Song>> albums = byAlbum(songs);
        System.out.println(albums.get("Green Signal"));
        System.out.println(albums.get("Long Weekend"));
    }

    // Write the method byAlbum here.
}
