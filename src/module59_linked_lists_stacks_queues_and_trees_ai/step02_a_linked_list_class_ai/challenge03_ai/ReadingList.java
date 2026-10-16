// AI-Generated
package module59_linked_lists_stacks_queues_and_trees_ai.step02_a_linked_list_class_ai.challenge03_ai;

public class ReadingList {
    private TitleNode head;
    private TitleNode tail;
    private int size;

    public ReadingList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(String title) {
        this.head = new TitleNode(title, this.head);
        if (this.tail == null) {
            this.tail = this.head;
        }
        this.size++;
    }

    public void addLast(String title) {
        TitleNode node = new TitleNode(title, null);
        if (this.tail == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }
        this.tail = node;
        this.size++;
    }

    public String get(int index) {
        return null;
    }

    public String removeFirst() {
        return null;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String result = "[";
        TitleNode current = this.head;
        while (current != null) {
            result += current.title;
            if (current.next != null) {
                result += ", ";
            }
            current = current.next;
        }
        return result + "]";
    }
}
