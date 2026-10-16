// AI-Generated
package module23_objects_working_together_ai.step04_equal_objects_ai.challenge02_ai;

public class Member {
    private int number;
    private String name;

    public Member(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof Member)) {
            return false;
        }
        Member other = (Member) compared;
        return this.number == other.number;
    }
}
