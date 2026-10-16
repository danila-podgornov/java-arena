> [!info] AI-Generated

# The short way to create an array

## Creating an array with its values

When you know the values as you write the program, list them in braces:

```java
int[] values = {3, 1, 4};
String[] days = {"Mon", "Tue", "Wed"};
System.out.println(values.length);
System.out.println(days[2]);
```

**Output**

```text
3
Wed
```

Java counts the values and makes an array of that size, so `{3, 1, 4}` does the same as `new int[3]` followed by three assignments. The braces alone work only in the line that declares the variable. Anywhere else, such as in a method call, write `new int[]` in front of them: `total(new int[] {3, 1, 4})`.

## Printing an array

Printing the array variable itself doesn't print the values:

```java
int[] values = {3, 1, 4};
System.out.println(values);
```

This prints `[I@` followed by a code of letters and digits, which can change from one run to the next. `[I` stands for "array of int", and the code says nothing about the values. To see them, you can print the elements with a loop, as in the earlier steps. Or let Java do it: `Arrays.toString` gives the values as text, in square brackets. It lives in the class `java.util.Arrays`, which needs an import line, as `Scanner` does:

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] values = {3, 1, 4};
        String[] days = {"Mon", "Tue", "Wed"};
        System.out.println(Arrays.toString(values));
        System.out.println(Arrays.toString(days));
    }
}
```

**Output**

```text
[3, 1, 4]
[Mon, Tue, Wed]
```

It's a handy tool for checking what an array holds while you work on a program.

## Array or list?

| | Array | ArrayList |
|---|---|---|
| Size | fixed when it's created | grows and shrinks |
| Size in code | `values.length` | `list.size()` |
| Reading an element | `values[i]` | `list.get(i)` |
| Whole numbers | `int[]` | `ArrayList<Integer>` |
| Ready-made tools | in the `Arrays` class, such as `Arrays.toString` | the list's own methods: `add`, `remove`, `contains`, `indexOf` |

A list is the everyday choice when the number of values changes or isn't known in advance: reading until the user stops, or a to-do list that items come and go from. An array fits when the size is fixed and known, like the seven days of a week. It's especially good for **counting**, when the value itself can be the index.

## Counting with an array

Each line of input here is a vote for option 1, 2 or 3, until a 0. The line `votes[option]++;` adds one to that option's counter. The array has four places so that options 1 to 3 can use their own number as the index; index 0 is simply never used.

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] votes = new int[4];
        while (true) {
            int option = Integer.valueOf(scanner.nextLine());
            if (option == 0) {
                break;
            }
            votes[option]++;
        }
        for (int option = 1; option < votes.length; option++) {
            System.out.println("Option " + option + ": " + votes[option]);
        }
    }
}
```

**Input**

```text
2
3
2
1
2
0
```

**Output**

```text
Option 1: 1
Option 2: 3
Option 3: 1
```

Without an array, this would take a separate counter and an `if` for each option. With one, counting 30 options instead of 3 changes only the size of the array.

---

Source: [The short way to create an array](https://javaarena.com/learn/arrays/the-short-way/) in the module [Arrays](https://javaarena.com/learn/arrays/) on Java Arena.

This module follows section [3.3 Arrays](https://java-programming.mooc.fi/part-3/3-arrays) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
