// AI-Generated
package module20_reading_files_ai.step02_files_and_folders_ai;

public class Challenge03Ai {
    /**
     * A path is text, so the String methods work on it. What does this program print?
     * Hints
     * 1. Splitting at {@code /} gives three parts: {@code school}, {@code biology} and {@code cells.txt}. The last part is the file, the others are folders.
     * 2. {@code parts[parts.length - 2]} is the part just before the file: the folder the file is in.
     */
    public static void main(String[] args) {
        String path = "school/biology/cells.txt";
        String[] parts = path.split("/");
        String name = parts[parts.length - 1];
        System.out.println("Folders: " + (parts.length - 1));
        System.out.println("File: " + name);
        System.out.println("In: " + parts[parts.length - 2]);
        System.out.println(name.endsWith(".txt"));
    }
}
