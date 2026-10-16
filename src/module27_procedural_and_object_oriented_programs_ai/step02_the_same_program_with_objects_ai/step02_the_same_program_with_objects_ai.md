> [!info] AI-Generated

# The same program with objects

Here's the reading program of the previous step once more, written with an object. The book's data, and the rule that guards it, move into a class, `Book`. `main` only creates a book and uses it:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Book book = new Book("The Salt Road", 240);
        book.read(60);
        book.read(100);
        System.out.println(book);

        book.read(120);
        System.out.println(book);
    }
}
```

**Book.java**

```java
public class Book {
    private String title;
    private int pages;
    private int page;

    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
        this.page = 0;
    }

    public void read(int count) {
        this.page = this.page + count;
        if (this.page > this.pages) {
            this.page = this.pages;
        }
    }

    public String toString() {
        int percent = 100 * this.page / this.pages;
        return this.title + ": page " + this.page + " of " + this.pages + ", " + percent + "% read";
    }
}
```

**Output**

```text
The Salt Road: page 160 of 240, 66% read
The Salt Road: page 240 of 240, 100% read
```

It prints exactly what the procedural version printed. Here's what moved where:

- The three local variables of `main` became the instance variables of `Book`. The data that belongs together is now in one object, and it's `private`, so only the code of `Book` can change it.
- `read` takes one parameter, the number of pages read. It finds the rest in its own object, as `this.page` and `this.pages`. It changes the object itself and returns nothing, so there's no result to forget to store.
- `printProgress` became `toString`, which builds the same line from the object's own data.
- The rule "not past the last page" is still in `read`, and now nothing can get around it. `book.page = 900;` in `main` doesn't compile, because `page` is private: javac says `page has private access in Book`. The only way to move the bookmark is `read`.
- `main` reads like a description of what happens: a book, 60 pages read, then 100 more.

## What each version makes easy

Neither version is wrong. They print the same lines, and each makes different things easy:

| | Procedural | Object-oriented |
| --- | --- | --- |
| Where the data is | local variables in `main` | instance variables of an object |
| How a method gets the data | as parameters, one by one | from its own object, with `this` |
| How a change is kept | the method returns the new value, and the caller stores it | the method changes the object |
| Who can get around the rule | any code that has the variables | only the code of the class |
| A second book | three more variables | one more `new Book(...)` |

- The procedural version is shorter: no class, no constructor, no `this`. It reads from top to bottom in one file, and every value a method uses is right there in its call. For a small program that runs once from start to end, that's often the simplest choice.
- The object version has more lines, but each part has one job. The book's data and its rule are in one place, and no other code can get around the rule. As the program grows, with more books or more things to do with a book, `main` stays short and the rules stay in `Book`.

## Java and paradigms

Java is mainly an object-oriented language: every method belongs to a class, and even `main` sits in the class `Main`. But the code inside the methods is usually procedural: statements that run one after another, with ifs and loops, just as in module 1. A program made only of `main` and static methods, like the one in the previous step, is a procedural program that happens to sit in a class. So in Java, the real question is how much of a program to organize into objects. The last step of this module comes back to that.

---

Source: [The same program with objects](https://javaarena.com/learn/paradigms/with-objects/) in the module [Procedural and object-oriented programs](https://javaarena.com/learn/paradigms/) on Java Arena.

This module follows section [7.1 Programming paradigms](https://java-programming.mooc.fi/part-7/1-programming-paradigms) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
