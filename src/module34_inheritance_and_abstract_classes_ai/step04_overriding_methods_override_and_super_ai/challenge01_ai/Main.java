// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step04_overriding_methods_override_and_super_ai.challenge01_ai;

public class Main {
    /**
     * The library also lends audiobooks, for 14 days. {@code LibraryItem.java} is ready. In {@code Audiobook.java}, override two methods, each with {@code @Override} above it:
     * <ul>
     * <li>{@code loanDays()}, which returns 14
     * <li>{@code toString()}, which returns LibraryItem's text, followed by {@code , read by } and the narrator's name. LibraryItem has no getter for the year, so use {@code super.toString()}.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Audiobook audio = new Audiobook("Salt and Stars", 2016, "Ruth Obi");
     * System.out.println(audio);
     * System.out.println(audio.loanDays());
     * LibraryItem novel = new LibraryItem("The Quiet Harbor", 2019);
     * System.out.println(novel + ", " + novel.loanDays() + " days");
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Salt and Stars (2016), read by Ruth Obi
     * 14
     * The Quiet Harbor (2019), 21 days
     * }</pre>
     * Hints
     * 1. Each method has {@code @Override} on the line above it, and the same header as LibraryItem's: {@code public int loanDays()} and {@code public String toString()}.
     * 2. {@code toString} returns {@code super.toString() + ", read by " + this.narrator}. {@code super.toString()} gives LibraryItem's text, title and year.
     */
    public static void main(String[] args) {
        Audiobook audio = new Audiobook("Salt and Stars", 2016, "Ruth Obi");
        System.out.println(audio);
        System.out.println(audio.loanDays());
        LibraryItem novel = new LibraryItem("The Quiet Harbor", 2019);
        System.out.println(novel + ", " + novel.loanDays() + " days");
    }
}
