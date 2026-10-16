> [!info] AI-Generated

# Variables inside methods

A variable made inside a method belongs to that method: it's a **local variable**. It exists while the method runs and disappears when the method ends. Other methods can't see it, not even `main`. The same goes for parameters.

```java
public class Main {
    public static void main(String[] args) {
        addTax(100);
        System.out.println(withTax);
    }

    public static double addTax(double price) {
        double withTax = price * 1.25;
        return withTax;
    }
}
```

**What javac prints**

```text
Main.java:4: error: cannot find symbol
        System.out.println(withTax);
                           ^
  symbol:   variable withTax
  location: class Main
1 error
```

`withTax` lives only inside `addTax`. To get its value out, use the return value: store what the call returns in a variable of `main`'s own.

```java
public class Main {
    public static void main(String[] args) {
        double withTax = addTax(100);
        System.out.println(withTax);
    }

    public static double addTax(double price) {
        double withTax = price * 1.25;
        return withTax;
    }
}
```

**Output**

```text
125.0
```

The two `withTax` variables are different variables that happen to share a name, one in each method.

Another mistake gives the same `cannot find symbol` error: using a method's name without the parentheses and arguments, as `square` instead of `square(5)`. Without them, Java looks for a variable called `square`.

---

Source: [Variables inside methods](https://javaarena.com/learn/return-values/variables-inside-methods/) in the module [Return values and the call stack](https://javaarena.com/learn/return-values/) on Java Arena.

This module follows sections [2.4 Methods and dividing the program into smaller parts](https://java-programming.mooc.fi/part-2/4-methods), [2.5 End questionnaire](https://java-programming.mooc.fi/part-2/5-end-questionnaire) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
