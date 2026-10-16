// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step04_overriding_methods_override_and_super_ai.challenge03_ai;

import java.util.Objects;

public class Magazine {
    private String title;
    private int issue;

    public Magazine(String title, int issue) {
        this.title = title;
        this.issue = issue;
    }

    public boolean equals(Magazine other) {
        return this.title.equals(other.title) && this.issue == other.issue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.title, this.issue);
    }

    @Override
    public String toString() {
        return this.title + " #" + this.issue;
    }
}
