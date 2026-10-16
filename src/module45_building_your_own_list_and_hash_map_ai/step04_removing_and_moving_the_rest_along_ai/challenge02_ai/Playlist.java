// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step04_removing_and_moving_the_rest_along_ai.challenge02_ai;

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

    public String remove(int index) {
        String removed = get(index);
        for (int i = index; i < this.size - 1; i++) {
            this.songs[i] = this.songs[i + 1];
        }
        this.songs[this.size - 1] = null;
        this.size--;
        return removed;
    }

    @Override
    public String toString() {
        String text = "[";
        for (int i = 0; i < this.size; i++) {
            if (i > 0) {
                text += ", ";
            }
            text += this.songs[i];
        }
        return text + "]";
    }
}
