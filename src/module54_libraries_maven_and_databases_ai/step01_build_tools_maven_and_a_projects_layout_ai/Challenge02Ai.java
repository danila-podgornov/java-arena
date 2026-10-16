// AI-Generated
package module54_libraries_maven_and_databases_ai.step01_build_tools_maven_and_a_projects_layout_ai;

public class Challenge02Ai {
    /**
     * Library pages often give a dependency as one line of coordinates, {@code group:artifact:version}, and sometimes a fourth part, the scope: {@code junit:junit:4.13.2:test}. Write the method {@code printDependency(String coordinates)}, which prints the {@code dependency} element for pom.xml, with its parts on lines of their own, indented by 4 spaces:
     * <ul>
     * <li>{@code <dependency>}
     * <li>the groupId, the artifactId and the version, each in its element
     * <li>only when the coordinates have a fourth part: the scope in a {@code scope} element
     * <li>{@code </dependency>}
     * </ul>
     * <p>The program calls it for {@code com.h2database:h2:2.2.224} and prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * <dependency>
     *     <groupId>com.h2database</groupId>
     *     <artifactId>h2</artifactId>
     *     <version>2.2.224</version>
     * </dependency>
     * }</pre>
     * Hints
     * 1. {@code coordinates.split(":")} gives the parts in an array: the groupId at index 0, the artifactId at 1 and the version at 2.
     * 2. The array's {@code length} is 4 when there's a scope. Print its line only then, between the version and {@code </dependency>}.
     */
    public static void main(String[] args) {
        printDependency("com.h2database:h2:2.2.224");
    }

    public static void printDependency(String coordinates) {

    }
}
