// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step02_getters_ai.challenge03_ai;

public class Pencil {
    private int length;

    public Pencil(int length) {
        this.length = length;
    }

    public void sharpen(int turns) {
        this.length = this.length - turns / 10;
    }

    public int getLength() {
        return this.length;
    }
}
