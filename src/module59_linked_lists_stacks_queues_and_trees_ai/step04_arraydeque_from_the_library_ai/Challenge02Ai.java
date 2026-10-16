// AI-Generated
package module59_linked_lists_stacks_queues_and_trees_ai.step04_arraydeque_from_the_library_ai;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Challenge02Ai {
    /**
     * A ticket office serves people in the order they joined the line. The program reads lines until {@code end}:
     * <ul>
     * <li>{@code join } and a name: the person joins the back of the line;
     * <li>{@code serve}: the person at the front leaves the line, and the program prints {@code serving } and their name, or {@code nobody in line} when the line is empty.
     * </ul>
     * <p>At {@code end}, it prints {@code still waiting: } and the line, front first, as an ArrayDeque prints itself. Use an ArrayDeque as a queue, with {@code offer} and {@code poll}. With this input:
     * <p>Input
     * <pre>{@code
     * join Ada
     * join Bo
     * serve
     * join Cy
     * join Dee
     * serve
     * end
     * }</pre>
     * <p>the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * serving Ada
     * serving Bo
     * still waiting: [Cy, Dee]
     * }</pre>
     * Hints
     * 1. {@code command.startsWith("join ")} spots a join, and {@code command.substring(5)} is the name after it. {@code line.offer(name);} puts the person at the back.
     * 2. {@code line.poll()} returns the person at the front, or {@code null} when the line is empty. At the end, {@code "still waiting: " + line} prints the deque in square brackets.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
}
