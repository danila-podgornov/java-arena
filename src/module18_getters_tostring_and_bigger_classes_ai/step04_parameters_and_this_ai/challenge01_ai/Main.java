// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step04_parameters_and_this_ai.challenge01_ai;

public class Main {
    /**
     * This program should print {@code Pancakes (20 min)}, but it prints {@code null (0 min)}. Fix the constructor of {@code Recipe}. The check creates {@code new Recipe("Pancakes", 20)} and prints it: see the expected output below.
     * Expected output
     * {@code Pancakes (20 min)}
     * Hints
     * 1. In {@code name = name;} both names mean the parameter, so the object's own {@code name} is never set.
     * 2. Write {@code this.} in front of the instance variables: {@code this.name = name;} and {@code this.minutes = minutes;}
     */
    public static void main(String[] args) {
        Recipe recipe = new Recipe("Pancakes", 20);
        System.out.println(recipe);
    }
}
