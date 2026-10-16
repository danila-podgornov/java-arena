// AI-Generated
package module58_pattern_matching_and_sealed_types_ai.step01_instanceof_with_a_pattern_ai.challenge02_ai;

public class ChatUser {
    private String nickname;
    private String phone;

    public ChatUser(String nickname, String phone) {
        this.nickname = nickname;
        this.phone = phone;
    }

    public String getNickname() {
        return this.nickname;
    }

    @Override
    public int hashCode() {
        return this.phone.hashCode();
    }
}
