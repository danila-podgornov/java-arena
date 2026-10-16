// AI-Generated
package module59_linked_lists_stacks_queues_and_trees_ai.step05_binary_search_trees_ai.challenge01_ai;

public class Main {
    /**
     * A glossary keeps its words in a binary search tree. In {@code WordTree.java}, write {@code add(String word)}, which adds a word with the search tree rule, comparing with {@code compareTo}. A word that's already in the tree is ignored. You can write it recursively, like NumberTree, or with a loop. The class already has {@code printShape()}, which prints the tree with each child under its parent, indented and marked {@code L:} or {@code R:}. The check runs:
     * <pre>{@code
     * WordTree glossary = new WordTree();
     * glossary.add("loop");
     * glossary.add("array");
     * glossary.add("method");
     * glossary.add("class");
     * glossary.add("variable");
     * glossary.add("array");
     * glossary.printShape();
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * loop
     *   L: array
     *     R: class
     *   R: method
     *     R: variable
     * }</pre>
     * Hints
     * 1. Follow NumberTree: {@code add(String word)} sets {@code this.root = add(this.root, word);}, and a private helper {@code add(WordNode node, String word)} returns {@code new WordNode(word)} when {@code node} is {@code null}.
     * 2. Otherwise compare: {@code int comparison = word.compareTo(node.word);}. Below 0, {@code node.left = add(node.left, word);}; above 0, the same on the right; at 0, nothing. Return {@code node}.
     */
    public static void main(String[] args) {
        WordTree glossary = new WordTree();
        glossary.add("loop");
        glossary.add("array");
        glossary.add("method");
        glossary.add("class");
        glossary.add("variable");
        glossary.add("array");
        glossary.printShape();
    }
}
