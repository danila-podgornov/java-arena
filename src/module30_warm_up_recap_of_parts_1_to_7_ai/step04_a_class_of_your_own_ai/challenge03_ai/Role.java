// AI-Generated
package module30_warm_up_recap_of_parts_1_to_7_ai.step04_a_class_of_your_own_ai.challenge03_ai;

public class Role {
    private String play;
    private String character;
    private String student;

    public Role(String play, String character, String student) {
        this.play = play;
        this.character = character;
        this.student = student;
    }

    public String getStudent() {
        return this.student;
    }

    // Write the equals method here.

    public String toString() {
        return this.character + " in " + this.play + ": " + this.student;
    }
}
