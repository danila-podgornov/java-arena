// AI-Generated
package module16_working_with_strings_ai.step04_finding_parts_of_a_string_ai;

public class Challenge03Ai {
    /**
     * Write a method {@code fileKind(String fileName)} that returns {@code image} for names that end in {@code .jpg} or {@code .png}, {@code document} for names that end in {@code .pdf} or {@code .txt}, and {@code other} for anything else. Capitals don't matter: {@code Beach.JPG} is an image. The check runs {@code System.out.println(fileKind("Beach.JPG"));} and expects: see the expected output below.
     * Expected output
     * {@code image}
     * Hints
     * 1. Make the name small first: {@code String name = fileName.toLowerCase();}. Then {@code .JPG} becomes {@code .jpg}.
     * 2. {@code if (name.endsWith(".jpg") || name.endsWith(".png")) { return "image"; }}, the same for documents, and {@code return "other";} last.
     */
    public static void main(String[] args) {
        System.out.println(fileKind("Beach.JPG"));
    }

    // Write the fileKind method here.
}
