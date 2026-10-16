// AI-Generated
package module43_writing_files_ai.step05_the_end_of_part_11_ai.challenge01_ai;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Notebook {
    private ArrayList<Note> notes;

    public Notebook() {
        this.notes = new ArrayList<>();
    }

    public void add(Note note) {
        this.notes.add(note);
    }

    public int count() {
        return this.notes.size();
    }

    public void printAll() {
        for (Note note : this.notes) {
            System.out.println(note);
        }
    }

    // Write the methods save and load here.
}
