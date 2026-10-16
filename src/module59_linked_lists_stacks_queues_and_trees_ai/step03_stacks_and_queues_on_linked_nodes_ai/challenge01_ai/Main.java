// AI-Generated
package module59_linked_lists_stacks_queues_and_trees_ai.step03_stacks_and_queues_on_linked_nodes_ai.challenge01_ai;

public class Main {
    /**
     * An office keeps incoming letters in a tray, and the newest letter is always on top. In {@code InTray.java}, write a stack of Strings on linked nodes (the class {@code LetterNode} is ready), with:
     * <ul>
     * <li>{@code push(String letter)} puts a letter on top;
     * <li>{@code pop()} takes the top letter off and returns it;
     * <li>{@code peek()} returns the top letter without taking it off;
     * <li>{@code isEmpty()} and {@code size()}.
     * </ul>
     * <p>{@code pop} and {@code peek} on an empty tray throw an {@code IllegalStateException} with the message {@code The tray is empty}. The check runs:
     * <pre>{@code
     * InTray tray = new InTray();
     * tray.push("invoice");
     * tray.push("postcard");
     * tray.push("tax form");
     * System.out.println(tray.peek() + ", " + tray.size() + " letters");
     * System.out.println(tray.pop());
     * System.out.println(tray.pop());
     * System.out.println(tray.size() + " " + tray.isEmpty());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * tax form, 3 letters
     * tax form
     * postcard
     * 1 false
     * }</pre>
     * Hints
     * 1. Two instance variables: {@code private LetterNode top;} and {@code private int size;}. {@code push} is {@code this.top = new LetterNode(letter, this.top);} and one more in the size.
     * 2. {@code peek} and {@code pop} both start with {@code if (this.top == null) { throw new IllegalStateException("The tray is empty"); }}. {@code pop} then keeps {@code this.top.letter}, moves {@code top} to {@code this.top.next}, and lowers the size.
     */
    public static void main(String[] args) {
        InTray tray = new InTray();
        tray.push("invoice");
        tray.push("postcard");
        tray.push("tax form");
        System.out.println(tray.peek() + ", " + tray.size() + " letters");
        System.out.println(tray.pop());
        System.out.println(tray.pop());
        System.out.println(tray.size() + " " + tray.isEmpty());
    }
}
