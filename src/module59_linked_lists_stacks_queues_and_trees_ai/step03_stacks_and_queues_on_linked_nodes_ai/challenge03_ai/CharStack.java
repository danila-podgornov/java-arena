// AI-Generated
package module59_linked_lists_stacks_queues_and_trees_ai.step03_stacks_and_queues_on_linked_nodes_ai.challenge03_ai;

public class CharStack {
    private CharNode top;

    public void push(char value) {
        this.top = new CharNode(value, this.top);
    }

    public char pop() {
        char value = peek();
        this.top = this.top.next;
        return value;
    }

    public char peek() {
        if (this.top == null) {
            throw new IllegalStateException("The stack is empty");
        }
        return this.top.value;
    }

    public boolean isEmpty() {
        return this.top == null;
    }
}
