> [!info] AI-Generated

# Comparable: a natural order for your class

Module 28 sorted lists of numbers and Strings with `Collections.sort`, and said that a list of your own objects can't be sorted that way yet. Java knows that 3 comes before 7 and that "Ada" comes before "Ben". But a conference talk: does it go by its title, its start time or its room? Java can't guess. This module shows how to tell it.

## Java doesn't know the order

A conference app keeps the day's talks. Each talk has a title and the hour it starts. Sorting them doesn't compile:

**Main.java**

```java
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Talk> talks = new ArrayList<>();
        talks.add(new Talk("Testing with JUnit", 14));
        talks.add(new Talk("Opening keynote", 9));
        Collections.sort(talks);
        System.out.println(talks);
    }
}
```

**Talk.java**

```java
public class Talk {
    private String title;
    private int hour;

    public Talk(String title, int hour) {
        this.title = title;
        this.hour = hour;
    }

    @Override
    public String toString() {
        return this.hour + ":00 " + this.title;
    }
}
```

**What javac prints**

```text
Main.java:9: error: no suitable method found for sort(ArrayList<Talk>)
        Collections.sort(talks);
                   ^
    method Collections.<T#1>sort(List<T#1>) is not applicable
      (inference variable T#1 has incompatible bounds
        equality constraints: Talk
        upper bounds: Comparable<? super T#1>)
    method Collections.<T#2>sort(List<T#2>,Comparator<? super T#2>) is not applicable
      (cannot infer type-variable(s) T#2
        (actual and formal argument lists differ in length))
  where T#1,T#2 are type-variables:
    T#1 extends Comparable<? super T#1> declared in method <T#1>sort(List<T#1>)
    T#2 extends Object declared in method <T#2>sort(List<T#2>,Comparator<? super T#2>)
1 error
```

The message is long, but its key word is `Comparable`: `Collections.sort` sorts only elements that are **Comparable**, and a Talk isn't. (The other method it mentions, the one with a `Comparator`, is step 2's.) A stream's `sorted()` from module 37 has the same need. It compiles, but as soon as the stream has two talks to compare, the program stops with a `ClassCastException`.

## Comparable and compareTo

`Comparable` is one of Java's own interfaces (module 35). It lists one method, and in short it looks like this:

```java
public interface Comparable<T> {
    int compareTo(T other);
}
```

`T` stands for a type, given in angle brackets as in `ArrayList<Talk>`. A class that implements `Comparable<Talk>` promises the method `compareTo(Talk other)`. It compares the object it's called on, `this`, with `other`, and answers with an int:

- a **negative** number: `this` comes before `other`
- **zero**: they have the same place in the order
- a **positive** number: `this` comes after `other`

The order that `compareTo` gives is called the class's **natural order**. Talks, in the order they start:

**Main.java**

```java
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Talk> talks = new ArrayList<>();
        talks.add(new Talk("Clean code in practice", 11));
        talks.add(new Talk("Opening keynote", 9));
        talks.add(new Talk("Testing with JUnit", 14));
        talks.add(new Talk("Accessible web forms", 11));
        talks.add(new Talk("Streams in depth", 10));
        Collections.sort(talks);
        for (Talk talk : talks) {
            System.out.println(talk);
        }
    }
}
```

**Talk.java**

```java
public class Talk implements Comparable<Talk> {
    private String title;
    private int hour;

    public Talk(String title, int hour) {
        this.title = title;
        this.hour = hour;
    }

    public String getTitle() {
        return this.title;
    }

    public int getHour() {
        return this.hour;
    }

    @Override
    public int compareTo(Talk other) {
        if (this.hour < other.hour) {
            return -1;
        }
        if (this.hour > other.hour) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.hour + ":00 " + this.title;
    }
}
```

**Output**

```text
9:00 Opening keynote
10:00 Streams in depth
11:00 Clean code in practice
11:00 Accessible web forms
14:00 Testing with JUnit
```

