> [!info] AI-Generated

# Why type parameters

Since module 13 you've written types like `ArrayList<String>` and `ArrayList<Integer>`, and since module 31 `HashMap<String, Integer>`. ArrayList is one class, written once by Java's developers. Yet each list knows the type of its values: `get` on an `ArrayList<String>` gives a String, `get` on an `ArrayList<Integer>` gives an Integer, and adding a number to a list of Strings doesn't compile. The type in the angle brackets makes that work. This module shows how to write classes like that yourself.

## A box for one type

A storeroom keeps things in boxes, one thing per box. Here's a class for a box that holds a String:

```java
public class StringBox {
    private String content;

    public StringBox(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }
}
```

A box for a number would be the same class again, with `Integer` in place of `String` in three places. A box for a Book, once more. The code would be the same each time, and only the type would change.

## Why not Object?

Every class inherits from Object (module 34), so a box whose content is an Object takes anything. But then what comes out is just an Object, and Java no longer knows what kind:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        ObjectBox box = new ObjectBox("tent pegs");
        String content = box.getContent();
        System.out.println(content.toUpperCase());
    }
}
```

**ObjectBox.java**

```java
public class ObjectBox {
    private Object content;

    public ObjectBox(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return this.content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
```

**What javac prints**

```text
Main.java:4: error: incompatible types: Object cannot be converted to String
        String content = box.getContent();
                                       ^
1 error
```

You know there's a String in the box, but the compiler only knows that `getContent()` returns an Object. A cast, `(String) box.getContent()`, would make it compile (module 36). But nothing stops other code from putting a number into that box, and then the cast fails while the program runs, with a ClassCastException.

## A type parameter

The way out is to let the code that creates a box say what goes in it. The class gets a **type parameter**, written in angle brackets after its name:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Box<String> pegs = new Box<String>("tent pegs");
        System.out.println(pegs.getContent().toUpperCase());

        Box<Integer> coins = new Box<Integer>(340);
        int total = coins.getContent() + 25;
        System.out.println(total);
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

**Output**

```text
TENT PEGS
365
```

- `public class Box<T>` says that Box has a type parameter called T. T stands for a type that isn't decided yet: each box decides it when it's created.
- Inside the class, T is used like any other type: for the instance variable, `private T content;`, for the constructor's parameter, as the return type of `getContent`, and as the type of `setContent`'s parameter.
- `Box<String>` is a box whose T is String. For this box, `getContent()` returns a String, so `toUpperCase()` works without a cast. `coins` is a `Box<Integer>`, so its `getContent()` returns an Integer, which can be added to.
- The constructor's header is `public Box(T content)`. The `<T>` comes only after the class's name in the class header, never after the constructor's name.

You can picture it like this: when Java checks code that uses a `Box<String>`, it reads every T in Box as String. One class, written once, works for any type. That's how ArrayList is written too: its header begins `public class ArrayList<E>`, and its `get` returns an E.

## Naming a type parameter

A type parameter can have any name, but the custom is a single capital letter, so that it's easy to tell from a class's name: `T` for "type", `E` for "element" (Java's lists use it), and `K` and `V` for "key" and "value" (HashMap uses them).

---

Source: [Why type parameters](https://javaarena.com/learn/generics/why-type-parameters/) in the module [Type parameters (generics)](https://javaarena.com/learn/generics/) on Java Arena.

This module follows section [12.1 Type parameters](https://java-programming.mooc.fi/part-12/1-type-parameters) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
