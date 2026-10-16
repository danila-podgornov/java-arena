// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step02_a_list_of_your_own_ai.challenge03_ai;

public class TurnstileLog {
    private int[] values;
    private int size;

    public TurnstileLog() {
        this.values = new int[2];
        this.size = 0;
    }

    public void add(int people) {
        if (this.size > this.values.length) {
            grow();
        }
        this.values[this.size] = people;
        this.size++;
    }

    private void grow() {
        int[] bigger = new int[this.values.length * 2];
        for (int i = 0; i < this.size; i++) {
            bigger[i] = this.values[i];
        }
    }

    public int size() {
        return this.size;
    }

    public int total() {
        int sum = 0;
        for (int i = 0; i < this.size; i++) {
            sum += this.values[i];
        }
        return sum;
    }
}
