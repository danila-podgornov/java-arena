> [!info] AI-Generated

# Procedural programs

You've written programs in two different styles already. Up to module 16, a program was `main` and a few static methods. From module 17 on, programs were made of objects too. This module gives the two styles their names, writes the same programs in both, and looks honestly at what each one makes easy.

## What a paradigm is

A **programming paradigm** is a style of programming: a set of ideas about what a program is made of and how its parts work together. Two programs can print exactly the same thing and still follow different paradigms. Many languages support more than one paradigm, and Java is one of them.

Module 21 already named one paradigm, **object-oriented programming**: a program is built from objects, and each object looks after its own data. This step is about another one.

## Procedural programming

In **procedural programming**, a program is a sequence of steps, run one after another. The data is kept in variables, and the work is split into **procedures**: named pieces of code that get the data they need as parameters and may hand back a result. In Java, a procedure is a method, usually a `static` method like the ones in module 10. The data and the methods stay apart: a method knows only what it's given, and the caller decides what to do with any answer it hands back. The C language, for example, is built around this style.

Here's a program that keeps track of how far someone has read in a book, written procedurally:

```java
public class Main {
    public static void main(String[] args) {
        String title = "The Salt Road";
        int pages = 240;
        int page = 0;

        page = read(page, 60, pages);
        page = read(page, 100, pages);
        printProgress(title, page, pages);

        page = read(page, 120, pages);
        printProgress(title, page, pages);
    }

    public static int read(int page, int count, int pages) {
        page = page + count;
        if (page > pages) {
            page = pages;
        }
        return page;
    }

    public static void printProgress(String title, int page, int pages) {
        int percent = 100 * page / pages;
        System.out.println(title + ": page " + page + " of " + pages + ", " + percent + "% read");
    }
}
```

**Output**

```text
The Salt Road: page 160 of 240, 66% read
The Salt Road: page 240 of 240, 100% read
```

- `main` keeps the book's data in three local variables, and runs from top to bottom: read 60 pages, read 100 more, print, read 120 more, print.
- `read` works out which page the reader is on after reading `count` more pages. It gets everything it needs as parameters, and it keeps a rule of the problem: nobody reads past the last page, so the third call stops at 240.
- `read` can't change the variable `page` of `main`, because a parameter gets a copy of the value (module 22). So it returns the new page, and `main` stores it: `page = read(page, 60, pages);`.
- `printProgress` gets everything it prints as parameters too. `100 * page / pages` divides whole numbers, so 160 of 240 pages is 66%, with the decimals dropped.

## Strengths and weak spots

For a program this small, the procedural style is hard to beat. It all happens in `main`, in the order it's written, and each method is a small calculation that's easy to check on its own: `read(200, 60, 240)` returns 240, whatever the rest of the program does.

The weak spots show up as a program grows:

- The title, the number of pages and the page reached belong together, but only their names say so. Every method that needs them has to be handed them one by one.
- The rule "not past the last page" is in `read`, but nothing makes `main` use `read`. The line `page = page + 500;` compiles and runs, and then the reader is on page 660 of a 240-page book.
- A call without `page =` in front of it, like `read(page, 60, pages);`, compiles too. It works out the new page and throws it away, and the program goes on as if nothing had been read.
- A second book needs three more variables, and every call has to be given the right ones.

The next step writes the same program with an object, and comes back to these weak spots.

---

Source: [Procedural programs](https://javaarena.com/learn/paradigms/procedural/) in the module [Procedural and object-oriented programs](https://javaarena.com/learn/paradigms/) on Java Arena.

This module follows section [7.1 Programming paradigms](https://java-programming.mooc.fi/part-7/1-programming-paradigms) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
