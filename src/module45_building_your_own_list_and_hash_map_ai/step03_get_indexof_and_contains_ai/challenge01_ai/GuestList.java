// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step03_get_indexof_and_contains_ai.challenge01_ai;

public class GuestList {
    private String[] names;
    private int size;

    public GuestList() {
        this.names = new String[2];
        this.size = 0;
    }

    public void add(String name) {
        if (this.size == this.names.length) {
            grow();
        }
        this.names[this.size] = name;
        this.size++;
    }

    private void grow() {
        String[] bigger = new String[this.names.length * 2];
        for (int i = 0; i < this.size; i++) {
            bigger[i] = this.names[i];
        }
        this.names = bigger;
    }

    public int size() {
        return this.size;
    }

    // Write get and contains here.

    @Override
    public String toString() {
        String text = "";
        for (int i = 0; i < this.size; i++) {
            if (i > 0) {
                text += ", ";
            }
            text += this.names[i];
        }
        return text;
    }
}
