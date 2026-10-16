> [!info] AI-Generated

# Arrays of other types

The elements can be of any type. The array's type is the element type followed by `[]`: `double[]`, `String[]`, `boolean[]`. Two arrays of the same length can work as a pair, where the same index in each describes the same thing:

```java
String[] dishes = new String[3];
double[] prices = new double[3];
dishes[0] = "Soup";
prices[0] = 4.5;
dishes[1] = "Pasta";
prices[1] = 9.0;
dishes[2] = "Pie";
prices[2] = 3.75;
for (int i = 0; i < dishes.length; i++) {
    System.out.println(dishes[i] + ": " + prices[i]);
}
```

**Output**

```text
Soup: 4.5
Pasta: 9.0
Pie: 3.75
```

All the elements of one array have the same type, and a value of another type doesn't fit:

```java
public class Main {
    public static void main(String[] args) {
        int[] ages = new int[2];
        ages[0] = "twelve";
    }
}
```

**What javac prints**

```text
Main.java:4: error: incompatible types: String cannot be converted to int
        ages[0] = "twelve";
                  ^
1 error
```

One difference from lists: an array of whole numbers is written with the basic type, `int[]`. A list needs `ArrayList<Integer>`, but an array has no such rule.

## Reading values into an array

When the program is told how many values are coming, it can make an array of exactly that size. Here the first line of input says how many names follow:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.valueOf(scanner.nextLine());
        String[] guests = new String[count];
        for (int i = 0; i < guests.length; i++) {
            guests[i] = scanner.nextLine();
        }
        System.out.println("Guest list:");
        for (int i = 0; i < guests.length; i++) {
            System.out.println((i + 1) + ". " + guests[i]);
        }
    }
}
```

**Input**

```text
3
Amira
Bruno
Chen
```

**Output**

```text
Guest list:
1. Amira
2. Bruno
3. Chen
```

The size comes from the input, but once the array exists, it can't grow. When a program can't know the count before it starts reading (for example, when it reads until an empty line), a list is the better choice.

## Swapping two elements

To swap two elements, keep one of them aside first. Otherwise its value is gone before it's copied:

```java
String[] podium = new String[3];
podium[0] = "Kim";
podium[1] = "Lea";
podium[2] = "Max";
String kept = podium[0];
podium[0] = podium[1];
podium[1] = kept;
for (String name : podium) {
    System.out.println(name);
}
```

**Output**

```text
Lea
Kim
Max
```

Without `kept`, the line `podium[0] = podium[1];` would write over Kim, and both places would end up holding Lea.

---

Source: [Arrays of other types](https://javaarena.com/learn/arrays/other-element-types/) in the module [Arrays](https://javaarena.com/learn/arrays/) on Java Arena.

This module follows section [3.3 Arrays](https://java-programming.mooc.fi/part-3/3-arrays) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
