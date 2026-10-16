// AI-Generated
package module16_working_with_strings_ai.step01_strings_again_ai;

public class Challenge02Ai {
    /**
     * People type email addresses in all sorts of ways, with capitals and stray spaces. Write a method {@code cleanEmail(String email)} that returns the address without the spaces at the start and the end, and in small letters. The check runs {@code System.out.println("[" + cleanEmail("  Ada@Example.COM ") + "]");} and expects: see the expected output below.
     * Expected output
     * {@code [ada@example.com]}
     * Hints
     * 1. The method returns a String: <code>public static String cleanEmail(String email) {</code>.
     * 2. {@code trim()} and {@code toLowerCase()} each return a new string, so they can be chained: {@code return email.trim().toLowerCase();}
     */
    public static void main(String[] args) {
        System.out.println("[" + cleanEmail("  Ada@Example.COM ") + "]");
    }

    // Write the cleanEmail method here.
}
