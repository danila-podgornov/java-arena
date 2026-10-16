// AI-Generated
package module23_objects_working_together_ai.step05_equals_and_lists_ai.challenge02_ai;

public class Item {
    private String color;
    private String thing;

    public Item(String color, String thing) {
        this.color = color;
        this.thing = thing;
    }

    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof Item)) {
            return false;
        }
        Item other = (Item) compared;
        return this.color.equals(other.color) && this.thing.equals(other.thing);
    }

    public String toString() {
        return this.color + " " + this.thing;
    }
}
