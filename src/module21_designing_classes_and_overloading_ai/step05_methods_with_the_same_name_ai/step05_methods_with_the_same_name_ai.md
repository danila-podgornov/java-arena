> [!info] AI-Generated

# Methods with the same name

You've called one method name with all kinds of values since module 1: `System.out.println("Hi")`, `System.out.println(42)`, `System.out.println(3.5)` and `System.out.println()`. That isn't one method that takes anything: `println` is several methods with the same name, one for each type of parameter. Like constructors, methods can be **overloaded**, and the methods of your own classes can be too:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        LabelPrinter printer = new LabelPrinter();
        printer.print("Flour");
        printer.print(42);
        printer.print("Sugar", 2);
        System.out.println("Labels printed: " + printer.getPrinted());
    }
}
```

**LabelPrinter.java**

```java
public class LabelPrinter {
    private int printed;

    public LabelPrinter() {
        this.printed = 0;
    }

    public void print(String text) {
        System.out.println("[ " + text + " ]");
        this.printed = this.printed + 1;
    }

    public void print(int number) {
        this.print("No. " + number);
    }

    public void print(String text, int copies) {
        for (int i = 0; i < copies; i++) {
            this.print(text);
        }
    }

    public int getPrinted() {
        return this.printed;
    }
}
```

**Output**

```text
[ Flour ]
[ No. 42 ]
[ Sugar ]
[ Sugar ]
Labels printed: 4
```

- Three methods are called `print`. Java picks one by the values in the call: a String runs `print(String text)`, an int runs `print(int number)`, and a String and an int run `print(String text, int copies)`.
- The other two call `print(String text)` instead of printing on their own, so how a label looks, and the counting, are written once. It's the same idea as `this(...)` in the last step, as an ordinary method call.
- Overloading suits methods that do the same thing with different kinds of values. Methods that do different things should get different names.

## Which one Java picks

Java compares the values in the call with each method's parameters: how many there are, and their types, in order. What decides is the type of each value, not what it looks like when printed. Static methods can be overloaded too, so here's the idea in `Main` alone:

```java
public class Main {
    public static void main(String[] args) {
        show(5);
        show(5.0);
        show("5");
        show(2 + 3);
        show(5 / 2.0);
    }

    public static void show(int value) {
        System.out.println("int: " + value);
    }

    public static void show(double value) {
        System.out.println("double: " + value);
    }

    public static void show(String value) {
        System.out.println("String: " + value);
    }
}
```

**Output**

```text
int: 5
double: 5.0
String: 5
int: 5
double: 2.5
```

- `5.0` is a double and `"5"` is a String, so each goes to its own method.
- `2 + 3` is an int, and `5 / 2.0` a double, so the type of the result decides.
- An int also fits a `double` parameter, just as `double distance = 5;` works (module 3). Without `show(int value)`, `show(5)` would run `show(double value)` and print `double: 5.0`. With both there, Java takes the one that fits exactly.

## The return type doesn't count

Methods, like constructors, differ only by their parameter types. Parameter names don't count, and neither does the return type. Say you want a method that returns a label's text instead of printing it, and you call it `print` too:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        LabelPrinter printer = new LabelPrinter();
        printer.print("Salt");
    }
}
```

**LabelPrinter.java**

```java
public class LabelPrinter {
    public void print(String text) {
        System.out.println("[ " + text + " ]");
    }

    public String print(String label) {
        return "[ " + label + " ]";
    }
}
```

**What javac prints**

```text
LabelPrinter.java:6: error: method print(String) is already defined in class LabelPrinter
    public String print(String label) {
                  ^
1 error
```

A call such as `printer.print("Salt");` doesn't have to use the value a method returns, so nothing in it could tell the two apart. A method that does something different gets a name of its own, such as `labelFor(String text)`.

---

Source: [Methods with the same name](https://javaarena.com/learn/class-design/overloaded-methods/) in the module [Designing classes and overloading](https://javaarena.com/learn/class-design/) on Java Arena.

This module follows sections [5.1 Learning object-oriented programming](https://java-programming.mooc.fi/part-5/1-learning-object-oriented-programming), [5.2 Removing repetitive code (overloading methods and constructors)](https://java-programming.mooc.fi/part-5/2-method-and-constructor-overloading) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
