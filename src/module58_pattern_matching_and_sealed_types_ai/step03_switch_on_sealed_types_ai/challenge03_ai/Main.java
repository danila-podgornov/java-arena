// AI-Generated
package module58_pattern_matching_and_sealed_types_ai.step03_switch_on_sealed_types_ai.challenge03_ai;

public class Main {
    /**
     * Back in the chat app, ChatMessage is now sealed, with three records. Write {@code preview(ChatMessage message)} with a switch expression, using {@code when} for the special cases:
     * <ul>
     * <li>a text message longer than 20 characters: the sender, {@code : }, its first 20 characters and {@code ...};
     * <li>any other text message: the sender, {@code : } and the text;
     * <li>a photo over 1000 kB: the sender and {@code : [large photo, } and the size and {@code  kB]};
     * <li>any other photo: the sender and {@code : [photo]};
     * <li>a sticker: the sender and {@code : [sticker } and the sticker's name and {@code ]}.
     * </ul>
     * <p>Don't use {@code default}. The check runs:
     * <pre>{@code
     * System.out.println(preview(new TextMessage("Aino", "Lunch at noon?")));
     * System.out.println(preview(new TextMessage("Ben", "Running late, the bus never came")));
     * System.out.println(preview(new PhotoMessage("Chen", "menu.jpg", 840)));
     * System.out.println(preview(new PhotoMessage("Chen", "view.png", 4200)));
     * System.out.println(preview(new StickerMessage("Dora", "thumbs up")));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Aino: Lunch at noon?
     * Ben: Running late, the bu...
     * Chen: [photo]
     * Chen: [large photo, 4200 kB]
     * Dora: [sticker thumbs up]
     * }</pre>
     * Hints
     * 1. Put each guarded case before the plain case of the same type: {@code case TextMessage typed when typed.text().length() > 20 -> ...} and then {@code case TextMessage typed -> ...}.
     * 2. {@code typed.text().substring(0, 20)} gives the first 20 characters. A photo is large when {@code photo.kilobytes() > 1000}.
     */
    public static void main(String[] args) {
        System.out.println(preview(new TextMessage("Aino", "Lunch at noon?")));
        System.out.println(preview(new TextMessage("Ben", "Running late, the bus never came")));
        System.out.println(preview(new PhotoMessage("Chen", "menu.jpg", 840)));
        System.out.println(preview(new PhotoMessage("Chen", "view.png", 4200)));
        System.out.println(preview(new StickerMessage("Dora", "thumbs up")));
    }

    public static String preview(ChatMessage message) {
        return "";
    }
}
