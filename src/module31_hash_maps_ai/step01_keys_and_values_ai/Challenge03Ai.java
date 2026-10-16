// AI-Generated
package module31_hash_maps_ai.step01_keys_and_values_ai;

import java.util.HashMap;

public class Challenge03Ai {
    /**
     * Chat apps turn shortcodes such as {@code :tada:} into emoji. Write the method {@code expand(HashMap<String, String> emoji, String message)}. The map links shortcodes to the names of their emoji. The method returns the message with every word that is a shortcode in the map replaced by the emoji's name in square brackets. Other words stay as they are. The words of a message are separated by single spaces. The check runs:
     * <pre>{@code
     * HashMap<String, String> emoji = new HashMap<>();
     * emoji.put(":tada:", "party popper");
     * emoji.put(":rocket:", "rocket");
     * emoji.put(":coffee:", "hot beverage");
     * System.out.println(expand(emoji, "Launch day :rocket: :tada:"));
     * System.out.println(expand(emoji, ":coffee: first, then :eyes: code"));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Launch day [rocket] [party popper]
     * [hot beverage] first, then :eyes: code
     * }</pre>
     * Hints
     * 1. Split the message into words with {@code message.split(" ")} and go through them. {@code emoji.get(word)} is the name of the word's emoji, or {@code null} when the word isn't a shortcode in the map.
     * 2. Build the result in a String: add either the name in brackets or the word itself, and then a space. At the end, {@code trim()} removes the last space.
     */
    public static void main(String[] args) {
        HashMap<String, String> emoji = new HashMap<>();
        emoji.put(":tada:", "party popper");
        emoji.put(":rocket:", "rocket");
        emoji.put(":coffee:", "hot beverage");
        System.out.println(expand(emoji, "Launch day :rocket: :tada:"));
        System.out.println(expand(emoji, ":coffee: first, then :eyes: code"));
    }

    // Write the method expand here.
}
