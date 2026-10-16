// AI-Generated
package module54_libraries_maven_and_databases_ai.step01_build_tools_maven_and_a_projects_layout_ai;

public class Challenge03Ai {
    /**
     * In Maven's local repository, a library's jar is in folders named after its coordinates, as the lesson showed. What does this program print?
     * Hints
     * 1. Only the groupId's dots become slashes. The version keeps its dots, and so does the artifactId (it has none here).
     * 2. {@code junit} has no dots, so its folder is just {@code junit}, then the artifactId's folder {@code junit}, then the version's folder, then the jar's name.
     */
    public static void main(String[] args) {
        System.out.println(jarPath("junit:junit:4.13.2"));
        System.out.println(jarPath("org.hamcrest:hamcrest-core:1.3"));
    }

    public static String jarPath(String coordinates) {
        String[] parts = coordinates.split(":");
        String group = parts[0].replace(".", "/");
        String artifact = parts[1];
        String version = parts[2];
        return group + "/" + artifact + "/" + version + "/" + artifact + "-" + version + ".jar";
    }
}
