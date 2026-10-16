// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step05_any_type_a_generic_list_ai.challenge02_ai;

public class SimpleList<T> {
    private T[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public SimpleList() {
        this.values = (T[]) new Object[4];
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

    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + this.size);
        }
        return this.values[index];
    }

    public int indexOf(T value) {
        for (int i = 0; i < this.size; i++) {
            if (this.values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public T remove(int index) {
        T removed = get(index);
        for (int i = index; i < this.size - 1; i++) {
            this.values[i] = this.values[i + 1];
        }
        this.values[this.size - 1] = null;
        this.size--;
        return removed;
    }

    public boolean remove(T value) {
        int index = indexOf(value);
        if (index < 0) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public String toString() {
        String text = "[";
        for (int i = 0; i < this.size; i++) {
            if (i > 0) {
                text += ", ";
            }
            text += this.values[i];
        }
        return text + "]";
    }
}
