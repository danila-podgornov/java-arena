> [!info] AI-Generated

# Totals from the objects on the list

A class that holds a list of objects can answer questions about all of them together: how many pages the books have in all, how long they are on average, how many pages one author wrote. Each answer is a loop over the list:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Bookshelf shelf = new Bookshelf("Study");
        shelf.add(new Book("Emma", "Austen", 474));
        shelf.add(new Book("Persuasion", "Austen", 249));
        shelf.add(new Book("Dracula", "Stoker", 418));
        shelf.add(new Book("Kindred", "Butler", 264));
        System.out.println("Pages: " + shelf.totalPages());
        System.out.println("Average: " + shelf.averagePages());
        System.out.println("By Austen: " + shelf.pagesBy("Austen"));
        Bookshelf empty = new Bookshelf("Hallway");
        System.out.println("Pages: " + empty.totalPages());
        System.out.println("Average: " + empty.averagePages());
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

    public int totalPages() {
        int total = 0;
        for (Book book : this.books) {
            total = total + book.getPages();
        }
        return total;
    }

    public double averagePages() {
        if (this.books.isEmpty()) {
            return 0;
        }
        return (double) this.totalPages() / this.books.size();
    }

    public int pagesBy(String author) {
        int total = 0;
        for (Book book : this.books) {
            if (book.getAuthor().equals(author)) {
                total = total + book.getPages();
            }
        }
        return total;
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

    public String getAuthor() {
        return this.author;
    }

    public int getPages() {
        return this.pages;
    }
}
```

**Output**

```text
Pages: 1405
Average: 351.25
By Austen: 723
Pages: 0
Average: 0.0
```

- `totalPages` is the sum pattern you know, over the shelf's own list: a local variable starts at 0, and each book adds its pages to it.
- `averagePages` doesn't write the loop again. It calls the object's own `totalPages()` with `this.` (module 18), and divides by the number of books. The `(double)` makes the division keep its decimals (module 4). Without it, `1405 / 4` would be `351`.
- The empty check comes first. With no books, the division would be 0 divided by 0, which for a `double` gives `NaN`, "not a number". Returning 0 is the choice made here, and since the method returns a `double`, it comes out as `0.0`.
- `pagesBy` is a total with a condition: only the books that match add their pages.

## Counted when asked, not kept

The shelf could keep the total in an instance variable of its own, and add to it in `add`. But then every method that changes the list, such as one that removes books, would have to remember to change the total too, and one that forgets makes it wrong. Counting from the list each time can't go out of date: the list is always right, so the total is too.

---

Source: [Totals from the objects on the list](https://javaarena.com/learn/objects-with-lists/totals-from-the-list/) in the module [Lists inside objects](https://javaarena.com/learn/objects-with-lists/) on Java Arena.

This module follows section [6.1 Objects on a list and a list as part of an object](https://java-programming.mooc.fi/part-6/1-objects-within-objects) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
