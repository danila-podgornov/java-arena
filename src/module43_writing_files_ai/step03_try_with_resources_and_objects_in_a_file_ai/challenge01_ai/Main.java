// AI-Generated
package module43_writing_files_ai.step03_try_with_resources_and_objects_in_a_file_ai.challenge01_ai;

import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {
    /**
     * A teacher exports a course's gradebook for a spreadsheet. {@code StudentRecord.java} is ready: a record has the student's name and the points of the exam and of the project, and {@code total()} returns their sum. In {@code Main.java}, write the method {@code export(ArrayList<StudentRecord> records, String fileName)}, which writes the file: first the header line {@code name,exam,project,total}, and then one line for each record, in the list's order, with its four values separated by commas. Write the file in a try-with-resources, and let the method pass exceptions on with {@code throws Exception}. It prints nothing.
     * <p>The check exports the three records of {@code main} into {@code grades.csv}, and after it the file should hold:
     * <pre>{@code
     * name,exam,project,total
     * Ada,38,45,83
     * Linus,29,40,69
     * Grace,41,50,91
     * }</pre>
     * Hints
     * 1. The header is <code>public static void export(ArrayList&lt;StudentRecord&gt; records, String fileName) throws Exception {</code>, and inside it goes {@code try (PrintWriter writer = new PrintWriter(fileName)) { ... }}.
     * 2. In the {@code try} block, {@code println} the header line once, and then loop over the records: {@code writer.println(record.getName() + "," + record.getExam() + "," + record.getProject() + "," + record.total());}.
     */
    public static void main(String[] args) throws Exception {
        ArrayList<StudentRecord> records = new ArrayList<>();
        records.add(new StudentRecord("Ada", 38, 45));
        records.add(new StudentRecord("Linus", 29, 40));
        records.add(new StudentRecord("Grace", 41, 50));
        export(records, "grades.csv");
    }

    // Write the method export here.
}
