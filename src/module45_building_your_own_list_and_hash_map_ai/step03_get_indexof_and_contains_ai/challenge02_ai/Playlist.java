// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step03_get_indexof_and_contains_ai.challenge02_ai;

public class Playlist {
    private String[] songs;
    private int size;

    public Playlist() {
        this.songs = new String[4];
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

    public String get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + this.size);
        }
        return this.songs[index];
    }

    public int indexOf(String song) {
        for (int i = 0; i < this.size; i++) {
            if (this.songs[i].equals(song)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(String song) {
        return indexOf(song) >= 0;
    }
}
