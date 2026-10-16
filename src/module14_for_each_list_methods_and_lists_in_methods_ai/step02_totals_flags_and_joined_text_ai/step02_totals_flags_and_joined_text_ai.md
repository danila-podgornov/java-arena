> [!info] AI-Generated

# Totals, flags and joined text

In the last module you added up a list with an index loop. With a for-each loop it's shorter, because there's no index to keep track of:

```java
ArrayList<Integer> pages = new ArrayList<>();
pages.add(12);
pages.add(30);
pages.add(18);

int total = 0;
for (int count : pages) {
    total += count;
}
System.out.println("Pages read: " + total);
System.out.println("Per day: " + (double) total / pages.size());
```

**Output**

```text
Pages read: 60
Per day: 20.0
```

Averages and counts work just as before; only the loop is new. This step adds two more things a loop over a list often has to work out: a yes-or-no answer about all the values, and one line of text made from them.

## Does every value pass? A flag

Some questions are about the whole list: is every value valid? Is any value negative? A `boolean` variable answers them. It's called a **flag**: it starts with the answer that holds until some value proves otherwise, and the loop changes it when a value does.

```java
ArrayList<Integer> ages = new ArrayList<>();
ages.add(19);
ages.add(23);
ages.add(17);
ages.add(30);

boolean allAdults = true;
for (int age : ages) {
    if (age < 18) {
        allAdults = false;
    }
}

if (allAdults) {
    System.out.println("Everyone is 18 or over");
} else {
    System.out.println("Someone is under 18");
}
```

**Output**

```text
Someone is under 18
```

One age under 18 is enough to make the flag `false`, and nothing sets it back to `true`. That's why the `if` in the loop has no `else`: with `else { allAdults = true; }`, only the last age would decide, and here the 30 would hide the 17.

For "is there any ...?", turn it around: start the flag at `false`, and set it to `true` when a value matches.

## Joining values into one line

Text can be built in a loop, as in module 11: start from `""` and add each value with `+=`. To put a separator between the values, but not in front of the first one, check whether the text is still empty:

```java
ArrayList<String> stops = new ArrayList<>();
stops.add("Home");
stops.add("Park");
stops.add("School");

String route = "";
for (String stop : stops) {
    if (!route.equals("")) {
        route += " > ";
    }
    route += stop;
}
System.out.println(route);
```

**Output**

```text
Home > Park > School
```

In the first round `route` is still empty, so no separator goes in. From then on, each stop gets one in front of it.

---

Source: [Totals, flags and joined text](https://javaarena.com/learn/list-methods/totals-flags-and-text/) in the module [For-each, list methods and lists in methods](https://javaarena.com/learn/list-methods/) on Java Arena.

This module follows section [3.2 Lists](https://java-programming.mooc.fi/part-3/2-lists) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
