// AI-Generated
package module59_linked_lists_stacks_queues_and_trees_ai.step05_binary_search_trees_ai.challenge03_ai;

public class Main {
    /**
     * Give {@code WordTree} the method {@code printInOrder()}, which prints every word of the tree in alphabetical order, one per line, with an in-order walk: the left subtree, the node, the right subtree. Don't sort anything: the tree's order is enough. An empty tree prints nothing. The check runs:
     * <pre>{@code
     * WordTree glossary = new WordTree();
     * String[] words = {"loop", "array", "method", "class", "variable", "string"};
     * for (String word : words) {
     *     glossary.add(word);
     * }
     * glossary.printInOrder();
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * array
     * class
     * loop
     * method
     * string
     * variable
     * }</pre>
     * Hints
     * 1. Write a private helper {@code printInOrder(WordNode node)}, and have the public method call it with {@code this.root}. The helper's base case is an empty subtree: {@code if (node == null) { return; }}.
     * 2. Otherwise it prints the left subtree with a recursive call, then {@code node.word}, then the right subtree.
     */
    public static void main(String[] args) {
        WordTree glossary = new WordTree();
        String[] words = {"loop", "array", "method", "class", "variable", "string"};
        for (String word : words) {
            glossary.add(word);
        }
        glossary.printInOrder();
    }
}
