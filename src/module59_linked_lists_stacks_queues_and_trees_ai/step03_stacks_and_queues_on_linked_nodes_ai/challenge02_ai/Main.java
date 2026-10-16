// AI-Generated
package module59_linked_lists_stacks_queues_and_trees_ai.step03_stacks_and_queues_on_linked_nodes_ai.challenge02_ai;

public class Main {
    /**
     * An office printer prints documents in the order they were sent. In {@code PrintQueue.java}, write a queue of document names on linked nodes ({@code JobNode} is ready). Keep references to both the first node and the last one ({@code head} and {@code tail}), so that neither method walks through the queue:
     * <ul>
     * <li>{@code enqueue(String document)} adds a document at the back;
     * <li>{@code dequeue()} removes the document at the front and returns it. On an empty queue it throws an {@code IllegalStateException} with the message {@code Nothing to print};
     * <li>{@code isEmpty()} and {@code size()}.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * PrintQueue queue = new PrintQueue();
     * queue.enqueue("report.pdf");
     * queue.enqueue("map.png");
     * System.out.println("Printing " + queue.dequeue());
     * queue.enqueue("menu.txt");
     * while (!queue.isEmpty()) {
     *     System.out.println("Printing " + queue.dequeue() + ", " + queue.size() + " left");
     * }
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Printing report.pdf
     * Printing map.png, 1 left
     * Printing menu.txt, 0 left
     * }</pre>
     * Hints
     * 1. Three instance variables: {@code head}, {@code tail} (both JobNodes) and {@code size}. {@code enqueue} is step 2's {@code addLast}: on an empty queue the new node becomes the head, otherwise {@code this.tail.next = node;}, and then {@code this.tail = node;}.
     * 2. {@code dequeue} is {@code removeFirst}: check for an empty queue, keep the head's document, move {@code head} on. If the queue is now empty, set {@code tail} to {@code null}, or the next {@code enqueue} would link the new node after a removed one.
     */
    public static void main(String[] args) {
        PrintQueue queue = new PrintQueue();
        queue.enqueue("report.pdf");
        queue.enqueue("map.png");
        System.out.println("Printing " + queue.dequeue());
        queue.enqueue("menu.txt");
        while (!queue.isEmpty()) {
            System.out.println("Printing " + queue.dequeue() + ", " + queue.size() + " left");
        }
    }
}
