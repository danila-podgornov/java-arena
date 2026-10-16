// AI-Generated
package module55_recursion_ai.step03_recursion_on_strings_and_arrays_ai;

public class Challenge01Ai {
    /**
     * An ambulance has its name painted backwards on its hood, so that drivers ahead read it the right way around in their mirrors. Write the method {@code reverse(String text)}, which returns the text backwards, with recursion and no loop: the reverse of a text is the reverse of its rest ({@code text.substring(1)}) followed by its first character. Don't use {@code StringBuilder}. The check runs:
     * <pre>{@code
     * System.out.println(reverse("AMBULANCE"));
     * System.out.println(reverse("stressed"));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * ECNALUBMA
     * desserts
     * }</pre>
     * Hints
     * 1. The base case: the reverse of the empty string is the empty string.
     * 2. For any other text, reverse the rest and put the first character after it: {@code return reverse(text.substring(1)) + text.charAt(0);}
     */
    public static void main(String[] args) {
        System.out.println(reverse("AMBULANCE"));
        System.out.println(reverse("stressed"));
    }

    public static String reverse(String text) {
        return text;
    }
}
