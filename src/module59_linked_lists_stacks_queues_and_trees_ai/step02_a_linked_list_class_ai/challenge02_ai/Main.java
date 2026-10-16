// AI-Generated
package module59_linked_lists_stacks_queues_and_trees_ai.step02_a_linked_list_class_ai.challenge02_ai;

public class Main {
    /**
     * Give {@code ReadingList} a reference to its last node, so that it can add at the end in a few steps:
     * <ul>
     * <li>add an instance variable {@code private TitleNode tail;};
     * <li>make {@code addFirst} keep it right: after adding to an empty list, {@code tail} refers to the new node too;
     * <li>write {@code addLast(String title)}, which adds the title at the end, using {@code tail} and no loop.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * ReadingList list = new ReadingList();
     * list.addLast("Emma");
     * list.addLast("Dune");
     * list.addFirst("Beloved");
     * list.addLast("Ulysses");
     * System.out.println(list);
     * System.out.println(list.size());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * [Beloved, Emma, Dune, Ulysses]
     * 4
     * }</pre>
     * Hints
     * 1. In {@code addLast}, make the new node with {@code next} as {@code null}. If the list is empty ({@code tail} is {@code null}), it's the first node too: {@code this.head = node;}. Otherwise link it after the last node: {@code this.tail.next = node;}. Either way, {@code this.tail = node;} and add 1 to the size.
     * 2. In {@code addFirst}, the new node is also the last one when the list was empty: after setting {@code head}, {@code if (this.tail == null) { this.tail = this.head; }}.
     */
    public static void main(String[] args) {
        ReadingList list = new ReadingList();
        list.addLast("Emma");
        list.addLast("Dune");
        list.addFirst("Beloved");
        list.addLast("Ulysses");
        System.out.println(list);
        System.out.println(list.size());
    }
}
