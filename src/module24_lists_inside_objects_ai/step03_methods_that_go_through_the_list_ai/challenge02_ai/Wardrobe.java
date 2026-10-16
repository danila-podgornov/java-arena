// AI-Generated
package module24_lists_inside_objects_ai.step03_methods_that_go_through_the_list_ai.challenge02_ai;

import java.util.ArrayList;

public class Wardrobe {
    private ArrayList<String> clothes;

    public Wardrobe() {
        this.clothes = new ArrayList<>();
    }

    public void hang(String item) {
        this.clothes.add(item);
    }

    public boolean has(String item) {
        return this.clothes.contains(item);
    }

    public int count(String word) {
        int count = 0;
        for (String item : this.clothes) {
            if (item.contains(word)) {
                count++;
            }
        }
        return count;
    }
}
