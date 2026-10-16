// AI-Generated
package module55_recursion_ai.step03_recursion_on_strings_and_arrays_ai;

public class Challenge02Ai {
    /**
     * A word game gives bonus points for palindromes, words that read the same backwards, such as {@code kayak} or {@code noon}. Write the method {@code isPalindrome(String word)} with recursion and no loop: a word is a palindrome if its first and last characters are the same and the part between them is a palindrome. A word of 0 or 1 characters is always a palindrome. {@code word.substring(1, word.length() - 1)} is the part between the ends: {@code isPalindrome} itself calls itself on it, not through a helper method. Don't reverse the word: compare its ends. The check runs:
     * <pre>{@code
     * System.out.println(isPalindrome("kayak"));
     * System.out.println(isPalindrome("noon"));
     * System.out.println(isPalindrome("kayaks"));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * true
     * false
     * }</pre>
     * Hints
     * 1. Two base cases: a word of at most one character is a palindrome ({@code true}), and a word whose first and last characters differ isn't ({@code false}).
     * 2. If the ends are equal, the answer is the answer for the middle: {@code return isPalindrome(word.substring(1, word.length() - 1));}
     */
    public static void main(String[] args) {
        System.out.println(isPalindrome("kayak"));
        System.out.println(isPalindrome("noon"));
        System.out.println(isPalindrome("kayaks"));
    }

    // Write the method isPalindrome here.
}
