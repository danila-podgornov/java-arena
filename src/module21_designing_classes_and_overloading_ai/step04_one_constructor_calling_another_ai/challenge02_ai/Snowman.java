// AI-Generated
package module21_designing_classes_and_overloading_ai.step04_one_constructor_calling_another_ai.challenge02_ai;

public class Snowman {
    private int balls;
    private String nose;

    public Snowman() {
        this.balls = 3;
        this.nose = "carrot";
    }

    public Snowman(int balls) {
        this.balls = balls;
        this.nose = "carrot";
    }

    public Snowman(int balls, String nose) {
        this.balls = balls;
        this.nose = nose;
    }

    public String toString() {
        return this.balls + " balls, " + this.nose + " nose";
    }
}
