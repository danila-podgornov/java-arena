// AI-Generated
package module41_packages_and_imports_ai.step01_packages_classes_in_folders_ai.challenge02_ai.school.gym;

public class Locker {
    private int number;
    private boolean locked;

    public Locker(int number) {
        this.number = number;
        this.locked = false;
    }

    public void lock() {
        this.locked = true;
    }

    @Override
    public String toString() {
        if (this.locked) {
            return "Gym locker " + this.number + ", locked";
        }
        return "Gym locker " + this.number + ", open";
    }
}
