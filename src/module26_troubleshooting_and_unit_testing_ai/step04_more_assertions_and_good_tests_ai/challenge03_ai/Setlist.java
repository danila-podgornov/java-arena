// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step04_more_assertions_and_good_tests_ai.challenge03_ai;

import java.util.ArrayList;

public class Setlist {
    private ArrayList<Song> songs;

    public Setlist() {
        this.songs = new ArrayList<>();
    }

    public void add(Song song) {
        this.songs.add(song);
    }

    public String longestSong() {
        if (this.songs.isEmpty()) {
            return "";
        }
        Song longest = this.songs.get(0);
        for (int i = 1; i < this.songs.size(); i++) {
            if (this.songs.get(i).getSeconds() > longest.getSeconds()) {
                longest = this.songs.get(i);
            }
        }
        return longest.getTitle();
    }
}
