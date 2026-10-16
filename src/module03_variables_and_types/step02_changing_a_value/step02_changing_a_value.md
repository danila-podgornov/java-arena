> [!info] AI-Generated

# Changing a value

A variable's value can change while the program runs. To give an existing variable a new value, write its name, `=` and the value, without the type in front:

```java
int lives = 3;
System.out.println("Lives: " + lives);
lives = 2;
System.out.println("Lives: " + lives);
```

**Output**

```text
Lives: 3
Lives: 2
```

The `=` here means "put this value into the variable", not "is equal to". The old value is gone after the assignment.

## Create once, change many times

The type is written only once, when the variable is created. Writing it again creates a second variable with the same name, which Java doesn't allow:

```java
public class Main {
    public static void main(String[] args) {
        int points = 10;
        int points = 25;
        System.out.println(points);
    }
}
```

**What javac prints**

```text
Main.java:4: error: variable points is already defined in method main(String[])
        int points = 25;
            ^
1 error
```

And the type stays the same for the variable's whole life: an `int` variable can't later hold text. `age = "twenty";` fails with `incompatible types: String cannot be converted to int`.

---

Source: [Changing a value](https://javaarena.com/learn/variables/changing-values/) in the module [Variables and types](https://javaarena.com/learn/variables/) on Java Arena.

This module follows section [1.4 Variables](https://java-programming.mooc.fi/part-1/4-variables) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
