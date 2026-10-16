// AI-Generated
package module21_designing_classes_and_overloading_ai.step03_several_constructors_ai.challenge03_ai;

public class Label {
    private String text;

    public Label() {
        this.text = "blank";
    }

    public Label(String text) {
        this.text = text;
    }

    public Label(int number) {
        this.text = "No. " + number;
    }

    public String toString() {
        return "[" + this.text + "]";
    }
}
