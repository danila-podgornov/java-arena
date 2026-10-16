// AI-Generated
package module43_writing_files_ai.step03_try_with_resources_and_objects_in_a_file_ai.challenge01_ai;

public class StudentRecord {
    private String name;
    private int exam;
    private int project;

    public StudentRecord(String name, int exam, int project) {
        this.name = name;
        this.exam = exam;
        this.project = project;
    }

    public String getName() {
        return this.name;
    }

    public int getExam() {
        return this.exam;
    }

    public int getProject() {
        return this.project;
    }

    public int total() {
        return this.exam + this.project;
    }
}
