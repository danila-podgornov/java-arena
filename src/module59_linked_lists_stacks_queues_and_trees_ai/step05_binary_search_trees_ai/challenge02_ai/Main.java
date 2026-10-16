// AI-Generated
package module59_linked_lists_stacks_queues_and_trees_ai.step05_binary_search_trees_ai.challenge02_ai;

public class Main {
    /**
     * Give {@code WordTree} the method {@code contains(String word)}, which returns {@code true} when the word is in the tree. Use the search tree rule: from the root, go left or right at each node, so that it visits at most one node on each level. A loop or recursion both work. The check runs:
     * <pre>{@code
     * WordTree glossary = new WordTree();
     * String[] words = {"loop", "array", "method", "class", "variable"};
     * for (String word : words) {
     *     glossary.add(word);
     * }
     * System.out.println(glossary.contains("class"));
     * System.out.println(glossary.contains("variable"));
     * System.out.println(glossary.contains("string"));
     * System.out.println(new WordTree().contains("loop"));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * true
     * false
     * false
     * }</pre>
     * Hints
     * 1. With a loop: a variable {@code current} starts at {@code this.root}. While it isn't {@code null}, compare the word with {@code current.word}: equal means found, smaller means {@code current = current.left;}, bigger means {@code current = current.right;}.
     * 2. Falling off the tree ({@code current} becomes {@code null}) means the word isn't there: {@code return false;} after the loop.
     */
    public static void main(String[] args) {
        WordTree glossary = new WordTree();
        String[] words = {"loop", "array", "method", "class", "variable"};
        for (String word : words) {
            glossary.add(word);
        }
        System.out.println(glossary.contains("class"));
        System.out.println(glossary.contains("variable"));
        System.out.println(glossary.contains("string"));
        System.out.println(new WordTree().contains("loop"));
    }
}
