> [!info] AI-Generated

# Putting it together, and the end of part 10

This last step of part 10 puts this module's tools side by side, and then looks back at the whole part.

## Which tool when

| You want to | Use | Instead of |
| --- | --- | --- |
| count down, or step by more than one | `for (int i = 10; i > 0; i -= 2)` | a counter in a `while` loop |
| use the positions of a list's values | `for` over the indexes | a for-each loop |
| build a text in a loop | `StringBuilder` and `append` | `+=` on a String |
| check the form of a string | `matches` and a regular expression | a loop with `charAt` |
| a value from a fixed set | an enum, compared with `==` | Strings or numbers that stand for the choices |
| remove elements while going through a collection | an `Iterator` and its `remove()` | removing inside a for-each loop |

The tools work well together. A regex check that a code has the right form can decide which enum constant the code stands for, a StringBuilder can build a report with a line for each constant in `values()`, and an iterator can clear out the objects that a report no longer needs. The challenges of this step do all of that, for the tickets of a music festival.

## The end of part 10

This step ends the material of the MOOC's tenth part. Module 37 brought streams: `stream()` and a chain of steps such as `filter`, `map`, `sorted` and `distinct`, ended by `count`, `sum`, `average`, `collect` or `forEach`, with lambda expressions and method references to say what each step does, and `reduce`, `IntStream` and the lines of a file as a stream. Module 38 put objects in order: a natural order with `Comparable` and `compareTo`, and any other order with a `Comparator`, built with `Comparator.comparing`, `thenComparing` and `reversed`. This module added a set of smaller tools: the for loop once more, StringBuilder, regular expressions, enums with fields and methods, and iterators. Part 11 comes next, starting with class diagrams. Part 10 ends with [the MOOC's summary page](https://java-programming.mooc.fi/part-10/4-summary) on its own site.

---

Source: [Putting it together, and the end of part 10](https://javaarena.com/learn/useful-techniques/end-of-part-10/) in the module [StringBuilder, regular expressions, enums and iterators](https://javaarena.com/learn/useful-techniques/) on Java Arena.

This module follows sections [10.3 Other useful techniques](https://java-programming.mooc.fi/part-10/3-other-useful-techniques), [10.4 Summary](https://java-programming.mooc.fi/part-10/4-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
