// AI-Generated
package module58_pattern_matching_and_sealed_types_ai.step01_instanceof_with_a_pattern_ai.challenge02_ai;

import java.util.ArrayList;

public class Main {
    /**
     * The chat app keeps its contacts in a list. A {@code ChatUser} has a nickname and a phone number, and two ChatUsers are the same person when their phone numbers are equal, whatever their nicknames. In {@code ChatUser.java}, write the method {@code equals(Object compared)} the way module 32 did, but with a pattern in place of the cast: {@code true} for the very same object, {@code false} when {@code compared} isn't a ChatUser ({@code null} included), and otherwise a comparison of the phone numbers. The class already has a {@code hashCode} that agrees with it. The check runs:
     * <pre>{@code
     * ArrayList<ChatUser> contacts = new ArrayList<>();
     * contacts.add(new ChatUser("Aino", "040 123 4567"));
     * contacts.add(new ChatUser("Ben", "050 765 4321"));
     * ChatUser newcomer = new ChatUser("Aino K.", "040 123 4567");
     * System.out.println(contacts.contains(newcomer));
     * System.out.println(contacts.indexOf(new ChatUser("Benny", "050 765 4321")));
     * System.out.println(newcomer.equals("040 123 4567"));
     * System.out.println(newcomer.equals(null));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * 1
     * false
     * false
     * }</pre>
     * Hints
     * 1. The header is {@code public boolean equals(Object compared)}, with {@code @Override} above it. Its parameter is an Object, so first check that it's a ChatUser.
     * 2. {@code if (!(compared instanceof ChatUser other)) { return false; }} returns for everything that isn't a ChatUser. After it, {@code other} is a ChatUser: {@code return this.phone.equals(other.phone);}.
     */
    public static void main(String[] args) {
        ArrayList<ChatUser> contacts = new ArrayList<>();
        contacts.add(new ChatUser("Aino", "040 123 4567"));
        contacts.add(new ChatUser("Ben", "050 765 4321"));
        ChatUser newcomer = new ChatUser("Aino K.", "040 123 4567");
        System.out.println(contacts.contains(newcomer));
        System.out.println(contacts.indexOf(new ChatUser("Benny", "050 765 4321")));
        System.out.println(newcomer.equals("040 123 4567"));
        System.out.println(newcomer.equals(null));
    }
}
