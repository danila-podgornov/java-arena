> [!info] AI-Generated

# Printing an object that holds a list

`System.out.println(shelf)` calls the shelf's toString (module 18). For an object that holds a list, the list belongs in that text too. The shortest way joins the list itself to the text:

```java
public String toString() {
    return this.room + ": " + this.books;
}
```

The list writes itself out in brackets, with each book's own toString and commas between them: `Hallway: [Emma by Austen, 474 pages, Dracula by Stoker, 418 pages]`. That's hard to read when the books' texts have commas of their own. A loop gives you full control over the text.

## Building the text in a loop

This toString starts with the room and the number of books, and then adds each book on a line of its own:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Bookshelf shelf = new Bookshelf("Living room");
        shelf.add(new Book("Emma", "Austen", 474));
        shelf.add(new Book("Persuasion", "Austen", 249));
        shelf.add(new Book("Dracula", "Stoker", 418));
        System.out.println(shelf);
        Bookshelf empty = new Bookshelf("Hallway");
        System.out.println(empty);
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

    public String toString() {
        if (this.books.isEmpty()) {
            return this.room + ": no books";
        }
        String text = this.room + ": " + this.books.size() + " books";
        for (Book book : this.books) {
            text = text + "\n" + book;
        }
        return text;
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

    public String toString() {
        return this.title + " by " + this.author + ", " + this.pages + " pages";
    }
}
```

**Output**

```text
Living room: 3 books
Emma by Austen, 474 pages
Persuasion by Austen, 249 pages
Dracula by Stoker, 418 pages
Hallway: no books
```

- You met `\n` in module 20: inside a String, it's a **line break**. A String can hold several lines, and printing it prints each of them on its own line.
- `text` starts as the first line, and each round of the loop adds a line break and one book. `+ book` calls the book's own toString.
- The line break goes *before* each book, not after it, so the text doesn't end with an empty line. `println` adds the last line break itself.
- An empty shelf gets its own text, checked first with `isEmpty()`. Without that check it would say `Hallway: 0 books`, which is fine too. What an empty object says is part of designing the class.

toString only builds the text and returns it; it doesn't print anything. The caller decides what to do with it: `System.out.println(shelf)` prints it, and `"Found: " + shelf` makes a longer String of it.

---

Source: [Printing an object that holds a list](https://javaarena.com/learn/objects-with-lists/printing-the-owner/) in the module [Lists inside objects](https://javaarena.com/learn/objects-with-lists/) on Java Arena.

This module follows section [6.1 Objects on a list and a list as part of an object](https://java-programming.mooc.fi/part-6/1-objects-within-objects) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
