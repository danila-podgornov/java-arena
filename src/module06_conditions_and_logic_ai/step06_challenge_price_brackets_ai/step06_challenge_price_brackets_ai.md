> [!info] AI-Generated

# Challenge: price brackets

Many real calculations work in **brackets**: one rule up to some amount, another rule above it. A long `else if` chain handles them well. Each branch covers one bracket, and because the chain stops at the first true condition, each branch can assume the earlier brackets didn't match.

```java
int weight = 7;
int price;
if (weight <= 2) {
    price = 5;
} else if (weight <= 10) {
    price = 5 + (weight - 2) * 2;
} else {
    price = 21 + (weight - 10);
}
System.out.println("Price: " + price);
```

**Output**

```text
Price: 15
```

The price is set in every branch, so after the chain it always has a value. (`int price;` creates the variable without a value; Java checks that every path gives it one before it's used.)

## The end of part 1

This step ends the material of the MOOC's first part. Its last section, [Programming in our society](https://java-programming.mooc.fi/part-1/7-programming-in-our-society), is a short read, with no exercises, about how much everyday life (communication, shopping, travel) runs on software, and how programmers are responsible for making it work well for everyone who uses it, including people who aren't used to computers.

---

Source: [Challenge: price brackets](https://javaarena.com/learn/boolean-logic/price-brackets/) in the module [Conditions and logic](https://javaarena.com/learn/boolean-logic/) on Java Arena.

This module follows sections [1.6 Conditional statements and conditional operation](https://java-programming.mooc.fi/part-1/6-conditional-statements), [1.7 Programming in our society](https://java-programming.mooc.fi/part-1/7-programming-in-our-society) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
