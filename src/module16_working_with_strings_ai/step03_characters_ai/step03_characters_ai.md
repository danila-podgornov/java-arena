> [!info] AI-Generated

# Characters

A string is a row of characters, and each character has an index, counted from 0, just like the elements of a list or an array. `charAt(index)` gives the character at an index:

| Index | 0 | 1 | 2 | 3 |
|---|---|---|---|---|
| `"Java"` | J | a | v | a |

```java
String word = "Java";
char first = word.charAt(0);
char last = word.charAt(word.length() - 1);
System.out.println(first);
System.out.println(last);
```

**Output**

```text
J
a
```

The last index is always `length() - 1`, one less than the length, because counting starts at 0.

## The char type

`charAt` returns a `char`: a type that holds exactly one character. A char is written in **single** quotes, `'a'`, while double quotes make a String, `"a"`. Like `int`, `char` is a primitive type, not an object, so chars are compared with `==`:

```java
String word = "banana";
int count = 0;
for (int i = 0; i < word.length(); i++) {
    char c = word.charAt(i);
    if (c == 'a') {
        count++;
    }
}
System.out.println("The letter a appears " + count + " times");
```

**Output**

```text
The letter a appears 3 times
```

This loop is the way to go through a string: the index runs from 0 as long as it's less than `length()`, and `charAt(i)` gives each character in turn. Other characters work the same way: `' '` is a space and `'!'` an exclamation mark.

A char and a String are different types, even when they hold the same letter, so comparing one with the other doesn't compile:

```java
public class Main {
    public static void main(String[] args) {
        String word = "cat";
        if (word.charAt(0) == "c") {
            System.out.println("Starts with c");
        }
    }
}
```

**What javac prints**

```text
Main.java:4: error: bad operand types for binary operator '=='
        if (word.charAt(0) == "c") {
                           ^
  first type:  char
  second type: String
1 error
```

One more surprise: a char is stored as a number, its character code, so `+` between two chars adds their codes. With a String first, `+` joins as usual:

```java
String word = "ok";
System.out.println(word.charAt(0) + word.charAt(1));
System.out.println("" + word.charAt(0) + word.charAt(1));
```

**Output**

```text
218
ok
```

## Past the end

The indexes of `"cat"` are 0, 1 and 2. Asking for index 3 crashes the program with a `StringIndexOutOfBoundsException`. The usual cause is a loop that uses `<=` where it should use `<`:

```java
public class Main {
    public static void main(String[] args) {
        String word = "cat";
        for (int i = 0; i <= word.length(); i++) {
            System.out.println(word.charAt(i));
        }
    }
}
```

**Output**

```text
c
a
t
```

**The program crashes with**

```text
Exception in thread "main" java.lang.StringIndexOutOfBoundsException: Index 3 out of bounds for length 3
	at Main.main(Main.java:5)
```

The message says which index was asked for and how long the string is, and the `at` line points to line 5, the `charAt` call. The loop condition should be `i < word.length()`.

---

Source: [Characters](https://javaarena.com/learn/strings/characters/) in the module [Working with strings](https://javaarena.com/learn/strings/) on Java Arena.

This module follows sections [3.4 Using strings](https://java-programming.mooc.fi/part-3/4-using-strings), [3.5 Summary](https://java-programming.mooc.fi/part-3/5-increasing-amounts-of-data) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
