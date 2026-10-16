> [!info] AI-Generated

# Most specific condition first

When conditions overlap, the order of an `else if` chain decides the answer, and the most specific case has to come first. The classic example is **FizzBuzz**: print `Fizz` for multiples of 3, `Buzz` for multiples of 5, `FizzBuzz` for multiples of both, and the number itself otherwise.

```java
int number = 15;
if (number % 3 == 0 && number % 5 == 0) {
    System.out.println("FizzBuzz");
} else if (number % 3 == 0) {
    System.out.println("Fizz");
} else if (number % 5 == 0) {
    System.out.println("Buzz");
} else {
    System.out.println(number);
}
```

**Output**

```text
FizzBuzz
```

15 is a multiple of 3, so if the `number % 3 == 0` check came first, it would print `Fizz` and never reach the combined case. Checking "both" first works, because every later branch can then assume that "both" was false.

---

Source: [Most specific condition first](https://javaarena.com/learn/boolean-logic/specific-first/) in the module [Conditions and logic](https://javaarena.com/learn/boolean-logic/) on Java Arena.

This module follows sections [1.6 Conditional statements and conditional operation](https://java-programming.mooc.fi/part-1/6-conditional-statements), [1.7 Programming in our society](https://java-programming.mooc.fi/part-1/7-programming-in-our-society) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
