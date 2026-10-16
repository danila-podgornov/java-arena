> [!info] AI-Generated

# Generic interfaces

An interface can have a type parameter too. You've used one since module 38:

```java
public interface Comparable<T> {
    int compareTo(T other);
}
```

A Talk class implemented it as `Comparable<Talk>`, so its `compareTo` took a Talk. Java's `List<E>`, `Map<K, V>` and `Iterator<E>` from modules 35 and 39 are generic interfaces as well.

## A generic interface of your own

A comic convention's ticket form checks what people type. The name to print on the entry pass must be long enough, the T-shirt size must be S, M or L, and the number of tickets must be 1, 2 or 4. Every check takes a value and answers yes or no; only the type of the value differs. One interface describes them all:

```java
public interface Rule<T> {
    boolean allows(T value);
}
```

A class can implement a generic interface in two ways: for one type that it chooses, or for any type, by keeping the type parameter.

## Implemented for one type

```java
public class MinLength implements Rule<String> {
    private int min;

    public MinLength(int min) {
        this.min = min;
    }

    @Override
    public boolean allows(String value) {
        return value.length() >= this.min;
    }
}
```

`implements Rule<String>` chooses String for T, exactly like `implements Comparable<Talk>`. So MinLength's `allows` takes a String, and it can call `length()` on it. MinLength has no type parameter of its own: it's a Rule for Strings only.

## Kept generic

```java
import java.util.ArrayList;

public class OneOf<T> implements Rule<T> {
    private ArrayList<T> allowed;

    public OneOf() {
        this.allowed = new ArrayList<>();
    }

    public void add(T value) {
        this.allowed.add(value);
    }

    @Override
    public boolean allows(T value) {
        return this.allowed.contains(value);
    }
}
```

`OneOf<T> implements Rule<T>` has a type parameter of its own, and it hands it on to the interface. A `OneOf<String>` is a `Rule<String>`, and a `OneOf<Integer>` is a `Rule<Integer>`. OneOf works for any type because all it does with a value is `contains`, which compares with `equals`, and every object has an `equals`.

## Using them

A `Rule<String>` can be a variable's type or a parameter's type, like any interface (module 35), and it accepts any class that is a Rule for Strings:

**Main.java**

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Rule<String> passName = new MinLength(4);
        OneOf<String> sizes = new OneOf<>();
        sizes.add("S");
        sizes.add("M");
        sizes.add("L");
        OneOf<Integer> tickets = new OneOf<>();
        tickets.add(1);
        tickets.add(2);
        tickets.add(4);

        System.out.println(passName.allows("Ari") + " " + passName.allows("Arianna"));
        System.out.println(tickets.allows(3) + " " + tickets.allows(4));

        ArrayList<String> typed = new ArrayList<>();
        typed.add("M");
        typed.add("XL");
        typed.add("m");
        typed.add("L");
        System.out.println(countAllowed(sizes, typed) + " of " + typed.size() + " are sizes");
        System.out.println(countAllowed(passName, typed) + " of " + typed.size() + " are long enough for a pass");
    }

    public static int countAllowed(Rule<String> rule, ArrayList<String> values) {
        int count = 0;
        for (String value : values) {
            if (rule.allows(value)) {
                count++;
            }
        }
        return count;
    }
}
```

**Rule.java**

```java
public interface Rule<T> {
    boolean allows(T value);
}
```

**MinLength.java**

```java
public class MinLength implements Rule<String> {
    private int min;

    public MinLength(int min) {
        this.min = min;
    }

    @Override
    public boolean allows(String value) {
        return value.length() >= this.min;
    }
}
```

**OneOf.java**

```java
import java.util.ArrayList;

public class OneOf<T> implements Rule<T> {
    private ArrayList<T> allowed;

    public OneOf() {
        this.allowed = new ArrayList<>();
    }

    public void add(T value) {
        this.allowed.add(value);
    }

    @Override
    public boolean allows(T value) {
        return this.allowed.contains(value);
    }
}
```

**Output**

```text
false true
false true
2 of 4 are sizes
0 of 4 are long enough for a pass
```

- `countAllowed` takes any `Rule<String>`: a OneOf of Strings and a MinLength both fit. Each object runs its own `allows`.
- `tickets`, a `Rule<Integer>`, doesn't fit: `countAllowed(tickets, typed)` doesn't compile, because a rule for numbers can't check text. Step 5 shows more of what the compiler checks.
- `"m"` isn't a size: `contains` uses String's `equals`, which tells small letters from capitals.

---

Source: [Generic interfaces](https://javaarena.com/learn/generics/generic-interfaces/) in the module [Type parameters (generics)](https://javaarena.com/learn/generics/) on Java Arena.

This module follows section [12.1 Type parameters](https://java-programming.mooc.fi/part-12/1-type-parameters) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
