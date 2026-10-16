// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step08_why_lookups_stay_fast_ai.challenge01_ai;

public class SimpleList<T> {
    private T[] values;
    private int size;
    private int comparisons;

    @SuppressWarnings("unchecked")
    public SimpleList() {
        this.values = (T[]) new Object[4];
        this.size = 0;
        this.comparisons = 0;
    }

    @SuppressWarnings("unchecked")
    public void add(T value) {
        if (this.size == this.values.length) {
            T[] bigger = (T[]) new Object[this.values.length * 2];
            for (int i = 0; i < this.size; i++) {
                bigger[i] = this.values[i];
            }
            this.values = bigger;
        }
        this.values[this.size] = value;
        this.size++;
    }

    public boolean contains(T value) {
        for (int i = 0; i < this.size; i++) {
            this.comparisons++;
            if (this.values[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public int getComparisons() {
        return this.comparisons;
    }
}
