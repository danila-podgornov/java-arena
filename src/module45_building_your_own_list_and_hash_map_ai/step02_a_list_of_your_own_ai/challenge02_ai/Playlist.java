// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step02_a_list_of_your_own_ai.challenge02_ai;

public class Playlist {
    private String[] songs;
    private int size;

    public Playlist(int room) {
        this.songs = new String[room];
        this.size = 0;
    }

    public void add(String song) {
        if (this.size == this.songs.length) {
            grow();
        }
        this.songs[this.size] = song;
        this.size++;
    }

    private void grow() {
        String[] bigger = new String[this.songs.length * 2];
        for (int i = 0; i < this.size; i++) {
            bigger[i] = this.songs[i];
        }
        this.songs = bigger;
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.songs.length;
    }
}
