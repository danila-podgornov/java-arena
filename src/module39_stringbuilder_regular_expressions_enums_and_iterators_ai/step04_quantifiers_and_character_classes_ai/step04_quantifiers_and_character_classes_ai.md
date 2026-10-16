> [!info] AI-Generated

# Quantifiers and character classes

Step 3's regexes described texts of a fixed length. Most formats have parts that repeat: a postcode is five digits, a PIN four to six, and a name any number of letters. Two more tools describe them: quantifiers and character classes.

## Quantifiers

A **quantifier** goes after a character, or after a group, and says how many times it may come:

| Quantifier | How many times | Example | Matches | Doesn't match |
| --- | --- | --- | --- | --- |
| `*` | any number, zero too | `hm*` | h, hm, hmmm | hmh |
| `+` | at least once | `go+al` | goal, gooooal | gal |
| `?` | zero times or once: it's optional | `colou?r` | color, colour | colouur |
| `{3}` | exactly 3 | `z{3}` | zzz | zz, zzzz |
| `{2,4}` | from 2 to 4 | `a{2,4}` | aa, aaa, aaaa | a, aaaaa |
| `{2,}` | 2 or more | `a{2,}` | aa, aaaaaaa | a |

Without parentheses, a quantifier repeats only the one character right before it. `ha+` is an h followed by one or more a's, and `(ha)+` is ha, once or more:

```java
System.out.println("haaa".matches("ha+"));
System.out.println("haaa".matches("(ha)+"));
System.out.println("hahaha".matches("(ha)+"));
System.out.println("gal".matches("go*al"));
```

**Output**

```text
true
false
true
true
```

`go*al` allows zero o's, so gal matches it, but not `go+al`.

## Character classes

Square brackets make a **character class**. It matches one character, any of the ones inside: `[aeiou]` is one vowel. A dash between two characters gives a range: `[0-9]` is one digit, `[a-z]` one lowercase letter, `[A-Z]` one capital letter, and `[a-zA-Z]` a letter of either kind.

With a quantifier, a class describes a whole format. A US ZIP code is five digits, sometimes followed by a dash and four more digits (the ZIP+4 form, such as 10001-4356):

```java
String zip = "[0-9]{5}(-[0-9]{4})?";
String[] codes = {"90210", "10001-4356", "9021", "90210-", "9021O"};
for (String code : codes) {
    System.out.println(code + " " + code.matches(zip));
}
```

**Output**

```text
90210 true
10001-4356 true
9021 false
90210- false
9021O false
```

- `[0-9]{5}` is five digits.
- `(-[0-9]{4})?` is a group of a dash and four digits, and the `?` makes the whole group optional. A dash outside square brackets is just a dash.
- `90210-` has the dash, but not the four digits that must come with it.
- `9021O` ends with the capital letter O, which isn't in `[0-9]`.

## Times of day

Sometimes a class isn't enough by itself, and a group with `|` does the rest. A time on a 24-hour clock is written like 07:45 or 23:05. The hours go from 00 to 23: a 0 or a 1 followed by any digit, or a 2 followed by a digit from 0 to 3. The minutes go from 00 to 59:

```java
String time = "([01][0-9]|2[0-3]):[0-5][0-9]";
System.out.println("07:45".matches(time));
System.out.println("23:05".matches(time));
System.out.println("24:00".matches(time));
System.out.println("7:45".matches(time));
System.out.println("12:60".matches(time));
```

**Output**

```text
true
true
false
false
false
```

The group holds the two ways to write an hour, and the colon stands for itself.

## A few more

- A dot `.` matches any one character, so `.*` matches any text on one line: `"b.*"` matches every one-line string that starts with b.
- `\\d` in a Java String is a shorter way to write `[0-9]`, so `"\\d{5}"` is five digits.
- To match a real dot, write `"\\."`. Module 16's `split` takes a regular expression too, so `split(".")` splits at every character, not just at the dots (a dot means any character), but `split("\\.")` splits only at the dots.

---

Source: [Quantifiers and character classes](https://javaarena.com/learn/useful-techniques/quantifiers/) in the module [StringBuilder, regular expressions, enums and iterators](https://javaarena.com/learn/useful-techniques/) on Java Arena.

This module follows sections [10.3 Other useful techniques](https://java-programming.mooc.fi/part-10/3-other-useful-techniques), [10.4 Summary](https://java-programming.mooc.fi/part-10/4-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
