// AI-Generated
package module59_linked_lists_stacks_queues_and_trees_ai.step04_arraydeque_from_the_library_ai;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Challenge01Ai {
    /**
     * A web browser keeps the pages you've opened on a stack, so that its back button can return to the page before. The program reads lines until the line {@code end}:
     * <ul>
     * <li>{@code back} closes the page on top and prints {@code back to } and the page that is now on top. When fewer than two pages are open, it prints {@code can't go back} instead and changes nothing.
     * <li>Any other line is the name of a page to open: it goes on top.
     * </ul>
     * <p>At {@code end}, the program prints {@code now at } and the page on top, or {@code no page open} if there is none. Use an ArrayDeque as the stack, with {@code push}, {@code pop} and {@code peek}. With this input:
     * <p>Input
     * <pre>{@code
     * home
     * news
     * weather
     * back
     * sports
     * back
     * back
     * back
     * end
     * }</pre>
     * <p>the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * back to news
     * back to news
     * back to home
     * can't go back
     * now at home
     * }</pre>
     * Hints
     * 1. Read lines in a {@code while (true)} loop that breaks at {@code end}. A page is opened with {@code pages.push(line);}.
     * 2. For {@code back}, check {@code pages.size() < 2} first. Otherwise {@code pages.pop();} closes the top page, and {@code pages.peek()} is the page you're back to.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> pages = new ArrayDeque<>();

    }
}
