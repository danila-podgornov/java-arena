> [!info] AI-Generated

# Putting it together: what the compiler checks

This step builds one more generic class with tools from earlier modules, and then looks at the biggest gain from type parameters: the compiler checks the types for you, so many mistakes can't even run.

## A history of the last few items

A web shop shows the products you viewed most recently, and a vet's app keeps a dog's last few weights, in kilograms. Both keep the newest few items of some type and forget older ones:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        History<String> viewed = new History<>(3);
        viewed.add("lamp");
        viewed.add("rug");
        viewed.add("kettle");
        viewed.add("mirror");
        System.out.println(viewed);
        System.out.println("Latest: " + viewed.latest());

        History<Double> weights = new History<>(2);
        weights.add(18.5);
        weights.add(21.0);
        weights.add(19.5);
        System.out.println(weights);

        try {
            History<Integer> none = new History<>(0);
            System.out.println(none);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

**History.java**

```java
import java.util.ArrayList;

public class History<T> {
    private ArrayList<T> items;
    private int limit;

    public History(int limit) {
        if (limit < 1) {
            throw new IllegalArgumentException("A history must keep at least 1 item, not " + limit);
        }
        this.items = new ArrayList<>();
        this.limit = limit;
    }

    public void add(T item) {
        this.items.add(item);
        if (this.items.size() > this.limit) {
            this.items.remove(0);
        }
    }

    public T latest() {
        if (this.items.isEmpty()) {
            throw new IllegalStateException("The history is empty");
        }
        return this.items.get(this.items.size() - 1);
    }

    @Override
    public String toString() {
        return this.items.toString();
    }
}
```

**Output**

```text
[rug, kettle, mirror]
Latest: mirror
[21.0, 19.5]
A history must keep at least 1 item, not 0
```

- Everything in History comes from earlier modules: an ArrayList, removing its first element, `toString`, and the exceptions of module 42. The only new part is T.
- `add` puts the new item at the end, and when the list has grown past the limit, it removes the oldest, at index 0. `remove(0)` removes by index even in a `History<Integer>`, because 0 is an int.
- The constructor refuses a limit below 1, and `latest()` on an empty history throws an IllegalStateException. A generic class checks its values like any other.
- `toString` hands the job to the list's own `toString`, which calls `toString` on each item.

## The compiler checks the types

A `History<Double>`'s `add` takes only Doubles, and a `Box<Integer>` from step 1 holds only Integers. Try to put a String in one, or take a String out of one, and the program doesn't compile:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Box<Integer> coins = new Box<>(340);
        coins.setContent("a lot");
        String count = coins.getContent();
        System.out.println(count);
    }
}
```

**Box.java**

```java
public class Box<T> {
    private T content;

    public Box(T content) {
        this.content = content;
    }

    public T getContent() {
        return this.content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
```

**What javac prints**

```text
Main.java:4: error: incompatible types: String cannot be converted to Integer
        coins.setContent("a lot");
                         ^
Main.java:5: error: incompatible types: Integer cannot be converted to String
        String count = coins.getContent();
                                       ^
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
2 errors
```

With step 1's ObjectBox, javac would accept the first line, and the second too once it had a cast, `(String) coins.getContent()`. Neither mistake would be caught before the program ran. The cast fails with a ClassCastException when the box still holds 340, and a String put into a box of coins goes unnoticed until some code takes it out as an Integer, maybe much later and in a different place. With a type parameter, javac finds both before the program ever runs, and points at the very lines. That's the main reason type parameters exist.

The checks go everywhere the types go: a `Rule<Integer>` can't be passed to a method that wants a `Rule<String>`, and a `Duo<String, Integer>`'s `swapped()` can't be stored in a `Duo<String, Integer>` variable.

## Inside the class, T could be anything

The checks work in the other direction too. Inside Box, nobody knows yet what T will be, so this doesn't compile:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Box<String> pegs = new Box<>("tent pegs");
        System.out.println(pegs.letters());
    }
}
```

**Box.java**

```java
public class Box<T> {
    private T content;

    public Box(T content) {
        this.content = content;
    }

    public int letters() {
        return this.content.length();
    }
}
```

**What javac prints**

```text
Box.java:9: error: cannot find symbol
        return this.content.length();
                           ^
  symbol:   method length()
  location: variable content of type T
  where T is a type-variable:
    T extends Object declared in class Box
1 error
```

This box happens to hold a String, but another Box could hold an Integer, which has no `length()`. The last lines of the message say what javac knows about T: `T extends Object`, some type of object or other. So inside a generic class, a value of type T can do only what every object can: the methods of Object, such as `toString()` and `equals`. That's why History, Rotation and OneOf work for any type: they store values, hand them back, print them and compare them with `equals`, and that's all. (Java can also promise more about T, as in `<T extends Comparable<T>>`, a type parameter that must be Comparable. That's called a **bounded type parameter**. You saw one in module 38's long error message; this course doesn't need them.)

---

Source: [Putting it together: what the compiler checks](https://javaarena.com/learn/generics/putting-it-together/) in the module [Type parameters (generics)](https://javaarena.com/learn/generics/) on Java Arena.

This module follows section [12.1 Type parameters](https://java-programming.mooc.fi/part-12/1-type-parameters) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
