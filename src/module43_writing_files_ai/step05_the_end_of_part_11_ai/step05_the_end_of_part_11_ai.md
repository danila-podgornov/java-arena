> [!info] AI-Generated

# The end of part 11

This step ends this module, and with it the MOOC's part 11. First a look back at the whole part, and then a last program that puts its class diagrams, exceptions and files to work together.

## What part 11 covered

- **Module 40, class diagrams.** A UML class diagram shows a program's classes as boxes: the name, the fields, and the constructors and methods, with `-` for private and `+` for public, and the types after colons. An arrow shows that one class refers to another, with a multiplicity such as `1`, `0..1` or `*` at its end, and a line with a hollow triangle shows inheritance, dashed for a class that implements an interface. You wrote classes from boxes, and drew boxes from classes.
- **Module 41, packages.** Classes are grouped in packages, which are folders: a file in `quiz/domain/` starts with `package quiz.domain;`. A class of another package is used by its full name or after an `import`, and from another package a class sees only what's `public` (and a subclass also what's `protected`). Larger programs split their classes into packages by what they're responsible for, such as `domain`, `logic` and `ui`.
- **Module 42, exceptions.** `try` and `catch`, several `catch` blocks and `finally`; checked exceptions, which must be caught or declared with `throws`, and unchecked ones, which needn't be; try-with-resources; `throw new IllegalArgumentException(...)` to refuse a bad parameter; and reading a stack trace.
- **Module 43, writing files.** A PrintWriter writes a file and replaces what it held, a FileWriter with `true` appends to it, and `close()`, or better a try-with-resources, makes sure the text reaches the file. Objects go into a file one per line, with a separator that reading can split at, and a class with `save` and `load` keeps its data from one run to the next.

## Other ways to write

Java has more ways to write a file than PrintWriter. One is `Files.write`, the writing twin of module 42's `Files.readAllLines`: `Files.write(Paths.get("todo.txt"), tasks)` writes every String of the list `tasks` into the file, one per line, in a single call. This course sticks with PrintWriter, which works just like `System.out`, but you may meet the others in code that other people write.

## The end of part 11

Part 12 comes next, starting with type parameters (generics): classes of your own that take a type as a parameter, as ArrayList does in `ArrayList<String>`. Part 11 ends with [the MOOC's conclusion page](https://java-programming.mooc.fi/part-11/5-conclusion) on its own site.

---

Source: [The end of part 11](https://javaarena.com/learn/writing-files/end-of-part-11/) in the module [Writing files](https://javaarena.com/learn/writing-files/) on Java Arena.

This module follows sections [11.4 Processing files](https://java-programming.mooc.fi/part-11/4-processing-files), [11.5 Conclusion](https://java-programming.mooc.fi/part-11/5-conclusion) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
