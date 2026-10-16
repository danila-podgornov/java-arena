> [!info] AI-Generated

# Recursion on strings and arrays

A string is its first character followed by a shorter string, and that view makes many string problems recursive. `text.charAt(0)` is the first character, and `text.substring(1)` (module 16) is the rest, one character shorter. The base case is usually the empty string, which has no first character.

## Counting a character

A typesetter wants to know how many times a letter appears in a headline:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(count("banana bread", 'a'));
        System.out.println(count("", 'a'));
    }

    public static int count(String text, char letter) {
        if (text.isEmpty()) {
            return 0;
        }
        int rest = count(text.substring(1), letter);
        if (text.charAt(0) == letter) {
            return rest + 1;
        }
        return rest;
    }
}
```

**Output**

```text
4
0
```

Each call looks at one character and leaves the rest to the recursive call. The empty string has no `a` in it. Every call makes the string one character shorter, so the calls reach the empty string.

## Arrays: pass an index

For arrays, the usual way is to pass an index instead of copying the rest (a copy on every call would take time and memory): the method gets the array and an index, the place where "the rest" starts, and the recursive call moves the index one place along. The base case is an index at the end of the array, where the rest is empty:

```java
public class Main {
    public static void main(String[] args) {
        int[] temperatures = {4, -2, 7, -5, 0};
        System.out.println(countBelowZero(temperatures, 0));
        System.out.println(countBelowZero(temperatures, 3));
    }

    public static int countBelowZero(int[] values, int start) {
        if (start == values.length) {
            return 0;
        }
        int rest = countBelowZero(values, start + 1);
        if (values[start] < 0) {
            return rest + 1;
        }
        return rest;
    }
}
```

**Output**

```text
2
1
```

`countBelowZero(temperatures, 0)` counts the whole array; `countBelowZero(temperatures, 3)` counts only from index 3 on.

## Building a string

A recursive method can also return a string it builds from the smaller call's string. This one spaces out a word's letters for a sign:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(spaced("OPEN"));
    }

    public static String spaced(String word) {
        if (word.length() <= 1) {
            return word;
        }
        return word.charAt(0) + " " + spaced(word.substring(1));
    }
}
```

**Output**

```text
O P E N
```

Here the base case is a word of at most one letter, which needs no spaces; the empty string is covered by it too.

---

Source: [Recursion on strings and arrays](https://javaarena.com/learn/recursion/strings-and-arrays/) in the module [Recursion](https://javaarena.com/learn/recursion/) on Java Arena.

An extra module, not part of the University of Helsinki's course. Lesson text: [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
