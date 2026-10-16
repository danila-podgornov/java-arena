// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step08_abstract_classes_and_abstract_methods_ai.challenge03_ai;

public class Main {
    /**
     * Now write an abstract class yourself. The library's films and audiobooks are ready in {@code Film.java} and {@code Audiobook.java}: each extends {@code LibraryItem}, hands its title to {@code super(title)}, and overrides {@code loanDays()}. In {@code LibraryItem.java}, write the abstract class {@code LibraryItem}, with:
     * <ul>
     * <li>a private title, and a constructor {@code LibraryItem(String title)}
     * <li>{@code getTitle()}
     * <li>an abstract method {@code int loanDays()}
     * <li>{@code dueDay(int today)}, which returns the number of the day the item is due back: today's number plus the item's loan days
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * LibraryItem film = new Film("Night Train");
     * LibraryItem audio = new Audiobook("Salt and Stars");
     * System.out.println(film.getTitle() + ": day " + film.dueDay(10));
     * System.out.println(audio.getTitle() + ": day " + audio.dueDay(10));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Night Train: day 17
     * Salt and Stars: day 24
     * }</pre>
     * Hints
     * 1. The header is <code>public abstract class LibraryItem {</code>. The title, the constructor and {@code getTitle()} are as in any class.
     * 2. The abstract method is {@code public abstract int loanDays();}, with no body. {@code dueDay} returns {@code today + this.loanDays()}, and each object's own {@code loanDays} runs.
     */
    public static void main(String[] args) {
        LibraryItem film = new Film("Night Train");
        LibraryItem audio = new Audiobook("Salt and Stars");
        System.out.println(film.getTitle() + ": day " + film.dueDay(10));
        System.out.println(audio.getTitle() + ": day " + audio.dueDay(10));
    }
}
