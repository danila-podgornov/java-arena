// AI-Generated
package module54_libraries_maven_and_databases_ai.step05_packaging_other_tools_and_the_end_of_the_course_ai.challenge01_ai;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * The challenges of this step are a small review across the course. A pottery studio logs its kiln firings: {@code Firing.java} is ready. In {@code Main.java}, write the method {@code piecesAtLeast(List<Firing> firings, int degrees)}, which returns the names of the pieces fired at {@code degrees} or more, in the same order, as a new list. Use a stream: {@code filter}, {@code map} and {@code collect} (module 37). The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * [tall vase, tea bowl]
     * []
     * }</pre>
     * Hints
     * 1. {@code firings.stream()} gives a stream of Firing objects. {@code filter} keeps the ones whose {@code getDegrees()} is at least {@code degrees}, and {@code map} turns each into its {@code getPiece()}.
     * 2. End with {@code .collect(Collectors.toList())}, and import {@code java.util.stream.Collectors}.
     */
    public static void main(String[] args) {
        List<Firing> firings = new ArrayList<>();
        firings.add(new Firing("tall vase", 1240));
        firings.add(new Firing("bead set", 950));
        firings.add(new Firing("tea bowl", 1280));
        System.out.println(piecesAtLeast(firings, 1200));
        System.out.println(piecesAtLeast(firings, 1300));
    }

    public static List<String> piecesAtLeast(List<Firing> firings, int degrees) {
        return new ArrayList<>();
    }
}
