> [!info] AI-Generated

# Building a loop program

A larger program is easier to write in stages: get a small part working, check it, then add the next feature. Each stage is a working program, so when something breaks, it's in the part you just added.

The three challenges here build one program. It reads the step counts of a fitness tracker, one day per line, until `-1`.

1. First it only adds up the steps.
2. Then it also counts the days and works out the average.
3. Finally it counts the days that reached a goal, and finds the best day.

Every stage uses a pattern you've met: a `while (true)` loop that stops at `-1`, and a variable before the loop for each thing the program keeps track of. When a later stage adds a feature, it adds a variable before the loop, a line inside it, and a print after it; the rest stays as it was.

Finding the best day is new: keep a `best` variable, and whenever a day beats it, replace it (`if (steps > best) { best = steps; }`). Start it at 0, since step counts are never negative.

---

Source: [Building a loop program](https://javaarena.com/learn/for-loops/building-a-loop-program/) in the module [Loop conditions and for](https://javaarena.com/learn/for-loops/) on Java Arena.

This module follows section [2.3 More loops](https://java-programming.mooc.fi/part-2/3-more-loops) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
