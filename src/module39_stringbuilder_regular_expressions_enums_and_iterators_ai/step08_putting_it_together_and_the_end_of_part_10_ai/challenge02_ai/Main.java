// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step08_putting_it_together_and_the_end_of_part_10_ai.challenge02_ai;

public class Main {
    /**
     * The festival's passes once more. What does this program print?
     * Hints
     * 1. The loop appends the first letters of DAY, WEEKEND and BACKSTAGE. {@code reverse()} turns the builder itself around and returns it, so it's printed reversed, and it stays reversed for the next line.
     * 2. The code is the three letters, a dash and 0042: {@code [A-Z]+} allows any number of capital letters, but {@code [DWB]} is exactly one. The last loop takes indexes 2 and 0, BACKSTAGE and DAY.
     */
    public static void main(String[] args) {
        StringBuilder line = new StringBuilder();
        for (Pass pass : Pass.values()) {
            line.append(pass.name().charAt(0));
        }
        System.out.println(line.reverse());
        String code = line + "-0042";
        System.out.println(code.matches("[A-Z]+-[0-9]{4}") + " " + code.matches("[DWB]-[0-9]+"));
        int total = 0;
        for (int i = Pass.values().length - 1; i >= 0; i -= 2) {
            total += Pass.values()[i].getPrice();
        }
        System.out.println(total);
    }
}
