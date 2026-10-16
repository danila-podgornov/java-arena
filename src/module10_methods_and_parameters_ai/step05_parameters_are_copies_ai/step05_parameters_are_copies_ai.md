> [!info] AI-Generated

# Parameters are copies

When a method is called, each parameter gets a **copy** of the argument's value. The method can change its parameter, but that changes only its own copy:

```java
public class Main {
    public static void main(String[] args) {
        int score = 10;
        doubleIt(score);
        System.out.println("In main: " + score);
    }

    public static void doubleIt(int score) {
        score = score * 2;
        System.out.println("In the method: " + score);
    }
}
```

**Output**

```text
In the method: 20
In main: 10
```

Both variables are called `score`, but they're two different variables: each method has its own. The name used in the call doesn't matter either. Only the value is passed on, so `doubleIt(score)`, `doubleIt(10)` and `doubleIt(5 + 5)` all do the same.

To get a value back out of a method, the method has to **return** it. That's the next module. (For objects, such as lists, there's more to the story; the module on primitive and reference variables tells it.)

---

Source: [Parameters are copies](https://javaarena.com/learn/methods/parameters-are-copies/) in the module [Methods and parameters](https://javaarena.com/learn/methods/) on Java Arena.

This module follows section [2.4 Methods and dividing the program into smaller parts](https://java-programming.mooc.fi/part-2/4-methods) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
