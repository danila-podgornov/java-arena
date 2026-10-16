// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step01_every_class_inherits_from_object_ai.challenge03_ai;

import java.util.Objects;

public class Mineral {
    private String name;
    private int hardness;

    public Mineral(String name, int hardness) {
        this.name = name;
        this.hardness = hardness;
    }

    public boolean equals(___ compared) {
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof Mineral)) {
            return false;
        }
        Mineral other = (Mineral) compared;
        return this.name.equals(other.name) && this.hardness == other.hardness;
    }

    public int hashCode() {
        return Objects.hash(this.name, this.hardness);
    }
}
