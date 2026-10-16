// AI-Generated
package module54_libraries_maven_and_databases_ai.step01_build_tools_maven_and_a_projects_layout_ai;

public class Challenge01Ai {
    /**
     * A small tool for a project prints where a class's file goes in a Maven project. Fill in the blanks so that {@code sourcePath} returns the path of a class's file from its full name: {@code src/main/java}, then the package's folders, then the class's name and {@code .java}. The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * src/main/java/com/example/repairs/Main.java
     * src/main/java/com/example/repairs/RepairJob.java
     * }</pre>
     * Hints
     * 1. The program's own classes go in {@code src/main/java} (the tests in {@code src/test/java}). After it comes one folder for each part of the package name.
     * 2. The dots of {@code com.example.repairs.Main} become the slashes of {@code com/example/repairs/Main}: that's {@code className.replace(".", "/")}.
     */
    public static void main(String[] args) {
        System.out.println(sourcePath("com.example.repairs.Main"));
        System.out.println(sourcePath("com.example.repairs.RepairJob"));
    }

    public static String sourcePath(String className) {
        return "___/" + className.___(".", "/") + ".java";
    }
}
