> [!info] AI-Generated

# Length and loops

An array knows its own size: `hours.length`.

```java
int[] hours = new int[7];
System.out.println("The week has " + hours.length + " days");
```

**Output**

```text
The week has 7 days
```

`length` has no parentheses. It isn't a method but a **field**: a value stored with the array. That's easy to mix up, because each kind of collection says it differently:

| Kind | Its size |
|---|---|
| a list | `list.size()` |
| a String | `text.length()` |
| an array | `hours.length` |

With parentheses, javac looks for a method called `length` and doesn't find one:

```java
public class Main {
    public static void main(String[] args) {
        int[] hours = new int[7];
        System.out.println(hours.length());
    }
}
```

**What javac prints**

```text
Main.java:4: error: cannot find symbol
        System.out.println(hours.length());
                                ^
  symbol:   method length()
  location: variable hours of type int[]
1 error
```

## Looping over the indexes

The indexes go from 0 to `length - 1`, so the same for loop you used with lists goes through all of them. Here one loop fills the array and a second one prints it:

```java
int[] squares = new int[5];
for (int i = 0; i < squares.length; i++) {
    squares[i] = i * i;
}
for (int i = 0; i < squares.length; i++) {
    System.out.println(i + " squared is " + squares[i]);
}
```

**Output**

```text
0 squared is 0
1 squared is 1
2 squared is 4
3 squared is 9
4 squared is 16
```

Because both loops use `squares.length` instead of the number 5, changing `new int[5]` is all it takes to make the program work with a bigger array.

## for-each

When you need the values but not the indexes, a for-each loop works on an array just as it does on a list:

```java
int[] squares = new int[5];
for (int i = 0; i < squares.length; i++) {
    squares[i] = i * i;
}
int sum = 0;
for (int square : squares) {
    sum += square;
}
System.out.println("Sum: " + sum);
```

**Output**

```text
Sum: 30
```

The loop variable `square` gets a copy of each element in turn. Assigning to it doesn't change the array, so filling or changing an array takes the loop over the indexes.

## One past the end

An index that isn't in the array crashes the program, as it does with a list. The usual cause is `<=` where `<` belongs:

```java
public class Main {
    public static void main(String[] args) {
        int[] squares = new int[3];
        for (int i = 0; i <= squares.length; i++) {
            squares[i] = i * i;
            System.out.println(squares[i]);
        }
    }
}
```

**Output**

```text
0
1
4
```

**The program crashes with**

```text
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
	at Main.main(Main.java:5)
```

The message names the index that failed and the array's length. An array of length 3 has the indexes 0, 1 and 2, so index 3 doesn't exist. The loop that visits every index is `for (int i = 0; i < array.length; i++)`.

---

Source: [Length and loops](https://javaarena.com/learn/arrays/length-and-loops/) in the module [Arrays](https://javaarena.com/learn/arrays/) on Java Arena.

This module follows section [3.3 Arrays](https://java-programming.mooc.fi/part-3/3-arrays) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
