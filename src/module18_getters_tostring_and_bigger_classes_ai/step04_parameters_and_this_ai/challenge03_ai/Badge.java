// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step04_parameters_and_this_ai.challenge03_ai;

public class Badge {
    private String name;
    private int level;

    public Badge(String name) {
        this.name = name;
        this.level = 1;
    }

    public void rename(String name) {
        name = name.toUpperCase();
    }

    public void levelUp(int levels) {
        this.level = this.level + levels;
    }

    public String toString() {
        return this.name + " (level " + this.level + ")";
    }
}
