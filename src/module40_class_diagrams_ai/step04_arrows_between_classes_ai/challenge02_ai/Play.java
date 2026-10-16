// AI-Generated
package module40_class_diagrams_ai.step04_arrows_between_classes_ai.challenge02_ai;

public class Play {
    private String title;
    private int minutes;

    public Play(String title, int minutes) {
        this.title = title;
        this.minutes = minutes;
    }

    public String getTitle() {
        return this.title;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public void cut(int minutes) {
        this.minutes -= minutes;
    }
}
