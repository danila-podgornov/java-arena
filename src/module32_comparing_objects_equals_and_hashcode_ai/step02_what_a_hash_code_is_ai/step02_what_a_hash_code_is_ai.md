> [!info] AI-Generated

# What a hash code is

## A number for every object

Every object has a method `hashCode()`, just as every object has `equals` and `toString`. It returns an `int` called the object's **hash code**: a number worked out from the object, a kind of short summary of it. Strings and Integers have a `hashCode` of their own:

```java
System.out.println("abc".hashCode());
System.out.println("Ada".hashCode());

String start = "Ad";
String built = start + "a";
System.out.println(built == "Ada");
System.out.println(built.equals("Ada"));
System.out.println(built.hashCode());

System.out.println(Integer.valueOf(2024).hashCode());
```

**Output**

```text
96354
65662
false
true
65662
2024
```

- A String's hash code is worked out from its characters. `built` is made while the program runs, so it's a different object from the `"Ada"` in the code, and `==` says `false`. But it has the same characters, so it's equal to `"Ada"`, and it has the same hash code.
- String's `hashCode` starts from 0 and, for each character in turn, multiplies what it has by 31 and adds the character's code. The codes of `a`, `b` and `c` are 97, 98 and 99, so for `"abc"`: 0 * 31 + 97 is 97, 97 * 31 + 98 is 3105, and 3105 * 31 + 99 is 96354. A String of one character has that character's code as its hash code.
- For longer Strings, the number soon grows past the largest `int` and wraps around (module 4), so a hash code can be any `int`, a negative one too. `"Oakdale".hashCode()` is -22733073.
- An Integer's hash code is its own value.

## How a hash map uses it

A hash map keeps its entries in many small groups, called **buckets**, and the key's hash code decides which bucket an entry goes into:

- `put(key, value)` works out the key's hash code, picks a bucket from it, and puts the key and the value there. If an equal key is in that bucket already, it replaces that key's value instead.
- `get(key)` works out the hash code of the key it's given, goes straight to that bucket, and looks only at the keys there. It compares a key with `equals` only when the two hash codes are the same.

So a lookup looks at a few keys, not at all of them, and a hash map finds a key about as fast among a million keys as among ten. A list's `contains` compares with every element in turn, like module 28's linear search.

Here's a picture of that with 8 buckets. One simple way to pick a bucket is the remainder of the hash code divided by the number of buckets. (Java's `HashMap` picks its bucket in a slightly different way, and adds more buckets as it grows, but the idea is the same.)

| Key | Hash code | Bucket: hash code % 8 |
| --- | --- | --- |
| `"Ada"` | 65662 | 6 |
| `"Ben"` | 66667 | 3 |
| `"Cy"` | 2198 | 6 |

`"Ada"` and `"Cy"` share bucket 6. `get("Cy")` goes to bucket 6, finds two keys there, and the hash codes and `equals` tell it which one is `"Cy"`. `get("Ben")` goes to bucket 3 and never looks at the other keys at all.

## Why the seats weren't found

Seat in step 1 has no `hashCode` of its own, so it has the one every class gets from Java. Like the `equals` every class gets, it knows nothing about rows and numbers: it gives, as far as it can, a different number to every object, even to two seats with the same values. Java makes no promise about those numbers: they can change from one run of the program to the next, and from one Java system to another. That's why this course never prints them.

So `new Seat("B", 7)` almost certainly has a different hash code from the B7 seat in the map. Nothing promises that, but in practice two objects hardly ever get the same default hash code. `get` looks in the bucket of the new hash code, and even if that happens to be the right bucket, the hash codes differ, so `equals` is never called: `null`. The second `put` went the same way: it found no equal key, so it added a second B7.

## The rule

For a hash map to work, `equals` and `hashCode` must agree. Java's documentation of `hashCode` sets out the rule:

- If two objects are equal according to `equals`, calling `hashCode` on each of them must give the same `int`.
- Two objects that aren't equal may have the same hash code. That's allowed, but different hash codes for different objects can make a hash map faster, since fewer keys share a bucket.
- Calling `hashCode` on the same object again, while the program runs, must give the same number, as long as nothing that `equals` compares has changed.

Seat breaks the first rule: its `equals` says two B7 seats are equal, but their default hash codes almost certainly differ. Strings and Integers follow it, as the program above showed with `built` and `"Ada"`. That's why module 31's String and Integer keys just worked.

The rule goes one way only. Equal objects must have equal hash codes, but equal hash codes don't make two objects equal. There are far more possible Strings than `int` values, so some different Strings must share a hash code. The last challenge of this step shows two of them.

That makes comparing hash codes a quick first check, which the MOOC calls **approximate comparison**: for a class that follows the rule, different hash codes mean that two objects aren't equal, and the same hash code means that they may be. Only `equals` gives the final answer. A hash map works this way: it calls `equals` only for keys whose hash code is the same.

---

Source: [What a hash code is](https://javaarena.com/learn/equals-hashcode/what-hashcode-is/) in the module [Comparing objects: equals and hashCode](https://javaarena.com/learn/equals-hashcode/) on Java Arena.

This module follows section [8.3 Similarity of objects](https://java-programming.mooc.fi/part-8/3-similarity-of-objects) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
