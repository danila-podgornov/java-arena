> [!info] AI-Generated

# Returning from branches

A method can have several `return` statements, one in each branch. The first `return` that runs ends the method:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(result(72));
        System.out.println(result(35));
    }

    public static String result(int points) {
        if (points >= 50) {
            return "pass";
        }
        return "fail";
    }
}
```

**Output**

```text
pass
fail
```

For 72 the first `return` runs, and the method ends there. For 35 the `if` is skipped and the second `return` runs. No `else` is needed, because the method never gets past a `return`.

Java checks that every way through the method ends in a `return`. Without the last line, the method has no value to give back when the points are below 50, and it doesn't compile:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(result(72));
    }

    public static String result(int points) {
        if (points >= 50) {
            return "pass";
        }
    }
}
```

**What javac prints**

```text
Main.java:10: error: missing return statement
    }
    ^
1 error
```

---

Source: [Returning from branches](https://javaarena.com/learn/return-values/returning-from-branches/) in the module [Return values and the call stack](https://javaarena.com/learn/return-values/) on Java Arena.

This module follows sections [2.4 Methods and dividing the program into smaller parts](https://java-programming.mooc.fi/part-2/4-methods), [2.5 End questionnaire](https://java-programming.mooc.fi/part-2/5-end-questionnaire) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
