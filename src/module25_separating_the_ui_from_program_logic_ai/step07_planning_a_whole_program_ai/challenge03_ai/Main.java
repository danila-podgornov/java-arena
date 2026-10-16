// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step07_planning_a_whole_program_ai.challenge03_ai;

public class Main {
    /**
     * A library card program, all of it: {@code LibraryCard.java}, {@code UserInterface.java} and {@code Main.java}.
     * <p>{@code LibraryCard} holds the titles of the books borrowed on the card, and a limit to how many books can be borrowed at a time. Its methods:
     * <ul>
     * <li>{@code LibraryCard(int limit)}: a card with no books, for at most {@code limit} books at a time.
     * <li>{@code has(String title)}: returns {@code true} when that book is borrowed on the card.
     * <li>{@code isFull()}: returns {@code true} when {@code limit} books are borrowed.
     * <li>{@code borrow(String title)}: adds the book to the card. The user interface only calls it when the card isn't full and doesn't have the book.
     * <li>{@code giveBack(String title)}: removes the book and returns {@code true}, or returns {@code false} if it isn't on the card.
     * <li>{@code books()}: returns the titles, an {@code ArrayList<String>}, in the order they were borrowed.
     * </ul>
     * <p>{@code UserInterface} takes a {@code Scanner} and a {@code LibraryCard}, and {@code start()} reads commands, with the prompt {@code > } before each one:
     * <ul>
     * <li>{@code borrow}, then a line with a title: print {@code You already have } and the title when the card has it, otherwise {@code Your card is full} when it's full, and otherwise borrow the book and print {@code Borrowed } and the title.
     * <li>{@code return}, then a line with a title: give the book back and print {@code Returned } and the title, or print the title and {@code  isn't on your card}.
     * <li>{@code books}: print {@code Books: } and the list of titles.
     * <li>{@code quit}: print {@code See you soon} and return.
     * <li>Anything else: print {@code Unknown command: } and the command.
     * </ul>
     * <p>{@code main} creates a card with the limit 3 and starts the user interface. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Borrowed Emma
     * > Borrowed Dune
     * > You already have Emma
     * > Borrowed Ivanhoe
     * > Your card is full
     * > Returned Dune
     * > Dune isn't on your card
     * > Borrowed Beloved
     * > Books: [Emma, Ivanhoe, Beloved]
     * > See you soon
     * }</pre>
     * Hints
     * 1. Follow the plan: {@code LibraryCard} first, with a list of titles and the limit as instance variables. {@code has} is the list's {@code contains}, {@code isFull} compares the list's {@code size()} with the limit, and {@code giveBack} checks {@code contains} before removing.
     * 2. The {@code borrow} command is an {@code if}, {@code else if}, {@code else}: first {@code this.card.has(title)}, then {@code this.card.isFull()}, and only then {@code this.card.borrow(title)}. {@code main} is the same four lines as in the other programs with a UserInterface class, with {@code new LibraryCard(3)}.
     */
    public static void main(String[] args) {
        // Create the objects and start the user interface.
    }
}
