// AI-Generated
package module59_linked_lists_stacks_queues_and_trees_ai.step02_a_linked_list_class_ai.challenge02_ai;

public class ReadingList {
    private TitleNode head;
    private int size;

    public ReadingList() {
        this.head = null;
        this.size = 0;
    }

    public void addFirst(String title) {
        this.head = new TitleNode(title, this.head);
        this.size++;
    }

    public void addLast(String title) {

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