- `implements Comparable<Talk>` says that a Talk can be compared with another Talk. `@Override` goes above `compareTo`, as above any method an interface asks for.
- `compareTo` can read `other.hour`, a private variable of another Talk, because the code is inside the class Talk. Module 32's `equals` did the same.
- You don't call `compareTo` yourself here. `Collections.sort` calls it on pairs of talks, as many times as it needs, and moves the talks into order.
- The two talks at 11 are a tie: `compareTo` says 0. Java's sort never swaps elements that tie, so they keep the order they had in the list. Clean code was added first, so it stays first.

## Only the sign matters

A sort only looks at whether the answer is negative, zero or positive, so any negative number means "before", not just -1. Java has a method that compares two ints that way, `Integer.compare(a, b)`:

```java
System.out.println(Integer.compare(9, 14));
System.out.println(Integer.compare(14, 14));
System.out.println(Integer.compare(14, 9));
```

**Output**

```text
-1
0
1
```

With it, the talks' `compareTo` is one line:

```java
@Override
public int compareTo(Talk other) {
    return Integer.compare(this.hour, other.hour);
}
```

Swap the two values, `Integer.compare(other.hour, this.hour)`, and the order turns around: the latest talk comes first.

For `double` values, `Double.compare(a, b)` works the same way.

You'll also see `return this.hour - other.hour;` in other people's code. For small numbers such as hours, the difference has the right sign. But a subtraction can overflow (module 4): when the numbers are far apart, the result wraps around, and the sign comes out wrong:

```java
int big = 2000000000;
int small = -2000000000;
System.out.println(big - small);
System.out.println(Integer.compare(big, small));
```

**Output**

```text
-294967296
1
```

`big` is the larger number, so the answer should be positive, but the subtraction says negative. `Integer.compare` is always right, so this course uses it.

## Strings have a compareTo already

String implements `Comparable<String>`, and its `compareTo` gives alphabetical order. That's what `Collections.sort` used for Strings in module 28:

```java
System.out.println("Ada".compareTo("Ben") < 0);
System.out.println("Ben".compareTo("Ada") < 0);
System.out.println("Ada".compareTo("Ada"));
System.out.println("Zoe".compareTo("adam") < 0);
```

**Output**

```text
true
false
0
true
```

The last line is a surprise: "Zoe" comes before "adam". Strings are compared letter by letter, by the letters' codes, and every capital from A to Z comes before every small letter from a to z. Names made of a capital from A to Z followed by small letters from a to z, like Ada and Ben, sort as you'd expect.

A class ordered by a String, such as talks by their titles, hands the job to the String's `compareTo`:

```java
@Override
public int compareTo(Talk other) {
    return this.title.compareTo(other.title);
}
```

## sorted() in a stream

Module 37 promised this: once a class is Comparable, a stream's `sorted()` works for its objects too. It uses the same `compareTo`, and it leaves the list as it was:

**Main.java**

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Talk> talks = new ArrayList<>();
        talks.add(new Talk("Clean code in practice", 11));
        talks.add(new Talk("Opening keynote", 9));
        talks.add(new Talk("Streams in depth", 10));
        talks.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("First in the list: " + talks.get(0));
    }
}
```

**Talk.java**

```java
public class Talk implements Comparable<Talk> {
    private String title;
    private int hour;

    public Talk(String title, int hour) {
        this.title = title;
        this.hour = hour;
    }

    @Override
    public int compareTo(Talk other) {
        return Integer.compare(this.hour, other.hour);
    }

    @Override
    public String toString() {
        return this.hour + ":00 " + this.title;
    }
}
```

**Output**

```text
9:00 Opening keynote
10:00 Streams in depth
11:00 Clean code in practice
First in the list: 11:00 Clean code in practice
```

---

Source: [Comparable: a natural order for your class](https://javaarena.com/learn/sorting-objects/comparable/) in the module [Ordering objects: Comparable and Comparator](https://javaarena.com/learn/sorting-objects/) on Java Arena.

This module follows section [10.2 The Comparable Interface](https://java-programming.mooc.fi/part-10/2-interface-comparable) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
