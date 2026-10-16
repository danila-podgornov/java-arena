> [!info] AI-Generated

# Comparing with another object of the same class

A parameter can also be an object of the method's own class. That's how an object compares itself with another of its kind. Is this parcel heavier than that one?

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Parcel small = new Parcel("Lina", 400);
        Parcel big = new Parcel("Omar", 2500);
        System.out.println(big.isHeavierThan(small));
        System.out.println(small.isHeavierThan(big));
        System.out.println(small.isHeavierThan(small));
        System.out.println(big.gramsMoreThan(small));
    }
}
```

**Parcel.java**

```java
public class Parcel {
    private String recipient;
    private int grams;

    public Parcel(String recipient, int grams) {
        this.recipient = recipient;
        this.grams = grams;
    }

    public boolean isHeavierThan(Parcel other) {
        return this.grams > other.grams;
    }

    public int gramsMoreThan(Parcel other) {
        return this.grams - other.grams;
    }

    public String toString() {
        return "Parcel for " + this.recipient + ", " + this.grams + " g";
    }
}
```

**Output**

```text
true
false
false
2100
```

- In `big.isHeavierThan(small)`, `this` is `big`, the object before the dot, and `other` is `small`, the one in the parentheses. The method compares the two.
- `other.grams` reads the other parcel's private variable, and that's allowed. `private` means *only the code of the class Parcel*, not *only this object*: code written in Parcel may use the private variables of any Parcel. In `Main`, `small.grams` still doesn't compile.
- `small.isHeavierThan(small)` compares the parcel with itself, and a parcel isn't heavier than itself: `>` is false for equal weights. The same goes for two different parcels of the same weight: neither is heavier than the other.
- `gramsMoreThan` answers with a number instead of true or false: how many grams more this parcel weighs than the other one.

The parameter's name, `other`, is only a name: `compared` or `another` work just as well. If the class has getters, `other.getGrams()` works too, but inside the class, reading the variable directly is just as good.

## Letting the class compare

With `isHeavierThan`, finding the heaviest parcel in a list is the loop from module 19, but the comparison is the parcel's own method:

```java
Parcel heaviest = parcels.get(0);
for (Parcel parcel : parcels) {
    if (parcel.isHeavierThan(heaviest)) {
        heaviest = parcel;
    }
}
```

The loop doesn't need to know how parcels are compared, or even that they're weighed in grams. How to compare two parcels is written once, in the class, and every part of the program asks the class.

---

Source: [Comparing with another object of the same class](https://javaarena.com/learn/object-interaction/same-class-parameter/) in the module [Objects working together](https://javaarena.com/learn/object-interaction/) on Java Arena.

This module follows sections [5.4 Objects and references](https://java-programming.mooc.fi/part-5/4-objects-and-references), [5.5 Conclusion](https://java-programming.mooc.fi/part-5/5-conclusion) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
