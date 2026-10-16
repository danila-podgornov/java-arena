// AI-Generated
package module44_type_parameters_generics_ai.step05_putting_it_together_what_the_compiler_checks_ai.challenge02_ai;

import java.util.ArrayList;

public class History<T> {
    private ArrayList<T> items;
    private int limit;

    public History(int limit) {
        if (limit < 1) {
            throw new IllegalArgumentException("A history must keep at least 1 item, not " + limit);
        }
        this.items = new ArrayList<>();
        this.limit = limit;
    }

    public void add(T item) {
        this.items.add(item);
        if (this.items.size() > this.limit) {
            this.items.remove(0);
        }
    }

    public T latest() {
        if (this.items.isEmpty()) {
            throw new IllegalStateException("The history is empty");
        }
        return this.items.get(this.items.size() - 1);
    }

    @Override
    public String toString() {
        return this.items.toString();
    }
}
