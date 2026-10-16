// AI-Generated
package module22_primitive_and_reference_variables_ai.step04_null_and_nullpointerexception_ai.challenge02_ai;

public class Profile {
    private String name;
    private String nickname;

    public Profile(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDisplayName() {
        if (this.nickname.isEmpty()) {
            return this.name;
        }
        return this.nickname;
    }
}
