> [!info] AI-Generated

# Choosing a design, and the end of part 9

This last step of part 9 puts the pieces together: first how to choose between them when you design classes of your own, then a look back at the whole part.

## extends, abstract, or an interface?

Module 34 asked "is a, or has a?", and module 35 compared interfaces with abstract classes. With whole hierarchies in view, the choices look like this, with this module's examples:

| When | Use | Example |
| --- | --- | --- |
| Every X is a Y, and should get Y's code and data | `class X extends Y` | A Taxi is a Car, and gets its plate and its toll rule |
| Shared code, but no objects of the general kind | an abstract class | Employee keeps the name and the `toString`, and leaves `monthlyPay()` to each kind |
| Classes share an ability, but no code, or aren't otherwise related | an interface | Taxis and trucks are Commercial, and plain cars aren't |
| One class needs several roles | one superclass, and any number of interfaces | `Bat extends Enemy implements Flying` |

For the types of variables, parameters and lists, pick the most general type that has everything the code needs. Payroll takes any Employee, a company's bill needs only Commercial, and step 2's spear only needs to know whether an enemy is Flying. Code written in that way works with more classes, including ones that don't exist yet, like the interns of step 3.

## The end of part 9

This step ends the material of the MOOC's ninth part. Module 34 started from the class Object, which every class extends, and built classes on other classes with `extends`: `super(...)` for the superclass's constructor, overriding with `@Override` and `super.method()`, `protected`, "is a or has a", and abstract classes. Module 35 brought interfaces, lists of methods that a class promises with `implements`, used as the types of variables, parameters, return values and lists, and Java's own List, Map, Set and Collection. This module put them together. An object has every type of its hierarchy, `instanceof` asks which, and a cast gives a reference of the more specific type. A program built on a general type works with every kind of object, even kinds added later. Part 10 comes next, starting with streams and lambdas. Part 9 ends with [the MOOC's summary page](https://java-programming.mooc.fi/part-9/4-summary) on its own site.

---

Source: [Choosing a design, and the end of part 9](https://javaarena.com/learn/polymorphism/end-of-part-9/) in the module [Polymorphism](https://javaarena.com/learn/polymorphism/) on Java Arena.

This module follows sections [9.3 Object polymorphism](https://java-programming.mooc.fi/part-9/3-object-polymorphism), [9.4 Summary](https://java-programming.mooc.fi/part-9/4-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
