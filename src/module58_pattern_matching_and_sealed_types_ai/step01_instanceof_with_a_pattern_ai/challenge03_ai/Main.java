// AI-Generated
package module58_pattern_matching_and_sealed_types_ai.step01_instanceof_with_a_pattern_ai.challenge03_ai;

import java.util.ArrayList;

public class Main {
    /**
     * In a chat, {@code @Aino} in a text message mentions Aino. Write the method {@code mentions(ArrayList<ChatMessage> chat, String name)} in {@code Main.java}. It prints each text message whose text contains {@code @} and the name, as {@code sender: text}, in the chat's order, and returns how many it printed. Other kinds of message are skipped. Write the test as one condition: a type pattern, {@code &&}, and a check that uses the pattern variable. The check runs:
     * <pre>{@code
     * ArrayList<ChatMessage> chat = new ArrayList<>();
     * chat.add(new TextMessage("Ben", "@Aino lunch at noon?"));
     * chat.add(new PhotoMessage("Aino", "menu.jpg", 840));
     * chat.add(new TextMessage("Chen", "Can I join? @Ben"));
     * chat.add(new TextMessage("Aino", "Sure @Chen @Ben"));
     * System.out.println(mentions(chat, "Ben") + " mentions");
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Chen: Can I join? @Ben
     * Aino: Sure @Chen @Ben
     * 2 mentions
     * }</pre>
     * Hints
     * 1. Go through the chat with a for-each loop and count the messages you print in a variable.
     * 2. The condition is {@code message instanceof TextMessage typed && typed.text().contains("@" + name)}: the right side runs only for text messages, so {@code typed} can be used there.
     */
    public static void main(String[] args) {
        ArrayList<ChatMessage> chat = new ArrayList<>();
        chat.add(new TextMessage("Ben", "@Aino lunch at noon?"));
        chat.add(new PhotoMessage("Aino", "menu.jpg", 840));
        chat.add(new TextMessage("Chen", "Can I join? @Ben"));
        chat.add(new TextMessage("Aino", "Sure @Chen @Ben"));
        System.out.println(mentions(chat, "Ben") + " mentions");
    }

    public static int mentions(ArrayList<ChatMessage> chat, String name) {
        return 0;
    }
}
