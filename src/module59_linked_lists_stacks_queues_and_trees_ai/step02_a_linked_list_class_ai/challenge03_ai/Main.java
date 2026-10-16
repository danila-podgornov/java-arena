// AI-Generated
package module59_linked_lists_stacks_queues_and_trees_ai.step02_a_linked_list_class_ai.challenge03_ai;

public class Main {
    /**
     * {@code ReadingList} now has {@code head}, {@code tail}, {@code addFirst}, {@code addLast} and {@code toString}. Write two more methods:
     * <ul>
     * <li>{@code get(int index)} returns the title at the index, counting from 0 at the front. For an index below 0 or at least the size, it throws an {@code IndexOutOfBoundsException} with the message {@code Index 5 out of bounds for size 3} (with the index and the size it got).
     * <li>{@code removeFirst()} removes the first title and returns it. On an empty list it throws an {@code IllegalStateException} with the message {@code The reading list is empty}. When the last title goes, {@code tail} must become {@code null} too, so that {@code addLast} still works afterwards.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * ReadingList list = new ReadingList();
     * list.addLast("Emma");
     * list.addLast("Dune");
     * list.addLast("Ulysses");
     * System.out.println(list.get(0) + ", " + list.get(2));
     * try {
     *     list.get(5);
     * } catch (IndexOutOfBoundsException e) {
     *     System.out.println(e.getMessage());
     * }
     * System.out.println("Read " + list.removeFirst());
     * System.out.println(list + " " + list.size());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Emma, Ulysses
     * Index 5 out of bounds for size 3
     * Read Emma
     * [Dune, Ulysses] 2
     * }</pre>
     * Hints
     * 1. {@code get} first checks the index: {@code if (index < 0 || index >= this.size) { throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + this.size); }}. Then it starts at {@code head} and moves {@code current = current.next;} index times.
     * 2. {@code removeFirst} keeps the first title in a variable, moves {@code head} on with {@code this.head = this.head.next;}, and lowers the size. If {@code head} is now {@code null}, the list is empty: set {@code tail} to {@code null} too.
     */
    public static void main(String[] args) {
        ReadingList list = new ReadingList();
        list.addLast("Emma");
        list.addLast("Dune");
        list.addLast("Ulysses");
        System.out.println(list.get(0) + ", " + list.get(2));
        try {
            list.get(5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Read " + list.removeFirst());
        System.out.println(list + " " + list.size());
    }
}
