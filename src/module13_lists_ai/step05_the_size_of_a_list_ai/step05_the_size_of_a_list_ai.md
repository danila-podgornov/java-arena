> [!info] AI-Generated

# The size of a list

`size()` tells how many values a list holds right now. A new list has size 0, and every `add` makes it one bigger:

```java
ArrayList<String> guests = new ArrayList<>();
System.out.println(guests.size());
guests.add("Rosa");
guests.add("Tariq");
guests.add("Yuki");
System.out.println(guests.size());
System.out.println("Last to arrive: " + guests.get(guests.size() - 1));
```

**Output**

```text
0
3
Last to arrive: Yuki
```

Since indexes start at 0, the last index is always `size() - 1`. So `guests.get(guests.size() - 1)` is the last value, however long the list is. (On an empty list, that's `get(-1)`, which crashes: check that the size is above 0 first.)

## Reading an unknown number of values

`size()` is what makes lists so handy for input: the program reads as many values as it's given, and counts them afterwards.

```java
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> trees = new ArrayList<>();
        while (true) {
            String tree = scanner.nextLine();
            if (tree.equals("end")) {
                break;
            }
            trees.add(tree);
        }
        System.out.println("Trees seen: " + trees.size());
        if (trees.size() > 0) {
            System.out.println("First: " + trees.get(0));
            System.out.println("Last: " + trees.get(trees.size() - 1));
        }
    }
}
```

**Input**

```text
maple
oak
birch
end
```

**Output**

```text
Trees seen: 3
First: maple
Last: birch
```

## Checking an index

With `size()`, a program can check an index before it uses it. An index is valid when it's at least 0 and less than the size:

```java
if (index >= 0 && index < trees.size()) {
    System.out.println(trees.get(index));
} else {
    System.out.println("No tree at index " + index);
}
```

---

Source: [The size of a list](https://javaarena.com/learn/lists/size/) in the module [Lists](https://javaarena.com/learn/lists/) on Java Arena.

This module follows section [3.2 Lists](https://java-programming.mooc.fi/part-3/2-lists) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
