> [!info] AI-Generated

# Binary search trees

A list's nodes have one link each. A **tree**'s nodes can have several. In a **binary tree**, each node has two links, `left` and `right`, either of which can be `null`. The top node is the **root**, and a node with no children is a **leaf**. A node's left link leads to its **left subtree**: that node and everything under it.

## The search tree rule

A **binary search tree** keeps one rule at every node: everything in its left subtree is smaller than the node's value, and everything in its right subtree is bigger. Adding 50, 30, 70, 20, 40 and 60, in that order, gives this tree:

```text
        50
       /  \
     30    70
    /  \   /
  20   40 60
```

To find 40, start at the root: 40 is smaller than 50, so go left; bigger than 30, so go right; there it is. Each comparison goes one level down and skips a whole subtree, so a search visits at most one node per level. A value that isn't in the tree is found missing the same way, when the next link to follow is `null`. Ten levels can hold up to 1,023 values, so a tree of 1,000 values with a good shape needs only 10 comparisons to find any of them.

The shape depends on the order the values come in. Added in sorted order, 20, 30, 40, 50 and so on, each value goes to the right of the one before, and the tree is a chain as long as a linked list. Java's TreeMap (step 6) avoids that: its tree rebalances itself as values are added (it's a kind called a red-black tree).

## Adding, recursively

A tree is made of smaller trees, so recursion (module 55) fits it well. To add a value to a subtree: if the subtree is empty (`null`), the result is a new node; otherwise add it to the left or the right subtree, whichever the rule says, and the node stays where it was:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        NumberTree tree = new NumberTree();
        int[] values = {50, 30, 70, 20, 40, 60, 40};
        for (int value : values) {
            tree.add(value);
        }
        System.out.println(tree.size() + " values");
        System.out.println("Sum " + tree.sum());
    }
}
```

**NumberTree.java**

```java
public class NumberTree {
    private NumberNode root;

    public void add(int value) {
        this.root = add(this.root, value);
    }

    private NumberNode add(NumberNode node, int value) {
        if (node == null) {
            return new NumberNode(value);
        }
        if (value < node.value) {
            node.left = add(node.left, value);
        } else if (value > node.value) {
            node.right = add(node.right, value);
        }
        return node;
    }

    public int size() {
        return size(this.root);
    }

    private int size(NumberNode node) {
        if (node == null) {
            return 0;
        }
        return size(node.left) + 1 + size(node.right);
    }

    public int sum() {
        return sum(this.root);
    }

    private int sum(NumberNode node) {
        if (node == null) {
            return 0;
        }
        return sum(node.left) + node.value + sum(node.right);
    }
}
```

**NumberNode.java**

```java
public class NumberNode {
    int value;
    NumberNode left;
    NumberNode right;

    public NumberNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
```

**Output**

```text
6 values
Sum 270
```

- Each public method calls a private helper of the same name that takes a node: the helper does the work on a subtree, and the public method starts it at the root. Code that uses the tree never sees a node.
- The recursive `add` returns the subtree's root. For an empty subtree, that's the new node, and `node.left = add(node.left, value);` links it in; for any other subtree, it's the node that was there, so the assignment changes nothing.
- The second 40 is neither smaller nor bigger than the 40 in the tree, so this tree ignores it, like a set.
- `size` and `sum` visit every node: the empty tree is the base case, and a tree is its left subtree, its root and its right subtree.
- Each call goes one level down, so the depth of the recursion is the height of the tree. Keep that in mind for a tree that's a long chain.

## Visiting in order

`sum` adds the left subtree, then the node, then the right subtree. Visiting the nodes in that order, left, node, right, is called an **in-order** walk, and in a search tree it visits the values from smallest to biggest: everything left of a node is smaller, and everything right of it bigger. Printing the values on such a walk prints them sorted.

Strings are compared with `compareTo` (module 38): `word.compareTo(node.word)` is negative when `word` comes first in alphabetical order, positive when it comes after, and 0 when they're equal.

---

Source: [Binary search trees](https://javaarena.com/learn/linked-structures/binary-search-trees/) in the module [Linked lists, stacks, queues and trees](https://javaarena.com/learn/linked-structures/) on Java Arena.

An extra module, not part of the University of Helsinki's course. Lesson text: [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
