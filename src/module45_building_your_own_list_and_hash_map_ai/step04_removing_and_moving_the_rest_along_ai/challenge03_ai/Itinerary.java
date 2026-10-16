// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step04_removing_and_moving_the_rest_along_ai.challenge03_ai;

public class Itinerary {
    private String[] stops;
    private int size;

    public Itinerary() {
        this.stops = new String[4];
        this.size = 0;
    }

    public void add(String stop) {
        if (this.size == this.stops.length) {
            grow();
        }
        this.stops[this.size] = stop;
        this.size++;
    }

    // Write add(int index, String stop) here.

    private void grow() {
        String[] bigger = new String[this.stops.length * 2];
        for (int i = 0; i < this.size; i++) {
            bigger[i] = this.stops[i];
        }
        this.stops = bigger;
    }

    public int size() {
        return this.size;
    }

    public String remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + this.size);
        }
        String removed = this.stops[index];
        for (int i = index; i < this.size - 1; i++) {
            this.stops[i] = this.stops[i + 1];
        }
        this.stops[this.size - 1] = null;
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
            text += this.stops[i];
        }
        return text + "]";
    }
}
