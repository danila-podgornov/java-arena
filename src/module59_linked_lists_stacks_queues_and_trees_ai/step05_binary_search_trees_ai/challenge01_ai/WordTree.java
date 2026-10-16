// AI-Generated
package module59_linked_lists_stacks_queues_and_trees_ai.step05_binary_search_trees_ai.challenge01_ai;

public class WordTree {
    private WordNode root;

    public void add(String word) {

    }

    public void printShape() {
        printShape(this.root, "", "");
    }

    private void printShape(WordNode node, String indent, String label) {
        if (node == null) {
            return;
        }
        System.out.println(indent + label + node.word);
        printShape(node.left, indent + "  ", "L: ");
        printShape(node.right, indent + "  ", "R: ");
    }
}
