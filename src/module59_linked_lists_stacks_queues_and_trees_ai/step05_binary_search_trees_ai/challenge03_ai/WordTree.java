// AI-Generated
package module59_linked_lists_stacks_queues_and_trees_ai.step05_binary_search_trees_ai.challenge03_ai;

public class WordTree {
    private WordNode root;

    public void add(String word) {
        this.root = add(this.root, word);
    }

    private WordNode add(WordNode node, String word) {
        if (node == null) {
            return new WordNode(word);
        }
        int comparison = word.compareTo(node.word);
        if (comparison < 0) {
            node.left = add(node.left, word);
        } else if (comparison > 0) {
            node.right = add(node.right, word);
        }
        return node;
    }

    public void printInOrder() {

    }
}
