// AI-Generated
package module43_writing_files_ai.step05_the_end_of_part_11_ai.challenge01_ai;

public class Main {
    /**
     * A last program for part 11: a notes app that keeps its notes in a file, one note per line, with the note's title and text separated by {@code ;}, like {@code Door code;4417}. Here's its plan:
     * <pre>{@code
     * class Notebook
     * + Notebook()
     * + add(note: Note): void
     * + count(): int
     * + printAll(): void
     * + save(fileName: String): void
     * + load(fileName: String): void
     *
     * class Note
     * - title: String
     * - text: String
     * + Note(title: String, text: String)
     * + getTitle(): String
     * + getText(): String
     * + toString(): String
     *
     * Notebook --> * Note : notes
     * }</pre>
     * <p>Most of it is written. What's left:
     * <ul>
     * <li>In {@code Note.java}, a title with a {@code ;} in it would break the file's format, so the constructor refuses one: it throws an IllegalArgumentException with the message {@code a title can't contain ;}. A note's text may contain {@code ;}.
     * <li>In {@code Notebook.java}, {@code save} writes every note as its title, {@code ;} and its text, one per line, replacing what the file held. {@code load} reads such a file and adds a note for each line to the notebook. The title ends at the line's first {@code ;}, and everything after that {@code ;} is the text. Both pass exceptions on with {@code throws Exception}.
     * </ul>
     * <p>A note prints as its title, a colon and its text. The check loads the file shown below, adds a shopping note, saves the notebook into the same file and prints every note:
     * <pre>{@code
     * Wifi: the password is on the router
     * Door code: 4417
     * Shopping: milk; eggs; bread
     * }</pre>
     * <p>and {@code notes.txt} then holds the three notes, the new one as {@code Shopping;milk; eggs; bread}.
     * Hints
     * 1. Note's constructor checks the title with {@code contains} and throws before it stores anything. {@code save} works like TodoList's {@code save} in step 4, writing the title, a {@code ;} and the text of each note. {@code load} needs only the line's first {@code ;}, since the text may contain more.
     * 2. In Note's constructor: {@code if (title.contains(";")) { throw new IllegalArgumentException("a title can't contain ;"); }}. {@code save} writes {@code note.getTitle() + ";" + note.getText()}. {@code load} can't use {@code split(";")}, since the text may contain {@code ;} too. Find the first one with {@code int at = line.indexOf(";");}: the title is {@code line.substring(0, at)}, and the text is {@code line.substring(at + 1)}.
     */
    public static void main(String[] args) throws Exception {
        Notebook notebook = new Notebook();
        notebook.load("notes.txt");
        notebook.add(new Note("Shopping", "milk; eggs; bread"));
        notebook.save("notes.txt");
        notebook.printAll();
    }
}
