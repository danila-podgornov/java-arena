// AI-Generated
package module59_linked_lists_stacks_queues_and_trees_ai.step02_a_linked_list_class_ai.challenge01_ai;

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

    public int size() {
        return this.size;
    }
}
