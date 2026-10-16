> [!info] AI-Generated

# Finding an object on the list

A method can also go through the list to find one object and return it: the largest, or the first one that matches. Its return type is then the class of the objects. When there's nothing to return, it returns `null`, "no object" (module 22):

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Bookshelf shelf = new Bookshelf("Study");
        shelf.add(new Book("Emma", "Austen", 474));
        shelf.add(new Book("Kindred", "Butler", 264));
        shelf.add(new Book("Middlemarch", "Eliot", 880));
        System.out.println("Thickest: " + shelf.thickest());
        Book found = shelf.find("Kindred");
        if (found != null) {
            System.out.println("Found it, by " + found.getAuthor());
        }
        if (shelf.find("Ulysses") == null) {
            System.out.println("No Ulysses here");
        }
        Bookshelf hall = new Bookshelf("Hallway");
        System.out.println(hall.thickest());
    }
}
```

**Bookshelf.java**

```java
import java.util.ArrayList;

public class Bookshelf {
    private String room;
    private ArrayList<Book> books;

    public Bookshelf(String room) {
        this.room = room;
        this.books = new ArrayList<>();
    }

    public void add(Book book) {
        this.books.add(book);
    }

    public Book thickest() {
        if (this.books.isEmpty()) {
            return null;
        }
        Book thickest = this.books.get(0);
        for (Book book : this.books) {
            if (book.getPages() > thickest.getPages()) {
                thickest = book;
            }
        }
        return thickest;
    }

    public Book find(String title) {
        for (Book book : this.books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
}
```

**Book.java**

```java
public class Book {
    private String title;
    private String author;
    private int pages;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getPages() {
        return this.pages;
    }

    public String toString() {
        return this.title + " by " + this.author + ", " + this.pages + " pages";
    }
}
```

**Output**

```text
Thickest: Middlemarch by Eliot, 880 pages
Found it, by Butler
No Ulysses here
null
```

- `thickest` keeps the thickest book so far in a local variable of type Book, starting with the first book on the list. Each book with more pages takes its place. This is module 13's search for the largest value, with objects: the pages decide, but the whole Book is kept.
- Starting from `this.books.get(0)` needs a first book, so the empty check comes first. Without it, `get(0)` on an empty list would crash with an IndexOutOfBoundsException.
- With `>`, a book takes the kept one's place only when it's thicker, so of two equally thick books, the first one wins. With `>=`, the last one would.
- `find` returns the book as soon as it finds it, which also ends the loop. `return null` after the loop runs only when no book matched.

## Checking the result

A method that may return `null` puts a job on its caller: check before using the result. `found.getAuthor()` would crash with a NullPointerException if `found` were `null`, so `main` checks `found != null` first. Printing a `null` is fine, though: `System.out.println(hall.thickest())` prints `null`.

The method returns the object itself, not a copy. `shelf.find("Emma") == shelf.find("Emma")` is `true`: both calls return a reference to the one Book on the shelf. So if Book could change, a change made through the returned reference would change the book on the shelf.

---

Source: [Finding an object on the list](https://javaarena.com/learn/objects-with-lists/finding-an-object/) in the module [Lists inside objects](https://javaarena.com/learn/objects-with-lists/) on Java Arena.

This module follows section [6.1 Objects on a list and a list as part of an object](https://java-programming.mooc.fi/part-6/1-objects-within-objects) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
