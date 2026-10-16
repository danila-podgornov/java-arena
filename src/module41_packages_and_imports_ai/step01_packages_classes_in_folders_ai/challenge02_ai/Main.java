// AI-Generated
package module41_packages_and_imports_ai.step01_packages_classes_in_folders_ai.challenge02_ai;

public class Main {
    /**
     * A school has lockers in its halls and in its gym, and its program has two classes called {@code Locker}: one in the default package, next to {@code Main}, and one in the package {@code school.gym}. What does this program print?
     * Hints
     * 1. {@code Locker} on its own, with no package, means the Locker of Main's own package: the default one, in {@code Locker.java} at the top. The full name {@code school.gym.Locker} means the other class.
     * 2. {@code getName()} gives the full name of the object's class: with its package for the gym's locker, and just {@code Locker} for the class in the default package.
     */
    public static void main(String[] args) {
        module41_packages_and_imports_ai.step01_packages_classes_in_folders_ai.challenge02_ai.school.gym.Locker gymLocker = new module41_packages_and_imports_ai.step01_packages_classes_in_folders_ai.challenge02_ai.school.gym.Locker(14);
        Locker hallLocker = new Locker(14);
        gymLocker.lock();
        System.out.println(gymLocker);
        System.out.println(hallLocker);
        System.out.println(gymLocker.getClass().getName());
        System.out.println(hallLocker.getClass().getName());
    }
}
