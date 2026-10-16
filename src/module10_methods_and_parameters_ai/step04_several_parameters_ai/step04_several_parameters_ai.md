> [!info] AI-Generated

# Several parameters

A method can have several parameters, separated by commas, each with its own type. The arguments in a call go to the parameters in order: the first to the first, the second to the second.

```java
public class Main {
    public static void main(String[] args) {
        printSum(3, 4);
        printSum(10, -2);
    }

    public static void printSum(int first, int second) {
        System.out.println(first + " + " + second + " = " + (first + second));
    }
}
```

**Output**

```text
3 + 4 = 7
10 + -2 = 8
```

A call must give exactly as many arguments as there are parameters, and of fitting types. With one argument missing, it doesn't compile:

```java
public class Main {
    public static void main(String[] args) {
        printSum(3);
    }

    public static void printSum(int first, int second) {
        System.out.println(first + " + " + second + " = " + (first + second));
    }
}
```

**What javac prints**

```text
Main.java:3: error: method printSum in class Main cannot be applied to given types;
        printSum(3);
        ^
  required: int,int
  found:    int
  reason: actual and formal argument lists differ in length
1 error
```

`required` is what the method's parameters need, and `found` is what the call gave. The parameters can have different types too: `printPrice(String item, double price)` is called as `printPrice("Tea", 2.5)`.

---

Source: [Several parameters](https://javaarena.com/learn/methods/several-parameters/) in the module [Methods and parameters](https://javaarena.com/learn/methods/) on Java Arena.

This module follows section [2.4 Methods and dividing the program into smaller parts](https://java-programming.mooc.fi/part-2/4-methods) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
