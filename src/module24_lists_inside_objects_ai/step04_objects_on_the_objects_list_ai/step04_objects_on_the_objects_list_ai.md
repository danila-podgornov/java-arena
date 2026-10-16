> [!info] AI-Generated

# Objects on the object's list

The list inside an object can hold objects of your own classes too. A bookshelf holds books, and each book has a title, an author and a number of pages. That makes a program of three files:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Bookshelf shelf = new Bookshelf("Living room");
        shelf.add(new Book("Emma", "Austen", 474));
        shelf.add(new Book("Persuasion", "Austen", 249));
        shelf.add(new Book("Dracula", "Stoker", 418));
        shelf.printAll();
        System.out.println("By Austen:");
        shelf.printBy("Austen");
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

    public void printAll() {
        System.out.println(this.room + ":");
        for (Book book : this.books) {
            System.out.println(book);
        }
    }

    public void printBy(String author) {
        for (Book book : this.books) {
            if (book.getAuthor().equals(author)) {
                System.out.println(book);
            }
        }
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
Living room:
Emma by Austen, 474 pages
Persuasion by Austen, 249 pages
Dracula by Stoker, 418 pages
By Austen:
Emma by Austen, 474 pages
Persuasion by Austen, 249 pages
```

- The list's type names the class of its objects: `ArrayList<Book>`. Only Book objects can go on it.
- `add(Book book)` takes an object as its parameter (module 23) and puts it on the list.
- In the loops, `book` is one Book at a time, and the shelf uses it through Book's public methods. `System.out.println(book)` calls the book's toString, and `book.getAuthor()` its getter. Writing `book.author` in Bookshelf doesn't compile, because `author` is private to Book.
- Each class does its own job. Book knows how a book is written out, and Bookshelf knows which books it holds. `main` only makes the books and calls the shelf's methods.

## The list holds references

The list doesn't hold copies of the books. Like any variable of a class type, each place on an `ArrayList<Book>` holds a reference to a Book object (module 22). So after

```java
Book emma = new Book("Emma", "Austen", 474);
shelf.add(emma);
```

the variable `emma` and the shelf's list refer to the same Book. If Book had a method that changed the book, a change made through `emma` would show on the shelf too, and the other way around.

## Making the object inside the method

A shelf could also take a book's values and make the Book itself. With module 21's overloading, both methods can be called `add`, and Java picks the one whose parameters match:

```java
public void add(String title, String author, int pages) {
    this.books.add(new Book(title, author, pages));
}
```

Then `shelf.add("Kindred", "Butler", 264);` works too, and `main` never has to make a Book.

---

Source: [Objects on the object's list](https://javaarena.com/learn/objects-with-lists/objects-on-the-list/) in the module [Lists inside objects](https://javaarena.com/learn/objects-with-lists/) on Java Arena.

This module follows section [6.1 Objects on a list and a list as part of an object](https://java-programming.mooc.fi/part-6/1-objects-within-objects) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
