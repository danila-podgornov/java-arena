// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step04_parameters_and_this_ai.challenge03_ai;

public class Main {
    /**
     * What does this program print? Look closely at which variables each method changes.
     * Hints
     * 1. In {@code rename}, both {@code name}s are the parameter: the method changes only its own copy, so the badge keeps the name {@code Mia}.
     * 2. {@code levelUp} uses {@code this.level}, so it does change the badge: 1 + 2 is 3.
     */
    public static void main(String[] args) {
        Badge badge = new Badge("Mia");
        badge.rename("Zoe");
        System.out.println(badge);
        badge.levelUp(2);
        badge.rename("Ola");
        System.out.println(badge);
    }
}
