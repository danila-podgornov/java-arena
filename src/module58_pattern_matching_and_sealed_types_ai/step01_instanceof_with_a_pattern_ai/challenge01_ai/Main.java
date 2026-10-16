// AI-Generated
package module58_pattern_matching_and_sealed_types_ai.step01_instanceof_with_a_pattern_ai.challenge01_ai;

public class Main {
    /**
     * The chat app now has stickers too. The method {@code preview} in {@code Main.java} still uses {@code instanceof} and a cast for each kind of message. Rewrite it with type patterns, so that it has no casts left. It should still print the same: see the expected output below.
     * Expected output
     * <pre>{@code
     * Aino: Lunch at noon?
     * Ben sent a photo, 840 kB
     * Aino sent the sticker thumbs up
     * }</pre>
     * Hints
     * 1. Move each variable's name into the test: {@code message instanceof TextMessage typed}. Then the line with the cast can go.
     * 2. Do the same for PhotoMessage and StickerMessage. The last {@code return} stays: javac can't know that there are no other kinds of ChatMessage (the next step changes that).
     */
    public static void main(String[] args) {
        System.out.println(preview(new TextMessage("Aino", "Lunch at noon?")));
        System.out.println(preview(new PhotoMessage("Ben", "menu.jpg", 840)));
        System.out.println(preview(new StickerMessage("Aino", "thumbs up")));
    }

    public static String preview(ChatMessage message) {
        if (message instanceof TextMessage) {
            TextMessage typed = (TextMessage) message;
            return typed.sender() + ": " + typed.text();
        } else if (message instanceof PhotoMessage) {
            PhotoMessage photo = (PhotoMessage) message;
            return photo.sender() + " sent a photo, " + photo.kilobytes() + " kB";
        } else if (message instanceof StickerMessage) {
            StickerMessage sticker = (StickerMessage) message;
            return sticker.sender() + " sent the sticker " + sticker.name();
        }
        return message.sender() + " sent something new";
    }
}
