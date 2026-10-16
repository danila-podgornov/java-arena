// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step04_overriding_methods_override_and_super_ai.challenge01_ai;

public class LibraryItem {
    private String title;
    private int year;

    public LibraryItem(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return this.title;
    }

    public int loanDays() {
        return 21;
    }

    @Override
    public String toString() {
        return this.title + " (" + this.year + ")";
    }
}
