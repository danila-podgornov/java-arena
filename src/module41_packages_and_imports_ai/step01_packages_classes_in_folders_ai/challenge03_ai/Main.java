// AI-Generated
package module41_packages_and_imports_ai.step01_packages_classes_in_folders_ai.challenge03_ai;

public class Main {
    /**
     * A beekeeper's program keeps its classes in the folder {@code apiary/domain/}, for the package {@code apiary.domain}, but it doesn't compile: the package lines of both files are wrong. {@code Hive.java} has none, and {@code Harvest.java} names only part of the package. javac prints many messages for this. The telling one is {@code file does not contain class apiary.domain.Hive}: javac looked for the class in the folder of its package, and found a file whose package line is missing or says something else.
     * <p>Fix the first line of code of each file so that it matches the file's folder. In {@code Hive.java}, the package line comes first, before the import. Don't change {@code Main.java}. The program should print: see the expected output below.
     * Expected output
     * <pre>{@code
     * Linden: 2 harvests, 7300 grams
     * apiary.domain.Hive
     * }</pre>
     * Hints
     * 1. Both files are in the folder {@code apiary/domain/}, so both start with the same line: {@code package apiary.domain;}. {@code package apiary;} would be right only for a file in the folder {@code apiary/} itself.
     * 2. In {@code Hive.java}, put {@code package apiary.domain;} on the very first line, above {@code import java.util.ArrayList;}. Hive uses Harvest without an import: once both are in {@code apiary.domain}, they're in the same package.
     */
    public static void main(String[] args) {
        module41_packages_and_imports_ai.step01_packages_classes_in_folders_ai.challenge03_ai.apiary.domain.Hive hive = new module41_packages_and_imports_ai.step01_packages_classes_in_folders_ai.challenge03_ai.apiary.domain.Hive("Linden");
        hive.add(new module41_packages_and_imports_ai.step01_packages_classes_in_folders_ai.challenge03_ai.apiary.domain.Harvest("June", 4200));
        hive.add(new module41_packages_and_imports_ai.step01_packages_classes_in_folders_ai.challenge03_ai.apiary.domain.Harvest("August", 3100));
        System.out.println(hive);
        System.out.println(hive.getClass().getName());
    }
}
