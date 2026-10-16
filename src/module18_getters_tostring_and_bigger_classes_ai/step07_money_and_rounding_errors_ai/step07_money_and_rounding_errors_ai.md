> [!info] AI-Generated

# Money and rounding errors

## Doubles aren't exact

Try adding a few small decimal numbers:

```java
System.out.println(0.1 + 0.2);
double total = 0.0;
for (int i = 0; i < 10; i++) {
    total = total + 0.1;
}
System.out.println(total);
System.out.println(total == 1.0);
```

**Output**

```text
0.30000000000000004
0.9999999999999999
false
```

A `double` stores its number in binary, with a fixed number of binary digits. Most decimal fractions, 0.1 among them, can't be written exactly that way, just as 1/3 can't be written exactly as a decimal number (0.3333...). So a double holds the closest number it can, which is off by a tiny amount. Usually the difference is too small to notice, but it can show after a single sum, as in `0.1 + 0.2`, and the errors add up as more values are summed, as in the loop. And `==` can say `false` for two doubles that should be equal.

For a temperature or a distance, errors that small don't matter. For money they do: a balance should never be a fraction of a cent off.

## Money in whole cents

The simple fix is to count money in its smallest unit, cents, and to keep it in an `int`: 2.50 euros is 250 cents. Adding and subtracting whole numbers is exact, as long as the result fits in an `int`: its largest value is 2147483647, so up to about 21 million euros in cents. (Java also has a class for exact decimal numbers, `BigDecimal`, but whole cents in an `int` are all this course needs.)

To show cents as euros, divide by 100 for the euros, and take what's left with `%` for the cents. The cents always need two digits: 205 cents is `2.05`, not `2.5`, so cents below 10 get a `0` in front. This print quota for a library printer keeps its balance that way:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        PrintQuota quota = new PrintQuota(500);
        System.out.println(quota);
        quota.printPages(7);
        System.out.println(quota);
        boolean printed = quota.printPages(30);
        System.out.println(printed);
        System.out.println(quota);
    }
}
```

**PrintQuota.java**

```java
public class PrintQuota {
    private int cents;

    public PrintQuota(int cents) {
        this.cents = cents;
    }

    public boolean printPages(int pages) {
        int cost = pages * 15;
        if (cost > this.cents) {
            return false;
        }
        this.cents = this.cents - cost;
        return true;
    }

    public String toString() {
        int euros = this.cents / 100;
        int rest = this.cents % 100;
        if (rest < 10) {
            return euros + ".0" + rest + " euros";
        }
        return euros + "." + rest + " euros";
    }
}
```

**Output**

```text
5.00 euros
3.95 euros
false
3.95 euros
```

- The balance is in cents, in an `int`. A page costs 15 cents, so 7 pages cost exactly 105 cents.
- `printPages` has a rule: it prints only when the balance covers the cost, so the balance never goes below zero. It returns `true` or `false`, so the caller knows whether it worked. 30 pages would cost 450 cents, more than the 395 left.
- Only `toString` shows the money as euros. Every calculation stays in whole cents.

---

Source: [Money and rounding errors](https://javaarena.com/learn/object-methods/money-and-rounding/) in the module [Getters, toString and bigger classes](https://javaarena.com/learn/object-methods/) on Java Arena.

This module follows section [4.1 Introduction to object-oriented programming](https://java-programming.mooc.fi/part-4/1-introduction-to-object-oriented-programming) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
