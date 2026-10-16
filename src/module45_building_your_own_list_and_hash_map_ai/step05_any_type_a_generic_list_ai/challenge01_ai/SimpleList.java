// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step05_any_type_a_generic_list_ai.challenge01_ai;

public class SimpleList<___> {
    private T[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public SimpleList() {
        this.values = (T[]) new ___[4];
        this.size = 0;
    }

    public void add(T value) {
        if (this.size == this.values.length) {
            grow();
        }
        this.values[this.size] = value;
        this.size++;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        T[] bigger = (T[]) new Object[this.values.length * 2];
        for (int i = 0; i < this.size; i++) {
            bigger[i] = this.values[i];
        }
        this.values = bigger;
    }

    public ___ get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + this.size);
        }
        return this.values[index];
    }
}
