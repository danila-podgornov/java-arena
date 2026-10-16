// AI-Generated
package module22_primitive_and_reference_variables_ai.step04_null_and_nullpointerexception_ai.challenge02_ai;

public class Main {
    /**
     * A profile shows its nickname when it has one, and the full name otherwise. The program crashes on Tom, who never set a nickname: his {@code nickname} is still {@code null}, not the empty String {@code ""}. Read the crash message, then fix {@code Profile.java} so the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Mia
     * Tom Berg
     * }</pre>
     * Hints
     * 1. The message says {@code "this.nickname" is null}: the constructor never gives {@code nickname} a value, so for Tom it's still {@code null}, and {@code isEmpty()} has no String to run on.
     * 2. Ask whether there's a nickname at all: {@code if (this.nickname == null)}. (Giving {@code nickname} a starting value of {@code ""} in the constructor would work too.)
     */
    public static void main(String[] args) {
        Profile maria = new Profile("Maria Lopez");
        maria.setNickname("Mia");
        Profile tom = new Profile("Tom Berg");
        System.out.println(maria.getDisplayName());
        System.out.println(tom.getDisplayName());
    }
}
