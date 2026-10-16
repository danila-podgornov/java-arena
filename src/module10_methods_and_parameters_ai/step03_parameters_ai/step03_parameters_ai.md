> [!info] AI-Generated

# Parameters

A method can take **parameters**: values it gets from the call. They're declared in the parentheses, each with a type and a name, and inside the method they work like variables:

```java
public class Main {
    public static void main(String[] args) {
        greet("Ada");
        greet("Linus");
        String name = "Grace";
        greet(name);
    }

    public static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }
}
```

**Output**

```text
Hello, Ada!
Hello, Linus!
Hello, Grace!
```

- `String name` in `greet(String name)` is the parameter. Each call gives it a value: `greet("Ada")` runs the method with `name` holding `"Ada"`.
- The value in the call is the **argument**. It can be a literal, a variable or a calculation, such as `greet(first + " " + last)`.
- The argument must fit the parameter's type: `greet(42)` doesn't compile, because 42 isn't a String.

The same method now does something different on each call, depending on what it's given.

## Challenges that call your method

From here on, some challenges ask for a method, and the check calls it directly. The task card shows the call it makes, such as `countdown(3);`, and what that call must print. Your own `main` can call the method however you like: that's what **Run with my input** runs.

---

Source: [Parameters](https://javaarena.com/learn/methods/parameters/) in the module [Methods and parameters](https://javaarena.com/learn/methods/) on Java Arena.

This module follows section [2.4 Methods and dividing the program into smaller parts](https://java-programming.mooc.fi/part-2/4-methods) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
