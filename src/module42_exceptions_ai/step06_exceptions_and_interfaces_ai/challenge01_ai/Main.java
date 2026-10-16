// AI-Generated
package module42_exceptions_ai.step06_exceptions_and_interfaces_ai.challenge01_ai;

public class Main {
    /**
     * A door can also keep a short list of codes in memory. {@code DoorCodes.java} is ready. In {@code CodeList.java}, write the class {@code CodeList}, which implements DoorCodes, with:
     * <ul>
     * <li>a constructor with no parameters; a new CodeList has no codes
     * <li>{@code add(String code)}, which adds a code to the list
     * <li>{@code isValid(String code)}, with {@code @Override}, which returns {@code true} if the code is on the list
     * </ul>
     * <p>A list in memory can't fail to be read, so leave out the {@code throws}. {@code Main.java} calls {@code isValid} through a CodeList variable without a {@code try}, so it only compiles when CodeList's {@code isValid} throws nothing checked. The check runs:
     * <pre>{@code
     * CodeList codes = new CodeList();
     * codes.add("1357");
     * codes.add("8642");
     * System.out.println(codes.isValid("8642"));
     * System.out.println(codes.isValid("1234"));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * false
     * }</pre>
     * Hints
     * 1. Start with <code>public class CodeList implements DoorCodes {</code>, with an {@code ArrayList<String>} as the instance variable, created in the constructor. The class needs {@code import java.util.ArrayList;}.
     * 2. The header is {@code public boolean isValid(String code)}, with no {@code throws}. A list's {@code contains} tells whether the code is on it.
     */
    public static void main(String[] args) {
        CodeList codes = new CodeList();
        codes.add("1357");
        codes.add("8642");
        System.out.println(codes.isValid("8642"));
        System.out.println(codes.isValid("1234"));
    }
}
