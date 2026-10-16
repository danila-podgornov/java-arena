> [!info] AI-Generated

# The call stack

When a method calls another, Java has to remember where to come back to. It keeps a **call stack**: a pile of the methods that are running right now. A call puts the new method on top, with its own parameters and variables. When that method returns, it's taken off the pile, and the method below carries on right after the call.

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("main starts");
        int result = half(10);
        System.out.println("main got " + result);
    }

    public static int half(int number) {
        System.out.println("half starts with " + number);
        return number / 2;
    }
}
```

**Output**

```text
main starts
half starts with 10
main got 5
```

While `half` runs, the stack holds `half` on top of `main`. `main` is paused in the middle of the line `int result = half(10);`, and it finishes that line with the returned 5.

You may have seen the call stack already: when a program crashes, Java prints it. Here `share` divides by zero:

```text
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at Main.share(Main.java:8)
	at Main.main(Main.java:4)
```

Each `at` line is one method on the stack, with the line it was on, the top one first: the crash happened in `share` on line 8, which was called from `main` on line 4.

The challenges in this step are for tracing: follow the calls and the returns, and write down what's printed, in order.

---

Source: [The call stack](https://javaarena.com/learn/return-values/the-call-stack/) in the module [Return values and the call stack](https://javaarena.com/learn/return-values/) on Java Arena.

This module follows sections [2.4 Methods and dividing the program into smaller parts](https://java-programming.mooc.fi/part-2/4-methods), [2.5 End questionnaire](https://java-programming.mooc.fi/part-2/5-end-questionnaire) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
