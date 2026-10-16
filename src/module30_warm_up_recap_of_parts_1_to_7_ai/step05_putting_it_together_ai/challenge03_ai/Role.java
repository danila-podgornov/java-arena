// AI-Generated
package module30_warm_up_recap_of_parts_1_to_7_ai.step05_putting_it_together_ai.challenge03_ai;

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

    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof Role)) {
            return false;
        }
        Role other = (Role) compared;
        return this.play.equals(other.play) && this.character.equals(other.character);
    }

    public String toString() {
        return this.character + " in " + this.play + ": " + this.student;
    }
}
