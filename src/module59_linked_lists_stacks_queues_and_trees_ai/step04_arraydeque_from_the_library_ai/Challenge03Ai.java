// AI-Generated
package module59_linked_lists_stacks_queues_and_trees_ai.step04_arraydeque_from_the_library_ai;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Challenge03Ai {
    /**
     * A small text editor has undo and redo. The program reads lines until {@code end}:
     * <ul>
     * <li>{@code undo} takes back the last word typed that is still in the text. It prints {@code nothing to undo} when the text is empty.
     * <li>{@code redo} puts back the word that the last {@code undo} took away (after two undos, two redos put both words back, in their order). It prints {@code nothing to redo} when there's nothing to put back. Typing a new word forgets everything that could still be redone.
     * <li>Any other line is a word typed: it goes at the end of the text.
     * </ul>
     * <p>At {@code end}, the program prints the text, its words separated by single spaces, or {@code (empty)} when it has no words. Use two ArrayDeques: one for the words of the text, and one as a stack of the words that undo took away. With this input:
     * <p>Input
     * <pre>{@code
     * dear
     * old
     * friend
     * undo
     * undo
     * redo
     * pal
     * redo
     * end
     * }</pre>
     * <p>the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * nothing to redo
     * dear old pal
     * }</pre>
     * Hints
     * 1. Keep the text in {@code words} with {@code addLast} and take the last word back with {@code removeLast}, so the words stay in the order they were typed. {@code undo} pushes the removed word onto {@code undone}.
     * 2. {@code redo} pops from {@code undone} and adds that word at the end of {@code words}. A typed word is added with {@code words.addLast(line);} and then {@code undone.clear();}. At the end, {@code String.join(" ", words)} joins the words with spaces (module 39).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> words = new ArrayDeque<>();
        ArrayDeque<String> undone = new ArrayDeque<>();

    }
}
